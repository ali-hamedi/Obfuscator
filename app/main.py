import os
from antlr4 import *
from os import walk, path
from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser
from app.visitors.extractor import Extractor
from app.visitors.renamer import Renamer
from app.data.db import *

__projectName = "project2"


def main():
    initialize_database()
    file_paths, file_names = extractFilePaths()
    for i in range(len(file_names)):
        input_text = readJavaFile(os.path.join(file_paths[i], file_names[i]))
        input_stream = InputStream(input_text)
        lexer = JavaLexer(input_stream)
        stream = CommonTokenStream(lexer)
        stream.fill()
        parser = JavaParser(stream)
        tree = parser.compilationUnit()  # Parse the entire compilation unit

        # extraction
        extractor = Extractor(file_names[i], tree)
        extractor.startExtracting()

        # renaming
        renamer = Renamer(file_names[i])
        walker = ParseTreeWalker()
        walker.walk(renamer, tree)
        fileCopy = " ".join(renamer.out)
        makeOutput(i, fileCopy, file_paths, file_names)


def makeOutput(i, final_output_with_replaced_classes, file_paths, file_names):
    javaFileName = f"New_{file_names[i]}"
    writePath = file_paths[i].replace(__projectName, "output/src")
    if not os.path.exists(writePath):
        os.makedirs(writePath)
    with open(os.path.join(writePath, javaFileName), "w") as java_file:
        # print(os.path.join(writePath, javaFileName))
        java_file.write(final_output_with_replaced_classes)


def extractFilePaths():
    print("Loading file paths...")
    # destination_path = extractZip(zip_path)
    file_names_arr = []
    file_paths_arr = []

    final_path = os.path.join(
        os.path.dirname(__file__), "benchmark", __projectName, "main"
    )
    print("Project Path: ", final_path)
    w = walk(final_path)
    for dirpath, _, filenames in w:
        for filename in filenames:
            if filename.endswith(".java"):
                file_names_arr.append(filename)
                file_paths_arr.append(dirpath)
    print("Loading file paths complete\n")
    return file_paths_arr, file_names_arr


def readJavaFile(filepath: str):
    context = None
    readingJavaFile = filepath
    try:
        context = open(readingJavaFile, "r")
    except IOError:
        print("Something went wronged reading the file")
    return context.read()


if __name__ == "__main__":
    main()
