"""
 This class defines a model for a Refrence with various fields
 for Sqlite database in the conf folder
 using the Peewee ORM library in Python.
"""
from peewee import (
    SqliteDatabase,
    Model,
    CharField,
    IntegerField,
    ForeignKeyField,
    EnumField,
)

# Import the Entity model
from models.entities import Entity  

# Connect to db
db = SqliteDatabase("obfuscator.db")

# Refrence Model
class Reference(Model):
    name = CharField()
    fileName = CharField()
    line = IntegerField()
    typeOfReference = EnumField(choices=["call", "use","memeberAccess"])
    value = CharField()
    owner = ForeignKeyField(Entity, backref="references", null=True)

    class Meta:
        database = db
