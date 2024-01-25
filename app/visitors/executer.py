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


class Executer:
    def __init__(self, projectName):
        self.projectName = projectName
        self.projectPath = os.path.join(
            os.path.dirname(__file__), "..", "benchmark", self.projectName, "main"
        )
        self.filePaths = []
        self.fileNames = []
        self.fileNewNamesDict = {}
        self.filePackageConfDict = {}
        self.filesTokenStreamDict = {}

    def execute(self):
        print("\nStarting......\n")
        file_paths_arr, file_names_arr = self.extractFilePaths(self.projectPath)
        self.filePaths = file_paths_arr
        self.fileNames = file_names_arr
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
            self.filePackageConfDict[self.fileNames[i]] = {
                "package": extractor.packageName,
                "relatedFiles": file_names_arr,
            }

    def renameEnteties(self):
        for i in range(len(self.fileNames)):
            # read the java file,tokenize it,parse it Then walk into the AST
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
            packages = [file["package"] for file in self.filePackageConfDict.values()]
            renamer = Renamer(
                self.fileNames[i],
                self.projectPath,
                packages,
                self.filePackageConfDict[self.fileNames[i]]["relatedFiles"],
                stream,
            )
            walker = ParseTreeWalker()
            walker.walk(renamer, tree)
            self.filesTokenStreamDict[
                self.fileNames[i]
            ] = renamer.rewriter.getDefaultText()

    def encryptEnteties(self):
        iv = secrets.token_bytes(16).hex()
        key = secrets.token_bytes(16).hex()
        for i in range(len(self.fileNames)):
            # read the java file,tokenize it,parse it Then walk into the AST
            input_text = self.filesTokenStreamDict[self.fileNames[i]]
            input_stream = InputStream(input_text)
            lexer = JavaLexer(input_stream)
            stream = CommonTokenStream(lexer)
            stream.fill()
            parser = JavaParser(stream)
            tree = parser.compilationUnit()

            encryptor = Encryptor(
                self.fileNames[i],
                stream,
                self.filePackageConfDict[self.fileNames[i]]["relatedFiles"],
                key,
                iv,
            )
            walker = ParseTreeWalker()
            walker.walk(encryptor, tree)
            self.filesTokenStreamDict[
                self.fileNames[i]
            ] = encryptor.rewriter.getDefaultText()
            self.writeOutput(
                self.filePaths[i],
                self.fileNames[i],
                self.fileNewNamesDict[self.fileNames[i]],
            )
        keyAndIV = key + "." + iv
        passArray = [97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97]
        self.compile_and_run_java(
            os.path.join(os.path.dirname(__file__), "helper", "jos.jar"),
            keyAndIV,
            self.filePaths[0].replace(self.projectName, "output"),
            passArray,
        )

    # ------------------ Utitility Fucntions ----------------------

    def writeOutput(self, filePath, fileName, newFileName):
        javaFileName = f"{newFileName}.java"
        writePath = filePath.replace(self.projectName, "output")
        if not os.path.exists(writePath):
            os.makedirs(writePath)
        with open(os.path.join(writePath, javaFileName), "w") as java_file:
            java_file.write(self.filesTokenStreamDict[fileName])

    def extractFilePaths(self, path: str):
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

    def compile_and_run_java(self, path, keyAndIV, pathToSave, passArray):
        try:
            command = ["java", "-jar", path, keyAndIV, pathToSave] + list(
                map(str, passArray)
            )

            # Run the Java program
            subprocess.run(command, text=True, check=True)
        except Exception as e:
            print("An error occurred:", e)
