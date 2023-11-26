import os
import time
from os import path, walk
from antlr4 import *
from app.visitors.extractor import Extractor
from app.visitors.renamer import Renamer
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
            packages = ages = [
                file["package"] for file in self.filePackageConfDict.values()
            ]
            renamer = Renamer(
                self.fileNames[i],
                packages,
                self.filePackageConfDict[self.fileNames[i]]["relatedFiles"],
            )
            walker = ParseTreeWalker()
            walker.walk(renamer, tree)
            newFileContent = " ".join(renamer.out)
            self.writeOutput(
                i, newFileContent, self.fileNewNamesDict[self.fileNames[i]]
            )

    # ------------------ Utitility Fucntions ----------------------

    def writeOutput(self, index, finalOutPut, newFileName):
        javaFileName = f"{newFileName}.java"
        writePath = self.filePaths[index].replace(self.projectName, "output")
        if not os.path.exists(writePath):
            os.makedirs(writePath)
        with open(os.path.join(writePath, javaFileName), "w") as java_file:
            java_file.write(finalOutPut)

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
