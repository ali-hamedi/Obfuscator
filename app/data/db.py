from peewee import SqliteDatabase
from peewee import fn
from os import path
from app.data.models.ent import Entity
from app.data.models.ref import Reference

"""
    This code initializes a SQLite database connection,creates tables if they don't exist, and
    provides functions to initialize and close the database connection.
"""


# ---------------- primary functions ------------------
def initialize_database():
    clear_database()
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


# ---------------- utility functions ------------------
def clear_database():
    try:
        # Delete all rows from the Entity table
        Entity.truncate_table()

        # Reset the primary key sequence for the Entity table
        Entity._meta.database.execute_sql("PRAGMA foreign_keys=off;")
        Entity._meta.database.execute_sql(
            "DELETE FROM sqlite_sequence WHERE name = 'entity';"
        )
        Entity._meta.database.execute_sql("PRAGMA foreign_keys=on;")

        # Delete all rows from the Reference table
        Reference.truncate_table()

        # Reset the primary key sequence for the Reference table
        Reference._meta.database.execute_sql("PRAGMA foreign_keys=off;")
        Reference._meta.database.execute_sql(
            "DELETE FROM sqlite_sequence WHERE name = 'reference';"
        )
        Reference._meta.database.execute_sql("PRAGMA foreign_keys=on;")

    except Exception as e:
        print(f"Error clearing the database: {e}")




# ----------------- pre populated queries ------------------------
def find_enteties_for_array(name, current_file, start_line, kind):
    return (
        Entity.select()
        .where(Entity.name == name)
        .where(Entity.fileName == current_file)
        .where(Entity.varOrReturnType.contains("[]"))
        .where(Entity.kind == kind)
        .where(Entity.startLine <= start_line)
        .where(Entity.parent.startLine <= start_line)
        .order_by(Entity.startLine.desc())
        .first()
    )


def find_enteties_for_primary(name, current_file, start_line, kind):
    return (
        Entity.select()
        .where(Entity.name == name)
        .where(Entity.fileName == current_file)
        .where(Entity.kind == "localVariable")
        .where(Entity.startLine <= start_line)
        .where(Entity.parent.startLine <= start_line)
        .order_by(Entity.startLine.desc())
        .first()
    )


def find_enteties_for_methodCall(name, current_file, start_line):
    return (
        Entity.select()
        .where(Entity.name == name)
        .where(Entity.fileName == current_file)
        .where(Entity.kind == "method")
        | (Entity.kind == "interfaceCommonBody")
        .where(Entity.startLine <= start_line)
        .where(Entity.parent.startLine <= start_line)
        .order_by(Entity.startLine.desc())
        .first()
    )


def find_enteties_for_declarations(name, current_file, start_line, stop_line, kind):
    return (
        Entity.select()
        .where(Entity.name == name)
        .where(Entity.fileName == current_file)
        .where(Entity.kind == kind)
        .where(Entity.startLine == start_line)
        .where(Entity.stopLine == stop_line)
        .first()
    )
