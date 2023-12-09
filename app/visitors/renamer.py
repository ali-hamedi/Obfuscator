import os

from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser
from app.gen.JavaParserListener import JavaParserListener
from app.data.models.ent import Entity
from app.data.models.ref import Reference
from app.data.db import *
from antlr4 import *
from antlr4.TokenStreamRewriter import *

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
    def __init__(
        self, currentFile, projectPath, projectPackges, usedClasses, commonTokenStream
    ):
        self.currentFile = currentFile
        self.projectPackges = projectPackges
        self.projectPath = projectPath
        self.usedClasses = usedClasses
        self.allClasses = get_all_type_declarations()
        self.rewriter = TokenStreamRewriter(commonTokenStream)
        self.out = []

    # ------------ Rename declrations themselvs ------------
    def enterImportDeclaration(self, ctx: JavaParser.ImportDeclarationContext):
        importQualifiedName = ctx.qualifiedName()
        importIdentifiers = ctx.qualifiedName().identifier()
        tempComponents = importQualifiedName.getText().split(".")
        tempQualifiedName = ".".join(tempComponents[:-1])

        if "*" == ctx.getChild(ctx.getChildCount() - 2).getText():
            tempPath = os.path.join(self.projectPath, "java", *tempComponents)
            if tempComponents[0] == "java":
                return
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

    def enterConstructorDeclaration(
        self, ctx: JavaParser.ConstructorDeclarationContext
    ):
        name = ctx.identifier()
        ent = find_enteties_for_declarations(
            name.getText(),
            self.currentFile,
            name.start.line,
            name.stop.line,
            "constructor",
        )
        if ent:
            self.castIdentifier(name, ent)

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
                and modifier.classOrInterfaceModifier().annotation().getText()
                == "@Override"
            ):
                if ent.parent.get_metadata()["extend"]:
                    class_parent = ent.parent.get_metadata()["extend"]
                    class_parent_ent = find_class_by_fileName(
                        class_parent, self.allClasses
                    )

                    temp_ent = find_enteties_from_parent_class(
                        name.getText(), class_parent_ent, "method"
                    )
                    if temp_ent:
                        self.castIdentifier(name, temp_ent)
                        return
                elif ent.parent.get_metadata()["implementList"]:
                    class_parents = ent.parent.get_metadata()["implementList"]
                    for class_parent in class_parents:
                        class_parent_ent = find_class_by_fileName(
                            class_parent, self.allClasses
                        )
                        temp_ent = find_enteties_from_parent_class(
                            name.getText(), class_parent_ent, "method"
                        )
                        if temp_ent:
                            self.castIdentifier(name, temp_ent)
                            return
                else:
                    annotation = modifier.classOrInterfaceModifier().annotation()
                    self.rewriter.replaceRangeTokens(
                        annotation.start, annotation.stop, ""
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

    # priority :
    #   closet local var
    #   formal parameter
    #   field,constant
    #   type idens
    #   extended,implemented

    def matchIdentifier(self, ctx, type):
        name = None
        result = None
        if type == "methodCall":
            if ctx.SUPER():
                return
            name = ctx.identifier().getText()
            result = find_enteties_for_methodCall(name, self.currentFile)
            if result:
                self.castIdentifier(ctx, result)
                return result

        else:
            # Define entity types to search for
            entity_types = [
                "localVariable",
                "formalParameter",
                "field",
                "constant",
                "enumConstant",
            ]

            # Iterate through entity types and find matching entities
            for entity_type in entity_types:
                if type == "array":
                    name = ctx.getText()
                    result = find_enteties_for_array(
                        name,
                        self.currentFile,
                        ctx.start.line,
                        ctx.stop.line,
                        entity_type,
                    )
                elif type == "primary":
                    name = ctx.identifier().getText()
                    result = find_enteties_for_primary(
                        name,
                        self.currentFile,
                        ctx.start.line,
                        ctx.stop.line,
                        entity_type,
                    )

                # If a matching result is found, cast the identifier and return
                if result:
                    self.castIdentifier(ctx, result)
                    return result
        # inheritance
        temp_ent = None
        ent = find_class_by_fileName(
            self.currentFile.replace(".java", ""), self.allClasses
        )
        kinds = [
            "localVariable",
            "formalParameter",
            "field",
            "constant",
            "enumConstant",
        ]
        if type == "array":
            name = ctx
        elif type == "primary":
            name = ctx.identifier()
        elif type == "methodCall":
            name = ctx.identifier()
            kinds = ["method", "interfaceCommonBody"]

        if "extend" in ent.get_metadata() and ent.get_metadata()["extend"]:
            class_parent = ent.get_metadata()["extend"]
            class_parent_ent = find_class_by_fileName(class_parent, self.allClasses)
            for kind in kinds:
                temp_ent = find_enteties_from_parent_class(
                    name.getText(), class_parent_ent, kind
                )
                if temp_ent:
                    self.castIdentifier(name, temp_ent)
                    return
        elif (
            "implementList" in ent.get_metadata()
            and ent.get_metadata()["implementList"]
        ):
            class_parents = ent.get_metadata()["implementList"]
            for class_parent in class_parents:
                class_parent_ent = find_class_by_fileName(class_parent, self.allClasses)
                for kind in kinds:
                    temp_ent = find_enteties_from_parent_class(
                        name.getText(), class_parent_ent, kind
                    )
                    if temp_ent:
                        self.castIdentifier(name, temp_ent)
                        return
        if type == "primary":
            ent = self.handleTypeIdentifiers(
                ctx.identifier(), ctx.identifier().getText()
            )

            if ent is None:
                ent = self.handleGlobalIdentifiers(
                    ctx.identifier(), ctx.identifier().getText()
                )

    # ------------ Resolve type identifiers  & special cases------------
    def handleTypeIdentifiers(self, ctx, name):
        if name == "this":
            name == self.currentFile.replace(".java", "")
        ent = find_enteties_for_type_identifier(name, self.usedClasses)
        if ent:
            self.castIdentifier(ctx, ent)
            return ent

    def handleGlobalIdentifiers(self, ctx, name):
        if name == "this":
            name == self.currentFile.replace(".java", "")
        ent = find_enteties_for_global_identifier(
            name, [classEnt.fileName for classEnt in self.allClasses]
        )
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
            parentEntity = self.handleTypeIdentifiers(members[0], members[0].getText())
            if parentEntity:  # check for not Map.Entry::getKey, Map.Entry::getValue,
                ent = find_enteties_for_members(
                    members[1].getText(), parentEntity, "method"
                )
                if ent:
                    self.castIdentifier(members[1], ent)

    # ------------ Resolve and Rename member accesses ------------
    def resolveMemberAccess(self, ctx):
        # print("member : ", ctx.getText())
        members = self.memberFinder(ctx)
        self.extractList(members, True)

    def memberFinder(self, ctx):
        members = []
        for child in ctx.getChildren():
            if child.getText() != ".":
                if (
                    isinstance(child, JavaParser.ExpressionContext)
                    and child.bop
                    and child.bop.text == "."
                ):
                    members.extend(self.memberFinder(child))
                else:
                    members.append(child)
        return members

    def extractList(
        self,
        parts,
        isFirstIteration,
        entity_from_last_iteration=None,
    ):
        left = parts[0]
        right = parts[1:]

        left_name = None
        if left.getText() == "this":
            left_name = self.currentFile.replace(".java", "")
        else:
            left_name = left.getText()

        varOrReturnType = None
        if not isFirstIteration:
            if entity_from_last_iteration is None:
                return

            varOrReturnType = entity_from_last_iteration.varOrReturnType
            iterables_arr = ["ArrayList", "List"]  # "HashMap", "Map"
            for iterable_name in iterables_arr:
                if entity_from_last_iteration.varOrReturnType.startswith(
                    iterable_name
                ) and left_name.startswith("get("):
                    varOrReturnType = varOrReturnType.split("<")[1][:-1]
                    if len(right) > 0:
                        temp = right
                        left = temp[0]
                        right = temp[1:]
                    else:
                        return

            if varOrReturnType not in [classEnt.name for classEnt in self.allClasses]:
                return

        ent = None
        if isFirstIteration:
            ent = find_enteties_for_type_identifier(left_name, self.usedClasses)
            if ent is None:
                ent = self.visitExpression(left)
        else:
            ent = self.visitExpressionForMember(left, right, varOrReturnType)

        # continue the process for other members if availabe
        if len(right) > 0:
            self.extractList(right, False, ent)

        # At the end rename:
        if ent:
            if left.getText() != "this":
                self.castIdentifier(left, ent)
        else:
            pass

    def visitExpressionForMember(self, left, right, varOrReturnType):
        ent = None
        parentEntity = find_fileName_from_entity_type(
            varOrReturnType, [classEnt.fileName for classEnt in self.allClasses]
        )

        if isinstance(left, JavaParser.MethodCallContext):
            name = left.identifier().getText()

            ent = find_enteties_for_members(name, parentEntity, "method")
            if ent is None:
                ent = find_enteties_for_members(
                    name, parentEntity, "interfaceCommonBody"
                )
            if ent:
                return ent
        else:
            entity_types = ["field", "constant", "enumConstant"]
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

        # inheritance

        temp_ent = None
        class_parent_ent = find_class_by_fileName(varOrReturnType, self.allClasses)
        while class_parent_ent is not None:
            kinds = [
                "localVariable",
                "formalParameter",
                "field",
                "constant",
                "enumConstant",
            ]
            if (
                isinstance(left, JavaParser.ExpressionContext)
                and left.LBRACK()
                and left.RBRACK()
            ) or isinstance(left, JavaParser.IdentifierContext):
                name = left
            elif isinstance(left, JavaParser.MethodCallContext):
                name = left.identifier()
                kinds = ["method", "interfaceCommonBody"]

            if (
                class_parent_ent
                and "extend" in class_parent_ent.get_metadata()
                and class_parent_ent.get_metadata()["extend"]
            ):
                class_parent = class_parent_ent.get_metadata()["extend"]
                class_parent_ent = find_class_by_fileName(class_parent, self.allClasses)
                for kind in kinds:
                    temp_ent = find_enteties_from_parent_class(
                        name.getText(), class_parent_ent, kind
                    )
                    if temp_ent:
                        return temp_ent
            elif (
                class_parent_ent
                and "implementList" in class_parent_ent.get_metadata()
                and class_parent_ent.get_metadata()["implementList"]
            ):
                class_parents = class_parent_ent.get_metadata()["implementList"]
                for class_parent in class_parents:
                    class_parent_ent = find_class_by_fileName(class_parent, self.allClasses)
                    for kind in kinds:
                        temp_ent = find_enteties_from_parent_class(
                            name.getText(), class_parent_ent, kind
                        )
                        if temp_ent:
                            return temp_ent
            else:
                return

    # ------------ Utility Functions ------------
    def castIdentifier(self, ctx, result):
        # adding filters
        self.rewriter.replaceSingleToken(ctx.start, result.newName)
