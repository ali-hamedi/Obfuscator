from peewee import SqliteDatabase
from os import path
from app.models.ent import Entity
from app.models.ref import Reference

"""
    This code initializes a SQLite database connection,creates tables if they don't exist, and
    provides functions to initialize and close the database connection.
"""


def initialize_database():
    # Define the database connection
    db = SqliteDatabase("obfuscator.db")

    # Connect to the database
    db.connect()

    # Create tables if they don't exist
    db.create_tables([Reference, Entity])

    # Additional initialization logic if needed


def close_database():
    # Close the database connection
    if not db.is_closed():
        clear_database()
        db.close()


def clear_database():
    try:
        # Delete all rows from the Entity table
        Entity.delete().execute()

        # Reset the primary key sequence for the Entity table
        Entity._meta.database.execute_sql(
            "DELETE FROM sqlite_sequence WHERE name = ?", ("entity",)
        )

        # Delete all rows from the Reference table
        Reference.delete().execute()

        # Reset the primary key sequence for the Reference table
        Reference._meta.database.execute_sql(
            "DELETE FROM sqlite_sequence WHERE name = ?", ("reference",)
        )
    except:
        pass
