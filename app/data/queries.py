from peewee import *
from app.data.models.ent import Entity
from app.data.models.ref import Reference


def find_enteties_for_array(name, current_file, start_line, stop_line, kind):
    return (
        Entity.select()
        .where(Entity.name == name)
        .where(Entity.fileName == current_file)
        .where(Entity.varOrReturnType.contains("[]"))
        .where(Entity.kind == kind)
        .where(Entity.startLine <= start_line)
        .where(Entity.parent.startLine <= start_line)
        .where(Entity.parent.stopLine >= stop_line)
        .order_by(Entity.startLine.desc())
        .first()
    )


def find_enteties_for_primary(name, current_file, start_line, stop_line, kind):
    return (
        Entity.select()
        .where(Entity.name == name)
        .where(Entity.fileName == current_file)
        .where(Entity.kind == "localVariable")
        .where(Entity.startLine <= start_line)
        .where(Entity.parent.startLine <= start_line)
        .where(Entity.parent.stopLine >= stop_line)
        .order_by(Entity.startLine.desc())
        .first()
    )


def find_enteties_for_methodCall(name, current_file, start_line, stop_line):
    return (
        Entity.select()
        .where(Entity.name == name)
        .where(Entity.fileName == current_file)
        .where(Entity.kind == "method")
        | (Entity.kind == "interfaceCommonBody")
        .where(Entity.startLine <= start_line)
        .where(Entity.parent.startLine <= start_line)
        .where(Entity.parent.stopLine >= stop_line)
        .order_by(Entity.startLine.desc()).first()
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
