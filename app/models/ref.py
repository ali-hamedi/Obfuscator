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
    TextField,
)

# Import the Entity model
from models.ent import Entity

# Connect to db
db = SqliteDatabase("obfuscator.db")


# Refrence Model
class Reference(Model):
    name = CharField()
    fileName = CharField()
    line = IntegerField()

    TYPE_CHOICES = ["call", "use", "memeberAccess"]
    typeOfReference = CharField(choices=TYPE_CHOICES)

    value = CharField()
    owner = ForeignKeyField(Entity, backref="references", null=True)
    metadata = TextField()  # Use TextField to store JSON-formatted data

    class Meta:
        database = db  # Assuming 'db' is your Peewee database instance

    def set_metadata(self, data):
        self.metadata = json.dumps(data)

    def get_metadata(self):
        return json.loads(self.metadata)
