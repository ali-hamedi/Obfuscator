from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser
from app.gen.JavaParserListener import JavaParserListener
from app.data.models.ent import Entity
from app.data.db import *
from antlr4 import *
from antlr4.TokenStreamRewriter import *
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import padding
from base64 import b64encode, b64decode
import base64
import secrets, itertools, re
import subprocess
import os


class Encryptor(JavaParserListener):
    def __init__(self, currentFile: str, usedClasses, key, iv, commonTokenStream):
        self.currentFile = currentFile
        self.rewriter = TokenStreamRewriter(commonTokenStream)
        self.type_to_transform = {
            # "String": "MyCipher.getInstance().decode({})",
            "String": "MyCipher.getInstance().decode({})",
            "int": "Integer.parseInt(MyCipher.getInstance().decode({}))",
            "Integer": "Integer.parseInt(MyCipher.getInstance().decode({}))",
            "float": "Float.parseFloat(MyCipher.getInstance().decode({}))",
            "Float": "Float.parseFloat(MyCipher.getInstance().decode({}))",
            "double": "Double.parseDouble(MyCipher.getInstance().decode({}))",
            "Double": "Double.parseDouble(MyCipher.getInstance().decode({}))",
            "char": "MyCipher.getInstance().decode({}).charAt(0)",
            "Character": "MyCipher.getInstance().decode({}).charAt(0)",
            "boolean": "Boolean.parseBoolean(MyCipher.getInstance().decode({}))",
            "Boolean": "Boolean.parseBoolean(MyCipher.getInstance().decode({}))",
            "long": "Long.parseLong(MyCipher.getInstance().decode({}))",
            "Long": "Long.parseLong(MyCipher.getInstance().decode({}))",
            "short": "Short.parseShort(MyCipher.getInstance().decode({}))",
            "Short": "Short.parseShort(MyCipher.getInstance().decode({}))",
        }
        self.primitive = (
            "String",
            "Integer",
            "int",
            "Float",
            "float",
            "Double",
            "double",
            "Short",
            "short",
            "Long",
            "long",
            "Character",
            "char",
            "Boolean",
            "boolean",
        )
        self.usedClasses = usedClasses
        self.allClasses = get_all_type_declarations()
        self.key = key
        self.iv = iv

    def enterCompilationUnit(self, ctx: JavaParser.CompilationUnitContext):
        if ctx.importDeclaration() and len(ctx.importDeclaration()) > 0:
            tempCtx = ctx.importDeclaration()[len(ctx.importDeclaration()) - 1]
            self.rewriter.insertAfterToken(
                tempCtx.stop, "\nimport ir.ac.kntu.MyCipher;\n"
            )
        elif ctx.packageDeclaration():
            self.rewriter.insertAfterToken(
                ctx.packageDeclaration().stop, "\nimport ir.ac.kntu.MyCipher;\n"
            )

    # ----------------- handle inline literals -----------------------
    def enterLiteral(self, ctx: JavaParser.LiteralContext):
        # check that the literal is not in An intializiation
        # we handle them seperatly : LocalVariable,Field,Constant declarations
        t = ctx.parentCtx
        while t.parentCtx is not None:
            if isinstance(t, JavaParser.VariableInitializerContext):
                return
            t = t.parentCtx

        #  check that the literal is not in an Assignment
        # we handle them seperatly : VisitExpression
        t = ctx.parentCtx
        while t.parentCtx is not None:
            if (
                isinstance(t, JavaParser.ExpressionContext)
                and t.bop
                and t.bop.text
                in (
                    "=",
                    "+=",
                    "-=",
                    "*=",
                    "/=",
                    "&=",
                    "|=",
                    "^=",
                    ">>=",
                    ">>>=",
                    "<<=",
                    "%=",
                )
            ):
                return
            t = t.parentCtx

        # special cases:
        #   avoid modifying the case statments cause "case expressions must be constant expressions"
        t = ctx
        while t.parentCtx:
            if isinstance(t, JavaParser.SwitchLabeledRuleContext) or isinstance(
                t, JavaParser.SwitchLabelContext
            ):
                return
            t = t.parentCtx

        # handle without context literal
        self.encodeLiteral(ctx, True)
        return

    # ------------- handle intilizations ------------------
    def enterLocalVariableDeclaration(
        self, ctx: JavaParser.LocalVariableDeclarationContext
    ):
        if ctx.typeType():
            # dataType identifier = variableIntilizer
            self.modifyDataType(ctx.typeType())
            for variableDecl in ctx.variableDeclarators().variableDeclarator():
                if variableDecl.variableInitializer():
                    self.handleInitializations(variableDecl.variableInitializer())
        else:
            # VAR identifier = expression
            self.handleRightSide(ctx.expression(), True)

    def enterFieldDeclaration(self, ctx: JavaParser.FieldDeclarationContext):
        # dataType identifier = variableIntilizer
        self.modifyDataType(ctx.typeType())
        for variableDecl in ctx.variableDeclarators().variableDeclarator():
            if variableDecl.variableInitializer():
                self.handleInitializations(variableDecl.variableInitializer())

    def enterConstDeclaration(self, ctx: JavaParser.ConstDeclarationContext):
        # dataType identifier = variableIntilizer
        self.modifyDataType(ctx.typeType())
        for constantDecl in ctx.constantDeclarator():
            self.handleInitializations(constantDecl.variableInitializer())

    def handleInitializations(self, ctx: JavaParser.VariableInitializerContext):
        name = None
        ancestor = None
        if isinstance(ctx.parentCtx, JavaParser.ConstantDeclaratorContext):
            # constDeclaration -> constantDeclarator -> variableInitializer
            name = ctx.parentCtx.identifier().getText()
            ancestor = ctx.parentCtx.parentCtx
        elif isinstance(ctx.parentCtx, JavaParser.VariableDeclaratorContext):
            # field/local variable -> variableDeclarators -> variableDeclarator -> variableInitializer
            name = ctx.parentCtx.variableDeclaratorId().identifier().getText()
            ancestor = ctx.parentCtx.parentCtx.parentCtx

        # VariableIntializer -> ArrayIntilizer -> VariableIntializer
        if ctx.arrayInitializer():
            return
        if isinstance(ctx.parentCtx, JavaParser.ArrayInitializerContext):
            return

        self.modifyDataType(ancestor.typeType())

        for kind in ["localVariable", "field", "constant"]:
            ent = find_enteties_for_declarations(
                name, self.currentFile, ctx.start.line, ctx.stop.line, kind
            )
            if ent:
                self.handleRightSide(ctx.expression(), self.isEncodable(ent))
                return

    # ---------- handling assignments (expressions with 'op=' bop) ------------
    def handleAssignments(self, ctx: JavaParser.ExpressionContext):
        left = ctx.getChild(0)
        right = ctx.getChild(2)
        ent = self.visitExpression(left)
        if ent:
            if ent.kind not in [
                "method",
                "interfaceCommonBody",
                "formalParameter",
                "enumConstant",
            ]:
                self.handleRightSide(right, self.isEncodable(ent))
            else:
                self.handleRightSide(right, False)

    def handleRightSide(self, ctx: JavaParser.ExpressionContext, isEncoable=False):
        ## exceptions/filters
        #   - new keyword -> casting/creating object/initializing new collections
        if ctx.NEW():
            self.modifyDataType(ctx.creator())

        if ctx.getChildCount() == 1:
            ## case of a = b
            if ctx.primary() and ctx.primary().literal():
                # a = literal -> a = encodedLiteral : handled with literal
                return self.encodeLiteral(ctx.primary().literal())
            elif ctx.primary() and ctx.primary().identifier():
                # a = primary -> a = primary : skip
                # exception etters(primary -> formalParameter)
                ent = self.matchIdentifier(ctx.primary(), "primary")
                if ent and ent.kind == "formalParameter" and isEncoable:
                    self.rewriter.insertBeforeToken(
                        ctx.start, "MyCipher.getInstance().encode("
                    )
                    self.rewriter.insertAfterToken(ctx.stop, ")")
                    return
            elif ctx.methodCall() and isEncoable:
                # a = methodCall -> a = encode(methodCall)
                self.rewriter.insertBeforeToken(
                    ctx.start, "MyCipher.getInstance().encode("
                )
                self.rewriter.insertAfterToken(ctx.stop, ")")
            elif ctx.bop and ctx.bop.text == ".":
                # a = memberAccess -> a = encode(resolve.memberAccess)
                self.resolveMemberAccess(ctx)
                if isEncoable:
                    self.rewriter.insertBeforeToken(
                        ctx.start, "MyCipher.getInstance().encode("
                    )
                    self.rewriter.insertAfterToken(ctx.stop, ")")
            return

        # handle all literals from an Assingment/Initlization
        literalList = self.literalFinder(ctx)
        for item in literalList:
            self.encodeLiteral(item, True)

        # handle all primaries/refrences/methodCalls/memberAccess
        self.visitExpression(ctx, True)
        expList = self.expFinder(ctx)
        for item in expList:
            self.visitExpression(item, True)

        # re encrypt/encode
        if isEncoable:
            self.rewriter.insertBeforeToken(
                ctx.start,
                "MyCipher.getInstance().encode(",
            )
            self.rewriter.insertAfterToken(ctx.stop, ")")

    # ------------ Resolve and Rename member accesses ------------

    def enterExpression(self, ctx: JavaParser.ExpressionContext):
        ## special cases
        # 2- avoid modifying the case statments cause "case expressions must be constant expressions"
        t = ctx
        while t.parentCtx:
            if isinstance(t, JavaParser.SwitchLabeledRuleContext) or isinstance(
                t, JavaParser.SwitchLabelContext
            ):
                return
            t = t.parentCtx

        # handle assignments
        if ctx.bop and ctx.bop.text == "=":
            self.handleAssignments(ctx)
            return

        # try to not re encode the children of an Assignment expression
        t = ctx
        while t.parentCtx:
            if (
                isinstance(t, JavaParser.ExpressionContext)
                and t.bop
                and t.bop.text == "="
            ):
                return
            t = t.parentCtx

        # handle usuages/refrences
        self.visitExpression(ctx, True)

    def visitExpression(self, ctx, encode=False):
        if ctx.primary():
            if ctx.primary().identifier():
                return self.matchIdentifier(ctx.primary(), "primary", encode)
            elif ctx.primary().expression():
                return self.visitExpression(ctx.primary().expression(), encode)

        elif ctx.bop and ctx.bop.text == ".":
            return self.resolveMemberAccess(ctx, encode)

        elif ctx.methodCall():
            return

        elif ctx.LBRACK() and ctx.RBRACK():
            return self.matchIdentifier(ctx.expression()[0], "array", encode)

        # Continue visiting children
        for child in ctx.getChildren():
            if child and isinstance(child, JavaParser.ExpressionContext):
                return self.visitExpression(child, encode)
            elif child and isinstance(child, JavaParser.PrimaryContext):
                if child.identifier():
                    return self.matchIdentifier(child, "primary", encode)
                elif child.expression():
                    return self.visitExpression(ctx.primary().expression(), encode)
            elif child and isinstance(child, JavaParser.MethodCallContext):
                return

    def resolveMemberAccess(self, ctx, encode=False):
        t = ctx
        while (
            t.parentCtx
            and isinstance(t.parentCtx, JavaParser.ExpressionContext)
            and t.parentCtx.bop
            and t.parentCtx.bop.text == "."
        ):
            t = t.parentCtx
        members = self.memberFinder(t)
        ent, lastChild = self.extractList(members, True)
        if ent and self.isEncodable(ent) and encode:
            for token_type, transform_format in self.type_to_transform.items():
                if token_type == ent.varOrReturnType and ent.varOrReturnType:
                    temp = transform_format.format("|")
                    t.start.text = temp.split("|")[0] + t.start.text
                    lastChild.stop.text = lastChild.stop.text + temp.split("|")[1]
        return ent

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
                return None, left

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
                        return entity_from_last_iteration, left

            if varOrReturnType not in [classEnt.name for classEnt in self.allClasses]:
                return entity_from_last_iteration, left

        ent = None
        if isFirstIteration:
            ent = find_enteties_for_type_identifier(left_name, self.usedClasses)
            if ent is None:
                ent = self.visitExpression(left)
        else:
            ent = self.handleExpressionsForMember(left, right, varOrReturnType)

        # continue the process for other members if availabe
        if len(right) > 0:
            if ent and ent.varOrReturnType in (
                "String",
                "Integer",
                "int",
                "Float",
                "float",
                "Double",
                "double",
                "Short",
                "short",
                "Long",
                "long",
                "Character",
                "char",
                "Boolean",
                "boolean",
            ):
                return ent, left

            return self.extractList(right, False, ent)
        else:
            return ent, left

    def handleExpressionsForMember(self, left, right, varOrReturnType):
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
                    class_parent_ent = find_class_by_fileName(
                        class_parent, self.allClasses
                    )
                    for kind in kinds:
                        temp_ent = find_enteties_from_parent_class(
                            name.getText(), class_parent_ent, kind
                        )
                        if temp_ent:
                            return temp_ent
            else:
                return

    # ------------ Utility Functions ------------

    def matchIdentifier(self, ctx, type, encode=False):
        name = None
        result = None
        # Define entity types to search for
        entity_types = [
            "localVariable",
            "formalParameter",
            "field",
            "constant",
            "enumConstant",
        ]
        wanted_types = [
            "localVariable",
            "field",
            "constant",
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
                if encode and result.kind in wanted_types:
                    self.decodeAndParseIdentifier(ctx, result)
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

        if "extend" in ent.get_metadata() and ent.get_metadata()["extend"]:
            class_parent = ent.get_metadata()["extend"]
            class_parent_ent = find_class_by_fileName(class_parent, self.allClasses)
            for kind in kinds:
                temp_ent = find_enteties_from_parent_class(
                    name.getText(), class_parent_ent, kind
                )
                if temp_ent:
                    if encode and temp_ent.kind in wanted_types:
                        self.decodeAndParseIdentifier(name, temp_ent)
                    return temp_ent
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
                        if encode and temp_ent.kind in wanted_types:
                            self.decodeAndParseIdentifier(name, temp_ent)
                        return temp_ent

    def decodeAndParseIdentifier(self, ctx, result):
        # we alreay check that the left hand of the assingment is a primitive
        # and we know that the entity in hand here is either primary or an array access
        for token_type, transform_format in self.type_to_transform.items():
            if result.varOrReturnType and token_type == result.varOrReturnType:
                self.rewriter.replaceSingleToken(
                    ctx.start, transform_format.format(ctx.getText())
                )
                return
        for token_type, transform_format in self.type_to_transform.items():
            if result.varOrReturnType and token_type == result.varOrReturnType.replace(
                "[]", ""
            ):
                t = ctx
                # access array member:
                if ctx.parentCtx.getText()[-1] == "]":
                    t = ctx.parentCtx
                elif ctx.parentCtx.parentCtx.getText()[-1] == "]":
                    t = ctx.parentCtx.parentCtx
                else:
                    return
                temp = transform_format.format("|")
                t.start.text = temp.split("|")[0] + t.start.text
                t.stop.text = t.stop.text + temp.split("|")[1]
                return
        return

    def modifyDataType(self, dataType):
        primitive = (
            "String",
            "Integer",
            "int",
            "Float",
            "float",
            "Double",
            "double",
            "Short",
            "short",
            "Long",
            "long",
            "Character",
            "char",
            "Boolean",
            "boolean",
        )
        primitiveUpperCase = (
            "String",
            "Integer",
            "Float",
            "Double",
            "Short",
            "Long",
            "Character",
            "Boolean",
        )

        # int[x] char[xyz] ...
        pattern = r"(?:{})\[.*\]".format("|".join(map(re.escape, primitive)))

        templates = ["Map<", "HashMap<"]
        match_found = any(
            dataType.getText().startswith(template)
            and dataType.getText().endswith(primitive_type + ">")
            for template in templates
            for primitive_type in primitiveUpperCase
        )

        if (dataType.getText() not in primitive) and (
            dataType.getText() not in [f"{p}[]" for p in primitive]
            and not re.search(pattern, dataType.getText())
        ):
            return
            
        newDataType = dataType.getText()
        for elemnt in primitive:
            newDataType = newDataType.replace(elemnt, "String")
        for elemnt in primitiveUpperCase:
            newDataType = newDataType.replace(elemnt, "String")
        self.rewriter.replaceRangeTokens(dataType.start, dataType.stop, newDataType)

    def isEncodable(self, ent):
        # we check that the left hand side of an "Assignment /Initialization" is Encodable(has primitive data type)
        # we don't check for "ArrayList<>,HashMap<>,..." cause it's an "Assignment /Initialization" and these are collections

        if ent.varOrReturnType not in self.primitive:
            return False
        if ent.kind in [
            "method",
            "interfaceCommonBody",
            "formalParameter",
            "enumConstant",
        ]:
            return False
        return True

    def literalFinder(self, ctx):
        # recursive method to find all the literals in
        nodes = []
        if isinstance(ctx, TerminalNode):
            return nodes
        if isinstance(ctx, JavaParser.LiteralContext):
            nodes.append(ctx)

        for child in ctx.getChildren():
            nodes.extend(self.literalFinder(child))

        return nodes

    def expFinder(self, ctx):
        # recursive method to find all the literals in
        nodes = []
        if isinstance(ctx, TerminalNode):
            return nodes
        if isinstance(ctx, JavaParser.ExpressionContext):
            nodes.append(ctx)

        for child in ctx.getChildren():
            nodes.extend(self.expFinder(child))

        return nodes

    def encodeLiteral(self, ctx: JavaParser.LiteralContext, decodeAndParse=False):
        text = ctx.getText()
        varOrReturnType = None
        if ctx.STRING_LITERAL():
            varOrReturnType = "String"
            text = ctx.getText()[1:-1]
            if text.startswith("\\u"):
                return
        elif ctx.integerLiteral():
            varOrReturnType = "int"
        elif ctx.floatLiteral():
            varOrReturnType = "float"
        elif ctx.CHAR_LITERAL():
            varOrReturnType = "char"
        elif ctx.BOOL_LITERAL():
            varOrReturnType = "bool"

        # avoid null literals
        if ctx.NULL_LITERAL():
            return
        encryptedValue = self.aes_encrypt(text)
        if decodeAndParse:
            for token_type, transform_format in self.type_to_transform.items():
                if token_type == varOrReturnType and varOrReturnType:
                    ctx.start.text = transform_format.format(f'"{encryptedValue}"')
        else:
            ctx.start.text = f'"{encryptedValue}"'

    def aes_encrypt(self, plaintext):
        key_hex = self.key
        key = bytes.fromhex(key_hex)

        iv_hex = self.iv
        iv = bytes.fromhex(iv_hex)

        cipher = Cipher(algorithms.AES(key), modes.CFB(iv))

        # Encrypt the input string
        encryptor = cipher.encryptor()
        ciphertext = encryptor.update(plaintext.encode()) + encryptor.finalize()

        ciphertext_hex = ciphertext.hex()
        return ciphertext_hex
