# This class defines a model for an Entity with various fields
#  for Sqlite database in the conf folder
#  using the Peewee ORM library in Python.
import random,json,string


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
    startLine = IntegerField()
    stopLine = IntegerField()
    kind_index = IntegerField()
    KIND_CHOICES = [
        "class",  # 7
        "field",  # 27
        "method",  # 20
        "formalParameter",  # 47
        "localVariable",  # 80
        "enum",  # 11
        "enumConstant",  # 13
        "interface",  # 15
        "interfaceCommonBody",  # 35
        "constant",  # 31
    ]
    kind = CharField(choices=KIND_CHOICES)
    parent = ForeignKeyField("self", backref="children", null=True)
    varOrReturnType = CharField()
    value = CharField(null=True)
    metadata = TextField()  # Use TextField to store JSON-formatted data

    # Auto-genrated random name
    newName = CharField(default=lambda: Entity.generate_random_name(), max_length=10)

    class Meta:
        database = db  # Assuming 'db' is your Peewee database instance

    def set_metadata(self, data):
        self.metadata = json.dumps(data)

    def get_metadata(self):
        return json.loads(self.metadata)

    def generate_random_name():
        first_letter = random.choice(string.ascii_uppercase)
        rest_of_name = "".join(
            random.choices(string.ascii_letters + string.digits, k=9)
        )
        return first_letter + rest_of_name
    
    @classmethod
    def create(cls, name, fileName, startLine, stopLine, kind_index, kind, parent, varOrReturnType, value, metadata):
        try:
            # Try to get an existing record with the same values for name, fileName, startLine, stopLine, and kind_index
            existing_entity = cls.get(
                (cls.name == name) &
                (cls.fileName == fileName) &
                (cls.startLine == startLine) &
                (cls.stopLine == stopLine) &
                (cls.kind_index == kind_index)
            )
            return existing_entity
        except cls.DoesNotExist:
            # If not found, create a new record
            entity = cls(
                name=name,
                fileName=fileName,
                startLine=startLine,
                stopLine=stopLine,
                kind_index=kind_index,
                kind=kind,
                parent=parent,
                varOrReturnType=varOrReturnType,
                value=value,
                metadata=metadata,
            )
            entity.save()
            return entity
