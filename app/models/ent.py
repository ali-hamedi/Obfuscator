# This class defines a model for an Entity with various fields
#  for Sqlite database in the conf folder
#  using the Peewee ORM library in Python.
from peewee import (
    SqliteDatabase,
    Model,
    CharField,
    IntegerField,
    ForeignKeyField,
    EnumField,
    JSONField,
)

# Connect to db
db = SqliteDatabase("obfuscator.db")


# Entity Model
class Entity(Model):
    name = CharField()
    fileName = CharField()
    line = IntegerField()
    kind = EnumField(choices=["class","interface","enum","const","var", "method", "obj","generic"])
    parent = ForeignKeyField("self", backref="children", null=True)
    varOrReturnType = CharField()
    value = CharField()
    metadata = JSONField()

    class Meta:
        database = db
