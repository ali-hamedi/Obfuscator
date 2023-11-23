from peewee import SqliteDatabase

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
        db.close()
