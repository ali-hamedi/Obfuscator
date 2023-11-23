import os
from os import walk, path
from conf import init
from app.visitors.extractor import Extractor
from antlr4 import *
from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser

__projectName = "project1"


def main():
    init()
    a, b = extractFilePaths()
    for i in range(len(a)):
        input_text = readJavaFile(os.path.join(a[i], b[i]))
        input_stream = InputStream(input_text)
        lexer = JavaLexer(input_stream)
        stream = CommonTokenStream(lexer)
        stream.fill()
        parser = JavaParser(stream)
        tree = parser.compilationUnit()  # Parse the entire compilation unit
        e = Extractor(b[i])
        walker = ParseTreeWalker()
        walker.walk(e, tree)


def extractFilePaths():
    print("Loading file paths...")
    # destination_path = extractZip(zip_path)
    names_arr = []
    file_paths_arr = []

    final_path = os.path.join(
        os.path.dirname(__file__), "benchmark", __projectName, "main"
    )
    print("Project Path: ", final_path)
    w = walk(final_path)
    for dirpath, _, filenames in w:
        for filename in filenames:
            if filename.endswith(".java"):
                names_arr.append(filename)
                file_paths_arr.append(dirpath)
    print("Loading file paths complete\n")
    return file_paths_arr, names_arr


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
