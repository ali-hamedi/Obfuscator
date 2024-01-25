from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser
from app.gen.JavaParserListener import JavaParserListener
from app.data.models.ent import Entity
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
        alongside their properties and each time we traverse deeper we pass the current entity as the parent entity for 
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


class Extractor:
    def __init__(
        self, currentFile: str, compilationUnit: JavaParser.CompilationUnitContext
    ):
        self.currentFile = currentFile
        self.compilationUnit = compilationUnit
        self.newFileName = ""
        self.packageName = ""
        # todo:  25 RULE_constructorDeclaration

        # todo : lambda
        # todo : access : primary,expression level 16

    def startExtracting(self):
        if self.compilationUnit.packageDeclaration():
            self.packageName = (
                self.compilationUnit.packageDeclaration().qualifiedName().getText()
            )
        for typeDecl in self.compilationUnit.typeDeclaration():
            newName = self.handleTypeDeclaration(typeDecl, None)
            self.newFileName = newName

    def handleTypeDeclaration(
        self, ctx: JavaParser.TypeDeclarationContext, parentEntity
    ):
        if ctx.classDeclaration():
            return self.handleClassDeclaration(ctx.classDeclaration(), parentEntity)
        elif ctx.enumDeclaration():
            return self.handleEnumDeclaration(ctx.enumDeclaration(), parentEntity)
        elif ctx.interfaceDeclaration():
            return self.handleInterfaceDeclaration(
                ctx.interfaceDeclaration(), parentEntity
            )
        else:
            pass

    # ---------- Extracting all entites from a Class -----------------
    def handleClassDeclaration(
        self, ctx: JavaParser.ClassDeclarationContext, parentEntity
    ):
        # extracting the inital data from the class entity
        name = ctx.identifier().getText()
        fileName = self.currentFile
        startLine = ctx.start.line
        stopLine = ctx.stop.line
        kind_index = 7
        kind = "class"
        parent = parentEntity
        varOrReturnType = name
        value = None

        # extracting meta data from the class entity such as implements,extends,...
        metadata = {}

        tempList = []
        if ctx.IMPLEMENTS():
            for cls in ctx.typeList():
                tempList.append(cls.getText())
        metadata["implementList"] = tempList
        extend = None
        if ctx.EXTENDS() and ctx.typeType():
            extend = ctx.typeType().getText()
        metadata["extend"] = extend

        # insert the entity in the table
        new_class_entity = Entity.create(
            name=name,
            fileName=fileName,
            startLine=startLine,
            stopLine=stopLine,
            kind=kind,
            kind_index=kind_index,
            parent=parent,
            varOrReturnType=varOrReturnType,
            value=value,
            metadata=metadata,
        )
        new_class_entity.save()

        # extracting members (fields,methods,constructor,other TypeDeclarations) from classBody
        for classBodyDeclaration in ctx.classBody().classBodyDeclaration():
            member = classBodyDeclaration.memberDeclaration()
            if member.fieldDeclaration():
                self.handleFields(member.fieldDeclaration(), new_class_entity)
            elif member.genericMethodDeclaration():
                self.handleMethods(
                    member.genericMethodDeclaration().methodDeclaration(),
                    new_class_entity,
                )
            elif member.methodDeclaration():
                self.handleMethods(member.methodDeclaration(), new_class_entity)
            elif member.constructorDeclaration():
                self.handleMethods(
                    member.constructorDeclaration(), new_class_entity, False, True
                )
            elif member.genericConstructorDeclaration():
                self.handleMethods(
                    member.genericConstructorDeclaration().constructorDeclaration(),
                    new_class_entity,
                    False,
                    True,
                )
            else:
                self.handleTypeDeclaration(member, new_class_entity)
        return new_class_entity.newName

    def handleFields(self, ctx: JavaParser.FieldDeclarationContext, parentEntity):
        # extracting the inital data from the field entity
        for variableDecl in ctx.variableDeclarators().variableDeclarator():
            name = variableDecl.variableDeclaratorId().identifier().getText()
            fileName = self.currentFile
            startLine = ctx.start.line
            stopLine = ctx.stop.line
            kind_index = 27
            kind = "field"
            parent = parentEntity
            varOrReturnType = ctx.typeType().getText()
            if (
                variableDecl.variableDeclaratorId().LBRACK()
                and variableDecl.variableDeclaratorId().RBRACK()
            ):
                varOrReturnType = ctx.typeType().getText() + "[]"
            value = None
            if variableDecl.variableInitializer():
                value = variableDecl.variableInitializer().getText()
            else:
                value = None

            # extracting meta data from the class entity such as implements,extends,...
            metadata = {}

            modifiers = []
            for modifier in ctx.parentCtx.parentCtx.modifier():
                modifiers.append(modifier.getText())
            metadata["modifiers"] = modifiers

            # insert the entity in the table
            new_field_entity = Entity.create(
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
            new_field_entity.save()

    def handleMethods(
        self,
        ctx: JavaParser.MethodDeclarationContext,
        parentEntity,
        isInterfaceCommonBody=False,
        isConstructor=False,
    ):
        # extracting the inital data from the method entity
        name = ctx.identifier().getText()
        fileName = self.currentFile
        startLine = ctx.start.line
        stopLine = ctx.stop.line
        kind = "method"
        kind_index = 20
        if isInterfaceCommonBody:
            kind = "interfaceCommonBody"
            kind_index = 35
        if isConstructor:
            kind = "constructor"
            kind_index = 25
        if isConstructor:
            varOrReturnType = parentEntity.name
        else:
            varOrReturnType = ctx.typeTypeOrVoid().getText()
        parent = parentEntity
        value = None

        # extracting meta data from the class entity such as implements,extends,...
        metadata = {}
        modifiers = []
        if (
            hasattr(ctx.parentCtx.parentCtx, "modifier")
            and ctx.parentCtx.parentCtx.modifier()
        ):
            modifiers = ctx.parentCtx.parentCtx.modifier()  # methods
        elif (
            hasattr(ctx.parentCtx.parentCtx.parentCtx, "modifier")
            and ctx.parentCtx.parentCtx.parentCtx.modifier()
        ):
            modifiers = ctx.parentCtx.parentCtx.parentCtx.modifier()  # generic methods

        tempList = []
        for modifier in modifiers:
            tempList.append(modifier.getText())
        metadata["modifiers"] = tempList

        # insert the entity in the table
        new_method_entity = Entity.create(
            name=name,
            fileName=fileName,
            startLine=startLine,
            stopLine=stopLine,
            kind=kind,
            kind_index=kind_index,
            parent=parent,
            varOrReturnType=varOrReturnType,
            value=value,
            metadata=metadata,
        )
        new_method_entity.save()

        # extracting entities from  the method parameters
        if ctx.formalParameters() and ctx.formalParameters().formalParameterList():
            for parameter in (
                ctx.formalParameters().formalParameterList().formalParameter()
            ):
                self.handleFormalParameter(
                    parameter,
                    new_method_entity,
                )
        if (
            isConstructor
            or (ctx.methodBody() is None)
            or (ctx.methodBody().block() is None)
        ):
            return

        # extracting entities from the method body
        for statement in ctx.methodBody().block().blockStatement():
            self.handleMethodBodyStatements(statement, new_method_entity)

    def handleFormalParameter(
        self, ctx: JavaParser.FormalParameterContext, parentEntity
    ):
        name = ctx.variableDeclaratorId().identifier().getText()
        fileName = self.currentFile
        startLine = ctx.start.line
        stopLine = ctx.stop.line
        kind = "formalParameter"
        kind_index = 47
        parent = parentEntity
        varOrReturnType = ctx.typeType().getText()
        if ctx.variableDeclaratorId().LBRACK() and ctx.variableDeclaratorId().RBRACK():
            varOrReturnType = ctx.typeType().getText() + "[]"
        value = None
        metadata = {}

        # insert the entity in the table
        new_formalParameter_entity = Entity.create(
            name=name,
            fileName=fileName,
            startLine=startLine,
            stopLine=stopLine,
            kind=kind,
            kind_index=kind_index,
            parent=parent,
            varOrReturnType=varOrReturnType,
            value=value,
            metadata=metadata,
        )
        new_formalParameter_entity.save()

    def handleMethodBodyStatements(
        self, ctx: JavaParser.BlockStatementContext, parentEntity
    ):
        if ctx.localVariableDeclaration():
            self.handleLocalVariableDeclaration(
                ctx.localVariableDeclaration(), parentEntity
            )
        elif ctx.localTypeDeclaration():
            self.handleTypeDeclaration(ctx.localTypeDeclaration(), parentEntity)
        else:
            # nested for s
            tempForStatementList = self.forStatementFinder(ctx.statement())
            if len(tempForStatementList) > 0:
                for forStatement in tempForStatementList:
                    self.handleForStatement(forStatement, parentEntity)

            # nested variable declaration inside the statements/codeFlow
            tempVarDeclIdList = self.variableDeclratorIdFinder(ctx.statement())
            if len(tempVarDeclIdList) > 0:
                for varDecl in tempVarDeclIdList:
                    if (
                        varDecl.parentCtx.getRuleIndex() == 37
                        and varDecl.parentCtx.parentCtx.getRuleIndex() == 36
                    ):
                        self.handleLocalVariableDeclaration(
                            varDecl.parentCtx.parentCtx.parentCtx, parentEntity
                        )
                    elif (
                        varDecl.parentCtx.getRuleIndex() == 95
                        and varDecl.parentCtx.parentCtx.getRuleIndex() == 93
                    ):
                        continue
                    else:
                        # ? debugging tool
                        print(
                            "    ",
                            varDecl.getText(),
                            varDecl.parentCtx.getText(),
                            varDecl.parentCtx.getRuleIndex(),
                            varDecl.parentCtx.parentCtx.getText(),
                            varDecl.parentCtx.parentCtx.getRuleIndex(),
                            varDecl.parentCtx.parentCtx.parentCtx.getText(),
                            varDecl.parentCtx.parentCtx.parentCtx.getRuleIndex(),
                        )
        return

    def variableDeclratorIdFinder(self, ctx):
        # recursive method to find all the variableDeclratorIds deep down a context
        nodes = []
        if isinstance(ctx, TerminalNode):
            return nodes
        if ctx.getRuleIndex() == 38:
            nodes.append(ctx)

        for child in ctx.getChildren():
            nodes.extend(self.variableDeclratorIdFinder(child))

        return nodes

    def forStatementFinder(self, ctx):
        # recursive method to find all the forStaements deep down a context
        nodes = []
        if isinstance(ctx, TerminalNode):
            return nodes
        if isinstance(ctx, JavaParser.StatementContext) and ctx.FOR():
            nodes.append(ctx)

        for child in ctx.getChildren():
            nodes.extend(self.forStatementFinder(child))

        return nodes

    def handleLocalVariableDeclaration(
        self, ctx: JavaParser.LocalVariableDeclarationContext, parentEntity
    ):
        if ctx.typeType():
            # extracting inital data for the local variable entity
            for variableDecl in ctx.variableDeclarators().variableDeclarator():
                name = variableDecl.variableDeclaratorId().identifier().getText()
                fileName = self.currentFile
                startLine = ctx.start.line
                stopLine = ctx.stop.line
                kind = "localVariable"
                kind_index = 80
                parent = parentEntity
                varOrReturnType = ctx.typeType().getText()
                if (
                    variableDecl.variableDeclaratorId().LBRACK()
                    and variableDecl.variableDeclaratorId().RBRACK()
                ):
                    varOrReturnType = ctx.typeType().getText() + "[]"
                value = None
                if variableDecl.variableInitializer():
                    value = variableDecl.variableInitializer().getText()
                else:
                    value = None

                # extracting meta data from the local variable entity such as modifiers,...
                metadata = {}

                tempList = []
                for modif in ctx.variableModifier():
                    tempList.append(modif.getText())
                metadata["modifiers"] = tempList

                # insert the entity in the table
                new_localVariable_entity = Entity.create(
                    name=name,
                    fileName=fileName,
                    startLine=startLine,
                    stopLine=stopLine,
                    kind=kind,
                    kind_index=kind_index,
                    parent=parent,
                    varOrReturnType=varOrReturnType,
                    value=value,
                    metadata=metadata,
                )
                new_localVariable_entity.save()
        else:
            # extracting inital data for the local variable entity
            name = ctx.identifier()
            fileName = self.currentFile
            startLine = ctx.start.line
            stopLine = ctx.stop.line
            kind = "localVariable"
            kind_index = 80
            parent = parentEntity
            varOrReturnType = None
            if ctx.expression().primary().literal().STRING_LITERAL:
                varOrReturnType = "String"
            elif ctx.expression().primary().literal().integerLiteral:
                varOrReturnType = "int"
            elif ctx.expression().primary().literal().floatLiteral:
                varOrReturnType = "floart"
            elif ctx.expression().primary().literal().CHAR_LITERAL:
                varOrReturnType = "char"
            elif ctx.expression().primary().literal().BOOL_LITERAL:
                varOrReturnType = "boolean"
            value = ctx.expression().getText()

            # extracting meta data from the local variable entity such as modifiers,...
            metadata = {}

            tempList = []
            for modif in ctx.variableModifier():
                tempList.append(modif.getText())
            metadata["modifiers"] = tempList

            # insert the entity in the table
            new_localVariable_entity = Entity.create(
                name=name,
                fileName=fileName,
                startLine=startLine,
                stopLine=stopLine,
                kind=kind,
                kind_index=kind_index,
                parent=parent,
                varOrReturnType=varOrReturnType,
                value=value,
                metadata=metadata,
            )
            new_localVariable_entity.save()

    def handleForStatement(self, ctx: JavaParser.StatementContext, parentEntity):
        if ctx.forControl().enhancedForControl():
            # extracting a localVariable entity from a For statement
            currentCtx = ctx.forControl().enhancedForControl()
            name = currentCtx.variableDeclaratorId().identifier().getText()
            fileName = self.currentFile
            startLine = ctx.start.line
            stopLine = ctx.stop.line
            kind = "localVariable"
            kind_index = 80
            parent = parentEntity
            varOrReturnType = None
            if currentCtx.typeType():
                varOrReturnType = currentCtx.typeType().getText()
                if (
                    currentCtx.variableDeclaratorId().LBRACK()
                    and currentCtx.variableDeclaratorId().RBRACK()
                ):
                    varOrReturnType = currentCtx.typeType().getText() + "[]"
            value = None
            value = currentCtx.expression().getText()
            # extracting meta data from the local variable entity such as modifiers,...
            metadata = {}
            tempList = []
            for modif in currentCtx.variableModifier():
                tempList.append(modif.getText())
            metadata["modifiers"] = tempList

            # insert the entity in the table
            new_localVariable_entity = Entity.create(
                name=name,
                fileName=fileName,
                startLine=startLine,
                stopLine=stopLine,
                kind=kind,
                kind_index=kind_index,
                parent=parent,
                varOrReturnType=varOrReturnType,
                value=value,
                metadata=metadata,
            )
            new_localVariable_entity.save()

        else:
            # extracting a localVariable entity from a For statement
            self.handleLocalVariableDeclaration(
                ctx.forControl().forInit().localVariableDeclaration(), parentEntity
            )

    # ---------- Extracting all entites from an Enum -----------------

    def handleEnumDeclaration(
        self, ctx: JavaParser.EnumDeclarationContext, parentEntity
    ):
        # extracting the inital data from the enum entity
        name = ctx.identifier().getText()
        fileName = self.currentFile
        startLine = ctx.start.line
        stopLine = ctx.stop.line
        kind = "enum"
        kind_index = 11
        parent = parentEntity
        varOrReturnType = name
        value = None

        # extracting meta data from the enum entity such as implements,...
        metadata = {}

        tempList = []
        if ctx.IMPLEMENTS():
            for cls in ctx.typeList():
                tempList.append(cls.getText())
        metadata["implementList"] = tempList

        # insert the entity in the table
        new_enum_entity = Entity.create(
            name=name,
            fileName=fileName,
            startLine=startLine,
            stopLine=stopLine,
            kind=kind,
            kind_index=kind_index,
            parent=parent,
            varOrReturnType=varOrReturnType,
            value=value,
            metadata=metadata,
        )
        new_enum_entity.save()

        if ctx.enumConstants():
            for enumConst in ctx.enumConstants().enumConstant():
                self.handleEnumConstant(enumConst, new_enum_entity)
        return new_enum_entity.newName

    def handleEnumConstant(self, ctx: JavaParser.EnumConstantContext, parentEntity):
        # extracting the inital data from the enum constant
        name = ctx.identifier().getText()
        fileName = self.currentFile
        startLine = ctx.start.line
        stopLine = ctx.stop.line
        kind = "enumConstant"
        kind_index = 13
        parent = parentEntity
        varOrReturnType = name
        value = name

        # extracting meta data from the enum entity such as arguments,...
        metadata = {}

        tempList = []
        if ctx.arguments():
            for cls in ctx.arguments():
                tempList.append(cls.getText())
        metadata["arguments"] = tempList

        # insert the entity in the table
        new_enumConstant_entity = Entity.create(
            name=name,
            fileName=fileName,
            startLine=startLine,
            stopLine=stopLine,
            kind=kind,
            kind_index=kind_index,
            parent=parent,
            varOrReturnType=varOrReturnType,
            value=value,
            metadata=metadata,
        )
        new_enumConstant_entity.save()

    # ---------- Extracting all entites from an Interface -----------------

    def handleInterfaceDeclaration(
        self, ctx: JavaParser.InterfaceDeclarationContext, parentEntity
    ):
        # extracting the inital data from the interface entity
        name = ctx.identifier().getText()
        fileName = self.currentFile
        startLine = ctx.start.line
        stopLine = ctx.stop.line
        kind = "interface"
        kind_index = 15
        parent = parentEntity
        varOrReturnType = name
        value = None

        # extracting meta data from the interface entity such as extends,...
        metadata = {}

        extend = None
        if ctx.EXTENDS():
            extend = ctx.typeType().getText()
        metadata["extend"] = extend

        # insert the entity in the table
        new_interface_entity = Entity.create(
            name=name,
            fileName=fileName,
            startLine=startLine,
            stopLine=stopLine,
            kind=kind,
            kind_index=kind_index,
            parent=parent,
            varOrReturnType=varOrReturnType,
            value=value,
            metadata=metadata,
        )
        new_interface_entity.save()

        # extracting members (constants,methods,other TypeDeclarations) from interfaceBody
        for interfaceBodyDeclaration in ctx.interfaceBody().interfaceBodyDeclaration():
            interfaceMember = interfaceBodyDeclaration.interfaceMemberDeclaration()
            if interfaceMember.constDeclaration():
                self.handleConstDeclaration(
                    interfaceMember.constDeclaration(), new_interface_entity
                )
            elif interfaceMember.genericInterfaceMethodDeclaration():
                self.handleMethods(
                    interfaceMember.genericInterfaceMethodDeclaration().interfaceCommonBodyDeclaration(),
                    new_interface_entity,
                    True,
                )
            elif interfaceMember.interfaceMethodDeclaration():
                self.handleMethods(
                    interfaceMember.interfaceMethodDeclaration().interfaceCommonBodyDeclaration(),
                    new_interface_entity,
                    True,
                )
            elif (
                interfaceMember.constructorDeclaration()
                or interfaceMember.genericConstructorDeclaration()
            ):
                pass
            else:
                self.handleTypeDeclaration(interfaceMember, new_interface_entity)
        return new_interface_entity.newName

    def handleConstDeclaration(
        self, ctx: JavaParser.ConstDeclarationContext, parentEntity
    ):
        # extracting the inital data from the field entity
        for variableDecl in ctx.constantDeclarator():
            name = variableDecl.identifier().getText()
            fileName = self.currentFile
            startLine = ctx.start.line
            stopLine = ctx.stop.line
            kind = "constant"
            kind_index = 31
            parent = parentEntity
            varOrReturnType = ctx.typeType().getText()
            # todo: more specific  variableInitializer: arrayInitializer | expression;
            value = variableDecl.variableInitializer().getText()

            # extracting meta data from the class entity such as implements,extends,...
            metadata = {}

            modifiers = []
            for modifier in ctx.parentCtx.parentCtx.modifier():
                modifiers.append(modifier.getText())
            metadata["modifiers"] = modifiers

            # insert the entity in the table
            new_const_entity = Entity.create(
                name=name,
                fileName=fileName,
                startLine=startLine,
                stopLine=stopLine,
                kind=kind,
                kind_index=kind_index,
                parent=parent,
                varOrReturnType=varOrReturnType,
                value=value,
                metadata=metadata,
            )
            new_const_entity.save()
