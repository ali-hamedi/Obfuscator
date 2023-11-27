import os

from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser
from app.gen.JavaParserListener import JavaParserListener
from app.data.models.ent import Entity
from app.data.models.ref import Reference
from app.data.db import *
from antlr4 import *

"""
    -  Class : `Extractor`
      -  Inherits From : `JavaParserListener` so we can parse and travers the code

    - Constructor
        - Initializes the `Extractor` instance with the current file. // for now

    - Description
        - The way of work is we access the first and primary grammar rule extracted from our java code.
        the rule is called CompilationUnit then we traverse deeper and deeper into it where we extract our targeted entities 
        alongside their properties and each time we traverse deeper we return the current entity as the parent entity for 
        the next child.

        - Targeted Enteties:

            class  -> RuleIndex = 7 self,qualif ->for imports  /   typeIdentifier  constructor i donno
            field  -> RuleIndex = 27 : self and primary and expression
            method  -> RuleIndex = 20 : self, primary and expression   method call
            formalParameter  -> RuleIndex = 47 : self and primary and expression
            localVariable  -> RuleIndex = 80 : self and primary and expression
            enum  -> RuleIndex = 11  : self,primary qualif ->for imports  /   typeIdentifier 
            enumConstant  -> RuleIndex =  13 : self and primary and expression
            interface  -> RuleIndex = 15 : self,qualif ->for imports  /   typeIdentifier 
            interfaceCommonBody  -> RuleIndex =   35 : self and primary / defnitinon of other methods(implement)
            constant  -> RuleIndex = 31 : self and primary 

"""


