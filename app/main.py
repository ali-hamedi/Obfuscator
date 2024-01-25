import os
from antlr4 import *
from os import walk, path

from app.visitors.executer import Executer
from app.data.db import *

__projectName = "project3"   

def main(): 
    initialize_database()
    executer = Executer(__projectName)
    executer.execute()


if __name__ == "__main__":
    main()
