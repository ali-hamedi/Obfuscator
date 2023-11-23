from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser
from app.gen.JavaParserListener import JavaParserListener
from app.models.ent import Entity


class Extractor(JavaParserListener):
    def __init__(self, currentFile):
        self.currentFile = currentFile

        # 7 RULE_classDeclaration
        # 25 RULE_constructorDeclaration
        # 27 RULE_fieldDeclaration
        # 20 RULE_methodDeclaration
        # todo
        # formal parameter
        # methodBody
        # block
        # blockStatement
        # localVariableDeclaration ';'
        # localTypeDeclaration

        # 15 RULE_interfaceDeclaration
        # 30 RULE_constDeclaration
        # 35 RULE_interfaceCommonBodyDeclaration

        # 12 RULE_enumConstant
        # 11 RULE_enumDeclaration

        # todo : lambda
        # todo : access : primary,expression level 16

    # name =,fileName,line,kind,parent,varOrReturnType,value,metadata
    # KIND_CHOICES = ["class","interface","enum","const","var","method","obj","generic"]

    def enterCompilationUnit(self, ctx: JavaParser.CompilationUnitContext):
        for typeDecl in ctx.typeDeclaration():
            self.handleTypeDeclaration(typeDecl, None)

    def handleTypeDeclaration(
        self, ctx: JavaParser.TypeDeclarationContext, parentEntity
    ):
        if ctx.classDeclaration():
            self.handleClassDeclaration(ctx.classDeclaration(), parentEntity)

    # ---------- Extracting all entites from a class -----------------
    def handleClassDeclaration(
        self, ctx: JavaParser.ClassDeclarationContext, parentEntity
    ):
        # extracting the inital data from the class entity
        name = ctx.identifier().getText()
        fileName = self.currentFile
        line = ctx.start.line
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
        if ctx.EXTENDS():
            extend = ctx.typeType().getText()
        metadata["extend"] = extend

        # insert the entity in the table
        new_class_entity = Entity.create(
            name=name,
            fileName=fileName,
            line=line,
            kind=kind,
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
            elif (
                member.constructorDeclaration()
                or member.genericConstructorDeclaration()
            ):
                pass
            else:
                self.handleTypeDeclaration(member, new_class_entity)

    def handleFields(self, ctx: JavaParser.FieldDeclarationContext, parentEntity):
        # extracting the inital data from the field entity
        for variableDecl in ctx.variableDeclarators().variableDeclarator():
            name = variableDecl.variableDeclaratorId().identifier().getText()
            fileName = self.currentFile
            line = ctx.start.line
            kind = "field"
            parent = parentEntity
            varOrReturnType = ctx.typeType().getText()
            # todo: more specific  variableInitializer: arrayInitializer | expression;
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
                line=line,
                kind=kind,
                parent=parent,
                varOrReturnType=varOrReturnType,
                value=value,
                metadata=metadata,
            )
            new_field_entity.save()

    def handleMethods(self, ctx: JavaParser.MethodDeclarationContext, parentEntity):
        # extracting the inital data from the method entity
        name = ctx.identifier().getText()
        fileName = self.currentFile
        line = ctx.start.line
        kind = "method"
        varOrReturnType = ctx.typeTypeOrVoid().getText()
        parent = parentEntity
        value = None

        # extracting meta data from the class entity such as implements,extends,...
        metadata = {}
        modifiers = []
        if ctx.parentCtx.parentCtx.modifier():
            modifiers = ctx.parentCtx.parentCtx.modifier()  # methods
        elif ctx.parentCtx.parentCtx.parentCtx.modifier():
            modifiers = ctx.parentCtx.parentCtx.parentCtx.modifier()  # generic methods

        tempList = []
        for modifier in ctx.parentCtx.parentCtx.modifier():
            tempList.append(modifier.getText())
        metadata["modifiers"] = tempList

        # insert the entity in the table
        new_method_entity = Entity.create(
            name=name,
            fileName=fileName,
            line=line,
            kind=kind,
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
        # extracting entities from the method body
        for statement in ctx.methodBody().block().blockStatement():
            self.handleMethodBodyStatements(statement, new_method_entity)

    def handleFormalParameter(
        self, ctx: JavaParser.FormalParameterContext, parentEntity
    ):
        name = ctx.variableDeclaratorId().identifier().getText()
        fileName = self.currentFile
        line = ctx.start.line
        kind = "formalParameter"
        parent = parentEntity
        varOrReturnType = ctx.typeType().getText()
        value = None
        metadata = {}

        # insert the entity in the table
        new_formalParameter_entity = Entity.create(
            name=name,
            fileName=fileName,
            line=line,
            kind=kind,
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
            if ctx.statement().FOR():
                self.handleForStatement(ctx.statement(), parentEntity)
            # todo other expressions,statements .....

    def handleLocalVariableDeclaration(
        self, ctx: JavaParser.LocalVariableDeclarationContext, parentEntity
    ):
        if ctx.typeType():
            for variableDecl in ctx.variableDeclarators().variableDeclarator():
                name = variableDecl.variableDeclaratorId().identifier().getText()
                fileName = self.currentFile
                line = ctx.start.line
                kind = "localVariable"
                parent = parentEntity
                varOrReturnType = ctx.typeType().getText()
                # todo: more specific  variableInitializer: arrayInitializer | expression;
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
                    line=line,
                    kind=kind,
                    parent=parent,
                    varOrReturnType=varOrReturnType,
                    value=value,
                    metadata=metadata,
                )
                new_localVariable_entity.save()
        else:
            name = ctx.identifier()
            fileName = self.currentFile
            line = ctx.start.line
            kind = "localVariable"
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
                varOrReturnType = "bool"
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
                line=line,
                kind=kind,
                parent=parent,
                varOrReturnType=varOrReturnType,
                value=value,
                metadata=metadata,
            )
            new_localVariable_entity.save()

    def handleForStatement(self, ctx: JavaParser.StatementContext, parentEntity):
        if ctx.forControl().enhancedForControl():
            currentCtx = ctx.forControl().enhancedForControl()
            name = currentCtx.variableDeclaratorId().identifier().getText()
            fileName = self.currentFile
            line = currentCtx.start.line
            kind = "localVariable"
            parent = parentEntity
            varOrReturnType = None
            if currentCtx.typeType():
                varOrReturnType = currentCtx.typeType().getText()
            # todo: more specific  variableInitializer: arrayInitializer | expression;
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
                line=line,
                kind=kind,
                parent=parent,
                varOrReturnType=varOrReturnType,
                value=value,
                metadata=metadata,
            )
            new_localVariable_entity.save()

        else:
            self.handleLocalVariableDeclaration(
                ctx.forControl().forInit().localVariableDeclaration(), parentEntity
            )


# | fieldDeclaration

# | methodDeclaration
# | genericMethodDeclaration

# | constructorDeclaration
# | genericConstructorDeclaration

# | interfaceDeclaration
# | annotationTypeDeclaration
# | classDeclaration
# | enumDeclaration;
# recordDeclaration //Java17