class Renamer(JavaParserListener):
    def __init__(self, currentFile, projectPath, projectPackges, usedClasses):
        self.currentFile = currentFile
        self.projectPackges = projectPackges
        self.projectPath = projectPath
        self.usedClasses = usedClasses
        self.out = []

    # ------------ Rename declrations themselvs ------------
    def enterImportDeclaration(self, ctx: JavaParser.ImportDeclarationContext):
        importQualifiedName = ctx.qualifiedName()
        importIdentifiers = ctx.qualifiedName().identifier()

        tempComponents = importQualifiedName.getText().split(".")
        tempQualifiedName = ".".join(tempComponents[:-1])

        if "*" == ctx.getChild(ctx.getChildCount() - 2).getText():
            tempPath = os.path.join(self.projectPath, "java", *tempComponents)
            file_names_arr = [
                f
                for f in os.listdir(tempPath)
                if os.path.isfile(os.path.join(tempPath, f))
            ]
            self.usedClasses.extend(file_names_arr)
        else:
            if tempQualifiedName in self.projectPackges:
                importedClassIdentifier = importIdentifiers[-1]
                self.usedClasses.append(importedClassIdentifier.getText() + ".java")

                ent = find_enteties_for_imports(
                    importedClassIdentifier.getText(),
                    importedClassIdentifier.getText() + ".java",
                )
                if ent:
                    self.castIdentifier(importedClassIdentifier, ent)
                return

    def enterClassDeclaration(self, ctx: JavaParser.ClassDeclarationContext):
        name = ctx.identifier()
        ent = find_enteties_for_declarations(
            name.getText(),
            self.currentFile,
            ctx.start.line,
            ctx.stop.line,
            "class",
        )
        if ent:
            self.castIdentifier(name, ent)

        return

    def enterFieldDeclaration(self, ctx: JavaParser.FieldDeclarationContext):
        for variableDecl in ctx.variableDeclarators().variableDeclarator():
            name = variableDecl.variableDeclaratorId().identifier()
            ent = find_enteties_for_declarations(
                name.getText(),
                self.currentFile,
                ctx.start.line,
                ctx.stop.line,
                "field",
            )
            if ent:
                self.castIdentifier(name, ent)
            return

    def enterMethodDeclaration(self, ctx: JavaParser.MethodDeclarationContext):
        name = ctx.identifier()
        ent = find_enteties_for_declarations(
            name.getText(),
            self.currentFile,
            ctx.start.line,
            ctx.stop.line,
            "method",
        )
        for modifier in ctx.parentCtx.parentCtx.modifier():
            if (
                modifier.classOrInterfaceModifier().annotation()
                and modifier.classOrInterfaceModifier().annotation() == "Override"
            ):
                # ? maybe delete the override
                pass
        if ent.parent.get_metadata()["extend"]:
            class_parent = ent.parent.get_metadata()["extend"]
            class_parent_ent = find_class_by_fileName(class_parent)

            temp_ent = find_override_methods(name.getText(), class_parent_ent)
            if temp_ent:
                self.castIdentifier(name, temp_ent)
                return
        if ent:
            self.castIdentifier(name, ent)
        return

    def enterFormalParameter(self, ctx: JavaParser.FormalParameterContext):
        name = ctx.variableDeclaratorId().identifier()
        ent = find_enteties_for_declarations(
            name.getText(),
            self.currentFile,
            ctx.start.line,
            ctx.stop.line,
            "formalParameter",
        )
        if ent:
            self.castIdentifier(name, ent)

        return

    def enterLocalVariableDeclaration(
        self, ctx: JavaParser.LocalVariableDeclarationContext
    ):
        if ctx.typeType():
            for variableDecl in ctx.variableDeclarators().variableDeclarator():
                name = variableDecl.variableDeclaratorId().identifier()
            ent = find_enteties_for_declarations(
                name.getText(),
                self.currentFile,
                ctx.start.line,
                ctx.stop.line,
                "localVariable",
            )
            if ent:
                self.castIdentifier(name, ent)

            return
        else:
            name = ctx.identifier()
            ent = find_enteties_for_declarations(
                name.getText(),
                self.currentFile,
                ctx.start.line,
                ctx.stop.line,
                "localVariable",
            )
            if ent:
                self.castIdentifier(name, ent)

            return

    def enterStatement(self, ctx: JavaParser.StatementContext):
        if ctx.FOR():
            if ctx.forControl().enhancedForControl():
                currentCtx = ctx.forControl().enhancedForControl()
                name = currentCtx.variableDeclaratorId().identifier()
                ent = find_enteties_for_declarations(
                    name.getText(),
                    self.currentFile,
                    ctx.start.line,
                    ctx.stop.line,
                    "localVariable",
                )
                if ent:
                    self.castIdentifier(name, ent)

                return

    def enterEnumDeclaration(self, ctx: JavaParser.EnumDeclarationContext):
        name = ctx.identifier()
        ent = find_enteties_for_declarations(
            name.getText(),
            self.currentFile,
            ctx.start.line,
            ctx.stop.line,
            "enum",
        )
        if ent:
            self.castIdentifier(name, ent)

        return

    def enterEnumConstant(self, ctx: JavaParser.EnumConstantContext):
        name = ctx.identifier()
        ent = find_enteties_for_declarations(
            name.getText(),
            self.currentFile,
            ctx.start.line,
            ctx.stop.line,
            "enumConstant",
        )
        if ent:
            self.castIdentifier(name, ent)

        return

    def enterInterfaceDeclaration(self, ctx: JavaParser.InterfaceDeclarationContext):
        name = ctx.identifier()
        ent = find_enteties_for_declarations(
            name.getText(),
            self.currentFile,
            ctx.start.line,
            ctx.stop.line,
            "interface",
        )
        if ent:
            self.castIdentifier(name, ent)

        return

    def enterInterfaceCommonBodyDeclaration(
        self, ctx: JavaParser.InterfaceCommonBodyDeclarationContext
    ):
        name = ctx.identifier()
        ent = find_enteties_for_declarations(
            name.getText(),
            self.currentFile,
            ctx.start.line,
            ctx.stop.line,
            "interfaceCommonBody",
        )
        if ent:
            self.castIdentifier(name, ent)

        return

    def enterConstDeclaration(self, ctx: JavaParser.ConstDeclarationContext):
        for variableDecl in ctx.constantDeclarator():
            name = variableDecl.identifier()
            ent = find_enteties_for_declarations(
                name.getText(),
                self.currentFile,
                ctx.start.line,
                ctx.stop.line,
                "constant",
            )
            if ent:
                self.castIdentifier(name, ent)

            return

    # ------------ Rename refrencess (primary + expressions) ------------
    def enterExpression(self, ctx: JavaParser.ExpressionContext):
        self.visitExpression(ctx)

    def visitExpression(self, ctx: JavaParser.ExpressionContext):
        if ctx.primary():
            if ctx.primary().identifier():
                return self.matchIdentifier(ctx.primary(), "primary")
            elif ctx.primary().expression():
                return self.visitExpression(ctx.primary().expression())

        elif ctx.bop and ctx.bop.text == ".":
            return self.resolveMemberAccess(ctx)

        elif ctx.methodCall():
            return self.matchIdentifier(ctx.methodCall(), "methodCall")

        elif ctx.LBRACK() and ctx.RBRACK():
            return self.matchIdentifier(ctx.expression()[0], "array")

        # Rest of type identifiers + special cases
        elif ctx.classType():
            return self.handleTypeIdentifiers(
                ctx.classType(), ctx.classType().identifier().getText()
            )
        elif "::" in ctx.getText():
            return self.handleMethodReferences(ctx)

        # Continue visiting children
        for child in ctx.getChildren():
            if child and isinstance(child, JavaParser.ExpressionContext):
                self.visitExpression(child)
            elif child and isinstance(child, JavaParser.PrimaryContext):
                if child.identifier():
                    self.matchIdentifier(child, "primary")
                elif child.expression():
                    self.visitExpression(ctx.primary().expression())
            elif child and isinstance(child, JavaParser.MethodCallContext):
                self.matchIdentifier(child, "methodCall")

    def matchIdentifier(self, ctx, type):
        # priority :
        #   closet local var
        #   formal parameter
        #   field,constant

        name = None
        result = None
        if type == "methodCall":
            name = ctx.identifier().getText()
            result = find_enteties_for_methodCall(name, self.currentFile)
            if result:
                self.castIdentifier(ctx, result)
                return result

        # Define entity types to search for
        entity_types = ["localVariable", "formalParameter", "field", "constant"]

        # Iterate through entity types and find matching entities
        for entity_type in entity_types:
            if type == "array":
                name = ctx.getText()
                result = find_enteties_for_array(
                    name, self.currentFile, ctx.start.line, ctx.stop.line, entity_type
                )
            elif type == "primary":
                name = ctx.identifier().getText()
                result = find_enteties_for_primary(
                    name, self.currentFile, ctx.start.line, ctx.stop.line, entity_type
                )

            # If a matching result is found, cast the identifier and return

            if result:
                self.castIdentifier(ctx, result)
                return result
        if type == "primary" and result is None:
            self.handleTypeIdentifiers(ctx.identifier(), ctx.identifier().getText())

    # ------------ Resolve type identifiers  & special cases------------
    def handleTypeIdentifiers(self, ctx, name):
        if name == "this":
            name == self.currentFile.replace(".java", "")
        ent = find_enteties_for_type_identifier(name, self.usedClasses)
        if ent:
            self.castIdentifier(ctx, ent)
            return ent

    def enterTypeIdentifier(self, ctx: JavaParser.TypeIdentifierContext):
        name = ctx.getText()
        self.handleTypeIdentifiers(ctx, name)

    def enterCreatedName(self, ctx: JavaParser.CreatedNameContext):
        for iden in ctx.identifier():
            name = iden.getText()
            self.handleTypeIdentifiers(iden, name)

    def enterConstructorDeclaration(
        self, ctx: JavaParser.ConstructorDeclarationContext
    ):
        name = ctx.identifier().getText()
        self.handleTypeIdentifiers(ctx.identifier(), name)

    def handleMethodReferences(self, ctx: JavaParser.ExpressionContext):
        members = []
        for child in ctx.getChildren():
            if child.getText() != "::":
                members.append(child)
        if len(members) > 0:
            # print(members[0], members[0].getText(), self.usedClasses)
            parentEntity = self.handleTypeIdentifiers(members[0], members[0].getText())
            ent = find_enteties_for_members(
                members[1].getText(), parentEntity, "method"
            )
            if ent:
                self.castIdentifier(members[1], ent)

    # ------------ Resolve and Rename member accesses ------------
    def resolveMemberAccess(self, ctx):
        # print("member : ", ctx.getText())
        members = []
        for child in ctx.getChildren():
            if child.getText() != ".":
                members.append(child)
        self.extractList(members, True)

    def extractList(
        self,
        parts,
        isFirstIteration,
        entity_from_last_iteration=None,
    ):
        left = parts[0]
        right = parts[1:]

        ent = None
        left_name = None
        if left.getText() == "this":
            left_name = self.currentFile.replace(".java", "")
        else:
            left_name = left.getText()

        if not isFirstIteration:
            if entity_from_last_iteration is None:
                return
            if (
                entity_from_last_iteration.varOrReturnType + ".java"
                not in self.usedClasses
            ):
                return

        if isFirstIteration:
            ent = find_enteties_for_type_identifier(left_name, self.usedClasses)
            if ent is None:
                ent = self.visitExpression(left)
        else:
            ent = self.visitExpressionForMember(left, right, entity_from_last_iteration)
        if ent:
            if left.getText() != "this":
                self.castIdentifier(left, ent)
        else:
            pass

        # continue the process for other members if availabe
        if len(right) > 0:
            self.extractList(right, False, ent)

    def visitExpressionForMember(self, left, right, entity_from_last_iteration):
        ent = None
        parentEntity = find_fileName_from_entity_type(
            entity_from_last_iteration, self.usedClasses
        )

        if isinstance(left, JavaParser.MethodCallContext):
            name = left.identifier().getText()
            ent = find_enteties_for_members(name, parentEntity, "method")
            return ent
        else:
            entity_types = ["field", "constant"]
            for entity_type in entity_types:
                if (
                    isinstance(left, JavaParser.ExpressionContext)
                    and left.LBRACK()
                    and left.RBRACK()
                ):
                    name = left.getText()
                    ent = find_enteties_for_members(
                        name, parentEntity, entity_type, True
                    )
                    if ent:
                        return ent
                elif isinstance(left, JavaParser.IdentifierContext):
                    name = left.getText()
                    ent = find_enteties_for_members(
                        name,
                        parentEntity,
                        entity_type,
                    )
                    if ent:
                        return ent

    # ------------ Utility Functions ------------
    def castIdentifier(self, ctx, result):
        # adding filters
        ctx.start.text = result.newName

    def visitTerminal(self, node):
        token = node.symbol

        if token is not None:
            # Use the token's line and column as a unique identifier
            token_key = (token.line, token.column)

            # if token_key in self.executer.modified_tokens:
            # token.text = self.executer.modified_tokens[token_key]

            self.out.append(token.text)

        return super().visitTerminal(node)
