from peewee import SqliteDatabase
from peewee import fn
from os import path
from app.data.models.ent import Entity

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
    db.create_tables([Entity])

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
        Entity._meta.database.execute_sql("DELETE FROM entity WHERE name = 'entity';")
        Entity._meta.database.execute_sql("PRAGMA foreign_keys=on;")

    except Exception as e:
        print(f"Error clearing the database: {e}")


# ----------------- pre populated queries ------------------------
def find_enteties_for_array(name, current_file, start_line, stop_line, kind):
    return (
        Entity.select()
        .where((Entity.name == name)|(Entity.newName== name))
        .where(Entity.fileName == current_file)
        .where(Entity.varOrReturnType.contains("[]"))
        .where(Entity.kind == kind)
        .where(Entity.startLine <= start_line)
        .where(
            Entity.parent_id.in_(
                Entity.select(Entity.id)
                .where(Entity.startLine <= start_line)
                .where(Entity.stopLine >= stop_line)
                .alias("subquery")
            )
        )
        .order_by(Entity.startLine.desc())
        .first()
    )


def find_enteties_for_primary(name, current_file, start_line, stop_line, kind):
    if kind == "localVariable" or kind == "formalParameter":
        return (
            Entity.select()
            .where((Entity.name == name)|(Entity.newName== name))
            .where(Entity.fileName == current_file)
            .where(Entity.kind == kind)
            .where(Entity.startLine <= start_line)
            .where(
                Entity.parent_id.in_(
                    Entity.select(Entity.id)
                    .where(Entity.startLine <= start_line)
                    .where(Entity.stopLine >= stop_line)
                    .alias("subquery")
                )
            )
            .order_by(Entity.startLine.desc())
            .first()
        )
    else:
        return (
            Entity.select()
            .where((Entity.name == name)|(Entity.newName== name))
            .where(Entity.fileName == current_file)
            .where(Entity.kind == kind)
            .where(Entity.startLine <= start_line)
            .order_by(Entity.startLine.desc())
            .first()
        )


def find_enteties_for_methodCall(name, current_file):
    # todo : signature
    return (
        Entity.select()
        .where(
            ((Entity.name == name)|(Entity.newName== name))
            & (Entity.fileName == current_file)
            & ((Entity.kind == "method") | (Entity.kind == "interfaceCommonBody"))
        )
        .order_by(Entity.startLine.desc())
        .first()
    )


def find_enteties_for_declarations(name, current_file, start_line, stop_line, kind):
    return (
        Entity.select()
        .where(((Entity.name == name)|(Entity.newName== name)))
        .where(Entity.fileName == current_file)
        .where(Entity.kind == kind)
        .where(Entity.startLine == start_line)
        .where(Entity.stopLine == stop_line)
        .first()
    )


def find_enteties_for_imports(name, import_file_name):
    return (
        Entity.select()
        .where(
            ((Entity.name == name)|(Entity.newName== name))
            & (
                (Entity.kind == "class")
                | (Entity.kind == "enum")
                | (Entity.kind == "interface")
            )
            & (Entity.fileName == import_file_name)
        )
        .first()
    )


def find_enteties_for_type_identifier(name, accepted_files):
    return (
        Entity.select()
        .where(
            ((Entity.name == name)|(Entity.newName== name))
            & (
                (Entity.kind == "class")
                | (Entity.kind == "enum")
                | (Entity.kind == "interface")
            )
            & (Entity.fileName << accepted_files)
        )
        .first()
    )


def find_enteties_for_global_identifier(name, accepted_files):
    return (
        Entity.select()
        .where(
            ((Entity.name == name)|(Entity.newName== name))
            & (
                (Entity.kind == "class")
                | (Entity.kind == "enum")
                | (Entity.kind == "interface")
                | (Entity.kind == "constant")
                | (Entity.kind == "enumConstant")
            )
            & (Entity.fileName << accepted_files)
        )
        .first()
    )


def find_enteties_for_members(name, parentEntity, kind, isArray=False):
    if isArray:
        return (
            Entity.select()
            .where((Entity.name == name)|(Entity.newName== name))
            .where(Entity.fileName == parentEntity.fileName)
            .where(Entity.kind == kind)
            .where(Entity.parent == parentEntity)
            .where(Entity.varOrReturnType.contains("[]"))
            .first()
        )
    elif kind == "method":
        return (
            Entity.select()
            .where((Entity.name == name)|(Entity.newName== name))
            .where(Entity.fileName == parentEntity.fileName)
            .where((Entity.kind == "method") | (Entity.kind == "interfaceCommonBody"))
            .where(Entity.parent == parentEntity)
            .first()
        )
    else:
        return (
            Entity.select()
            .where((Entity.name == name)|(Entity.newName== name))
            .where(Entity.fileName == parentEntity.fileName)
            .where(Entity.parent == parentEntity)
            .where(Entity.kind == kind)
            .first()
        )


def find_fileName_from_entity_type(varOrReturnType, accepted_files):
    return (
        Entity.select()
        .where(
            (Entity.name == varOrReturnType)
            & (
                (Entity.kind == "class")
                | (Entity.kind == "enum")
                | (Entity.kind == "interface")
            )
            & (Entity.fileName << accepted_files)
        )
        .first()
    )


def find_class_by_fileName(name, accepted_files):
    result = (
        Entity.select()
        .where(
            ((Entity.name == name)|(Entity.newName== name))
            & (
                (Entity.kind == "class")
                | (Entity.kind == "enum")
                | (Entity.kind == "interface")
            )
            & (Entity.fileName == name + ".java")
        )
        .first()
    )
    if result:
        return result
    else:
        result = (
            Entity.select()
            .where(
                ((Entity.name == name)|(Entity.newName== name))
                & (
                    (Entity.kind == "class")
                    | (Entity.kind == "enum")
                    | (Entity.kind == "interface")
                )
                & (Entity.fileName << accepted_files)
            )
            .first()
        )


def find_enteties_from_parent_class(name, parent_entity, kind):
    if kind == "method":
        return (
            Entity.select()
            .where((Entity.name == name)|(Entity.newName== name))
            .where(Entity.parent == parent_entity)
            .where(
                Entity.parent_id.in_(
                    Entity.select(Entity.id)
                    .where(Entity.fileName == parent_entity.fileName)
                    .alias("subquery")
                )
            )
            .where((Entity.kind == "method") | (Entity.kind == "interfaceCommonBody"))
            .first()
        )
    else:
        return (
            Entity.select()
            .where((Entity.name == name)|(Entity.newName== name))
            .where(Entity.parent == parent_entity)
            .where(
                Entity.parent_id.in_(
                    Entity.select(Entity.id)
                    .where(Entity.fileName == parent_entity.fileName)
                    .alias("subquery")
                )
            )
            .where(Entity.kind == kind)
            .first()
        )


def find_constructor_name_based_on_class(name):
    return (
        Entity.select()
        .where(
            ((Entity.name == name)|(Entity.newName== name))
            & (
                (Entity.kind == "class")
                | (Entity.kind == "enum")
                | (Entity.kind == "interface")
            )
            & (Entity.fileName == current_file)
        )
        .first()
    )


def get_all_type_declarations():
    return Entity.select().where(
        (
            (Entity.kind == "class")
            | (Entity.kind == "enum")
            | (Entity.kind == "interface")
        )
    )