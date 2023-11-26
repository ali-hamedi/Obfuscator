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
    def __init__(self, currentFile, projectPackges, usedClasses):
        self.currentFile = currentFile
        self.projectPackges = projectPackges
        self.usedClasses = usedClasses
        self.out = []

    def enterImportDeclaration(self, ctx: JavaParser.ImportDeclarationContext):
        importQualifiedName = ctx.qualifiedName()
        importIdentifiers = ctx.qualifiedName().identifier()

        qualifiedName = ctx.qualifiedName()
        tempComponents = importQualifiedName.getText().split(".")
        tempQualifiedName = ".".join(tempComponents[:-1])

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

    def enterExpression(self, ctx: JavaParser.ExpressionContext):
        self.visitExpression(ctx)

    def visitExpression(self, ctx: JavaParser.ExpressionContext):
        if ctx.primary():
            if ctx.primary().identifier():
                # print("Primary Expression:", ctx.primary().identifier().getText())
                return self.matchIdentifier(ctx.primary(), "primary")
            elif ctx.primary().expression():
                return self.visitExpression(ctx.primary().expression())
        elif ctx.bop and ctx.bop.text == ".":
            # print("Member Access:", ctx.getText())
            self.resolveMemberAccess(ctx)
            return

        elif ctx.methodCall():
            # print(
            # "Method Call:",
            # ctx.methodCall().getText(),
            # ctx.methodCall().identifier().getText(),
            # )
            return self.matchIdentifier(ctx.methodCall(), "methodCall")

        elif ctx.LBRACK() and ctx.RBRACK():
            # print("Array Access:", ctx.getText())
            return self.matchIdentifier(ctx.expression()[0], "array")

        # Add more conditions as needed

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

        if type == "methodCal":
            name = ctx.identifier().getText()
            result = find_enteties_for_methodCall(
                name, self.currentFile, ctx.start.line
            )
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
                    name, self.currentFile, ctx.start.line, entity_type
                )
            elif type == "primary":
                name = ctx.identifier().getText()
                result = find_enteties_for_primary(
                    name, self.currentFile, ctx.start.line, entity_type
                )

            # If a matching result is found, cast the identifier and return
            if result:
                # print('alo')
                self.castIdentifier(ctx, result)
                return result

    def castIdentifier(self, ctx, result):
        # adding filters
        ctx.start.text = result.newName

    def resolveMemberAccess(self, ctx):
        # print("member : ", ctx.getText())
        members = []
        for child in ctx.getChildren():
            if child.getText() != ".":
                members.append(child)
        self.extractList(members)

    def visitTerminal(self, node):
        token = node.symbol

        if token is not None:
            # Use the token's line and column as a unique identifier
            token_key = (token.line, token.column)

            # if token_key in self.executer.modified_tokens:
            # token.text = self.executer.modified_tokens[token_key]

            self.out.append(token.text)

        return super().visitTerminal(node)

    def extractList(self, parts, entity_from_last_iteration=None):
        left = parts[0]
        right = parts[1:]
        
        if left.getText() == "this":
            left_name = self.currentFile.replace(".java", "")
        else:
            left_name = left.getText()
                
        ent = None
        if entity_from_last_iteration is None:


            ent = find_enteties_for_type_identifier(left_name, self.usedClasses)

            if ent is None:
                ent = self.visitExpression(left)
        else:
            if left.methodCall():
                name = left.methodCall().identifier().getText()
                ent = find_enteties_for_members(
                    name, entity_from_last_iteration, "method"
                )
            else:
                # Define entity types to search for
                entity_types = ["localVariable", "formalParameter", "field", "constant"]

                # Iterate through entity types and find matching entities
                for entity_type in entity_types:
                    if left.LBRACK() and left.RBRACK():
                        name = left.getText()
                        ent = find_enteties_for_members(
                            name, entity_from_last_iteration, entity_type, True
                        )
                    elif left.primary():
                        if left.primary().identifier():
                            name = left.primary().identifier().getText()
                            ent = find_enteties_for_members(
                                name,
                                entity_from_last_iteration,
                                entity_type,
                            )
                        elif left.primary().expression():
                            pass
                            print("a")
            print(left_name, ent)
        if len(right) > 0:
            self.extractList(right, ent)
