import os
from os import walk,path


__projectName = "project2"


def main():
    a,b = extractFilePaths()
    print(a)
    print(b)


def extractFilePaths():
    print("Loading file paths...")

    file_names = []

    final_path = os.path.join(
        os.path.dirname(__file__), "benchmark", __projectName, "main"
    )
    print("Project Path: ", final_path)
    w = walk(final_path)
    for dirpath, dirnames, filenames in w:
        for filename in filenames:
            if filename.endswith(".java"):
                file_names_arr.append(filename)
    print("Loading file paths complete\n")
    return file_names


if __name__ == "__main__":
    main()
