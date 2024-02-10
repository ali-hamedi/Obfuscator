import os

from antlr4 import *
from os import walk, path

from app.data.db import *
from app.executer import Executer

__projectName = "project3"   

def main(): 
    initialize_database()
    executer = Executer(__projectName)
    executer.execute()


if __name__ == "__main__":
    main()
