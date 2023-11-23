# This class defines a model for an Entity with various fields
#  for Sqlite database in the conf folder
#  using the Peewee ORM library in Python.
from peewee import (
    SqliteDatabase,
    Model,
    CharField,
    IntegerField,
    ForeignKeyField,
    TextField,
)

# Connect to db
db = SqliteDatabase("obfuscator.db")


# Entity Model
class Entity(Model):
    name = CharField()
    fileName = CharField()
    line = IntegerField()

    KIND_CHOICES = [
        "class",
        "field",
        "method",
        "formalParameter",
        "localVariable",
    ]
    kind = CharField(choices=KIND_CHOICES)
    parent = ForeignKeyField("self", backref="children", null=True)
    varOrReturnType = CharField()
    value = CharField(null=True)
    metadata = TextField()  # Use TextField to store JSON-formatted data

    class Meta:
        database = db  # Assuming 'db' is your Peewee database instance

    def set_metadata(self, data):
        self.metadata = json.dumps(data)

    def get_metadata(self):
        return json.loads(self.metadata)
