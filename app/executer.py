import os
import time
import secrets
import subprocess

from os import path, walk
from antlr4 import *

from app.visitors.extractor import Extractor
from app.visitors.renamer import Renamer
from app.visitors.encryptor import Encryptor
from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser

"""
    -  Class:
        -  Executer - Main class for the Java obfuscator.

    - Main Methods:
        - execute(self)
            Perform the obfuscation process, including entity extraction, renaming, and encryption.

        - extractEnteties(self)
            Extract entities from Java source files, including new file names and package configurations.

        - renameEnteties(self)
            Rename entities in Java source files based on the extracted information.

        - encryptEnteties(self)
            Encrypt entities in Java source files.
    - Utitlity Methods:
        - writeOutput(self, filePath, fileName, newFileName)
            Write the obfuscated output to new Java files.

        - extractFilePaths(self, path)
            Extract file paths and names from the specified directory.

        - readJavaFile(self, filepath)
            Read the content of a Java file.

        - runJavaFile(self, path, keyAndIV, pathToSave, passArray)
            Compile and run the obfuscated Java files.
"""


class Executer:
    """
    -  Constructor:
        - Initializes the `Executer` instance with the `projectName`.
            projectName (str): Name of the project.

        Attributes:
            projectName (str): Name of the project.
            projectPath (str): Path to the project.
            filePaths (list): List of file paths.
            fileNames (list): List of file names.
            fileNewNamesDict (dict): Dictionary to store new file names.
            filePackageConfDict (dict): Dictionary to store relatedFiles  for each file.
            filesTokenStreamDict (dict): Dictionary to store token streams for each file.
            key : the secret key for the pre-compile encryption  for the whole project.
            iv : the iv hex used for  pre-compile encryption for the whole project.
    """

    def __init__(self, projectName):
        self.projectName = projectName
        self.projectPath = os.path.join(
            os.path.dirname(__file__), "benchmarks", self.projectName, "main"
        )
        self.filePaths = []
        self.fileNames = []
        self.projectPackages = []
        self.fileNewNamesDict = {}
        self.filesRelatedFilesDict = {}
        self.filesTokenStreamDict = {}
        self.iv = secrets.token_bytes(16).hex()
        self.key = secrets.token_bytes(16).hex()

    def execute(self):
        # extracting file names and paths
        file_paths_arr, file_names_arr = self.extractFilePaths(self.projectPath)
        self.filePaths = file_paths_arr
        self.fileNames = file_names_arr

        print("\nStarting......\n")

        # extraction step
        print("Making the table ...")
        startingTime = time.time()
        self.extractEnteties()
        endingTime = time.time()
        print(f"Table made in {endingTime - startingTime}\n")

        # renaming step
        print("Renaming Begin ...")
        startingTime = time.time()
        self.renameEnteties()
        endingTime = time.time()
        print(f"Renamed in   {endingTime - startingTime}\n")

        # encryption step
        print("Encrypting Begin ...")
        startingTime = time.time()
        self.encryptEnteties()
        endingTime = time.time()
        print(f"Encrypted in   {endingTime - startingTime}\n")

        # write the final output and import the neccasry files for cryptographty
        self.writeOutput()

    # ------------------- Primary Functions ----------------------
    def extractEnteties(self):
        for i in range(len(self.fileNames)):
            # read the java file,tokenize it,parse it
            input_text = self.readJavaFile(
                os.path.join(self.filePaths[i], self.fileNames[i])
            )
            input_stream = InputStream(input_text)
            lexer = JavaLexer(input_stream)
            stream = CommonTokenStream(lexer)
            stream.fill()
            parser = JavaParser(stream)
            tree = parser.compilationUnit()

            # extraction from the AST directly
            extractor = Extractor(self.fileNames[i], tree)
            extractor.startExtracting()

            # storing the new name generated for the file + the packages extracted from the project
            self.fileNewNamesDict[self.fileNames[i]] = extractor.newFileName

            # extracting the files with the same package (relatedFiles)
            tempPath = os.path.join(
                self.projectPath, "java", *extractor.packageName.split(".")
            )
            if extractor.packageName == "":
                file_names_arr = []
            else:
                file_names_arr = [
                    f
                    for f in os.listdir(tempPath)
                    if os.path.isfile(os.path.join(tempPath, f))
                ]
            self.projectPackages.append(extractor.packageName)
            self.filesRelatedFilesDict[self.fileNames[i]] = file_names_arr

    def renameEnteties(self):
        for i in range(len(self.fileNames)):
            # read the java file,tokenize it,parse it Then traverse the AST via a ParserListener instance
            input_text = self.readJavaFile(
                os.path.join(self.filePaths[i], self.fileNames[i])
            )
            input_stream = InputStream(input_text)
            lexer = JavaLexer(input_stream)
            stream = CommonTokenStream(lexer)
            stream.fill()
            parser = JavaParser(stream)
            tree = parser.compilationUnit()

            # renaming the self.fileNames along the walk
            renamer = Renamer(
                self.fileNames[i],
                self.projectPath,
                self.projectPackages,
                self.filesRelatedFilesDict[self.fileNames[i]],
                stream,
            )
            walker = ParseTreeWalker()
            walker.walk(renamer, tree)
            self.filesTokenStreamDict[
                self.fileNames[i]
            ] = renamer.rewriter.getDefaultText()

    def encryptEnteties(self):
        for i in range(len(self.fileNames)):
            # retrive the already modified TokenStreams from the last parse(Renaming)
            # and chaining the modification together
            input_text = self.filesTokenStreamDict[self.fileNames[i]]
            input_stream = InputStream(input_text)
            lexer = JavaLexer(input_stream)
            stream = CommonTokenStream(lexer)
            stream.fill()
            parser = JavaParser(stream)
            tree = parser.compilationUnit()

            encryptor = Encryptor(
                self.fileNames[i],
                self.filesRelatedFilesDict[self.fileNames[i]],
                self.key,
                self.iv,
                stream,
            )
            walker = ParseTreeWalker()
            walker.walk(encryptor, tree)
            self.filesTokenStreamDict[
                self.fileNames[i]
            ] = encryptor.rewriter.getDefaultText()

    # ------------------ Utitility Fucntions ----------------------
    def writeOutput(self):
        # retrive the modified file contents and write them into new .java files
        for i in range(len(self.fileNames)):
            self.writeJavaFile(
                self.filePaths[i],
                self.filesTokenStreamDict[self.fileNames[i]],
                self.fileNewNamesDict[self.fileNames[i]],
            )
        # starting the key transfer process by
        # 1. passing a key to transfer (neyKey -> the concatination of the key and iv hex of the project)
        # 2. passing a password for the Java KeyStore
        # 3. passing the path which we want our populated files(key.text,serlized,...) to be written
        keyAndIV = self.key + "." + self.iv
        passArray = [97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97]
        pathToStoreFiles = self.filePaths[0].replace(self.projectName, "output")
        self.runJavaFile(
            os.path.join(os.path.dirname(__file__), "visitors", "utils", "jos.jar"),
            keyAndIV,
            pathToStoreFiles,
            passArray,
        )

    def writeJavaFile(self, filePath, fileContent, newFileName):
        javaFileName = f"{newFileName}.java"
        writePath = filePath.replace(self.projectName, "output")
        if not os.path.exists(writePath):
            os.makedirs(writePath)
        with open(os.path.join(writePath, javaFileName), "w") as java_file:
            java_file.write(fileContent)

    def extractFilePaths(self, path: str):
        # we use os.walk function to traverse down the project directory
        # and capture all the .java files
        file_names_arr = []
        file_paths_arr = []

        w = walk(path)
        for dirpath, _, filenames in w:
            for filename in filenames:
                if filename.endswith(".java"):
                    file_names_arr.append(filename)
                    file_paths_arr.append(dirpath)

        return file_paths_arr, file_names_arr

    def readJavaFile(self, filepath: str):
        context = None
        readingJavaFile = filepath
        try:
            context = open(readingJavaFile, "r")
        except IOError:
            print("Something went wronged reading the file")
        return context.read()

    def runJavaFile(self, path, keyAndIV, pathToSave, passArray):
        try:
            # intilizing the command
            command = ["java", "-jar", path, keyAndIV, pathToSave] + list(
                map(str, passArray)
            )

            # Run the Java program
            subprocess.run(command, text=True, check=True)
        except Exception as e:
            print("An error occurred:", e)
