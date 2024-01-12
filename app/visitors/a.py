import random


def secure_transform(numbers):
    # Choose a random key
    key = random.randint(1, 255)
    print(f"Initial Key: {key}")

    # Randomly modify the key using arithmetic operations
    operators = ["+", "-", "*", "/"]
    num_modifications = random.randint(1, 3)  # Choose between 1 to 3 modifications
    for _ in range(num_modifications):
        random_modification = random.choice(operators)
        modification_value = random.randint(1, 255)
        key = apply_key_modification(key, random_modification, modification_value)
        print(f"Modified Key ({random_modification} {modification_value}): {key}")

    # Choose a random operator
    operator = random.choice(operators)
    print(f"Operator: {operator}")

    # Transform each number using the modified key and operator
    transformed_numbers = [apply_operator(num, operator, key) for num in numbers]

    return transformed_numbers, key, operator


def restore_transformed_numbers(transformed_numbers, key, operator):
    # Restore the original numbers using the modified key and operator
    restored_numbers = [
        apply_operator(num, inverse_operator(operator), key)
        for num in transformed_numbers
    ]

    return restored_numbers


def apply_key_modification(key, modification, modification_value):
    if modification == "+":
        key += modification_value
    elif modification == "-":
        key -= modification_value
    elif modification == "*":
        key *= modification_value
    elif modification == "/":
        key /= modification_value

    return key


def apply_operator(num, operator, key):
    if operator == "*":
        return num * key
    elif operator == "+":
        return num + key
    elif operator == "-":
        return num - key
    elif operator == "/":
        return num / key


def inverse_operator(operator):
    if operator == "*":
        return "/"
    elif operator == "+":
        return "-"
    elif operator == "-":
        return "+"
    elif operator == "/":
        return "*"


# Example usage
original_numbers = [97, 108, 105]

# Secure transformation
transformed_numbers, modified_key, operator = secure_transform(original_numbers)
print(f"Original Numbers: {original_numbers}")
print(f"Modified Numbers: {transformed_numbers}")
print(f"Modified Key: {modified_key}")

# Restore the original numbers
restored_numbers = restore_transformed_numbers(
    transformed_numbers, modified_key, operator
)
print(f"Restored Numbers: {restored_numbers}")

    def enterLiteral(self, ctx: JavaParser.LiteralContext):
        if not ctx.STRING_LITERAL():
            return
        literal = ctx.getText()[1:-1]
        arr, initalKey, modifications, operator, finalKey = convert_text(literal)

        t = ctx.parentCtx
        while t.parentCtx:
            if isinstance(t, JavaParser.VariableInitializerContext):
                varName = t.parentCtx.variableDeclaratorId().identifier().getText()

                modified_text = (
                    f'"";\n\n'
                    f"int arr[] = {{ {','.join(arr)} }};\n\n"
                    f"for (int i = 0; i < {len(arr)}; i++)\n"
                    "{\n"
                    f"      int key= {initalKey}       ;        "
                    + "".join(
                        [
                            f" key  {modification['operand']}=   {hex(modification['value'])};"
                            for modification in modifications
                        ]
                    )
                    + "      int item = arr[i];\n"
                    f"       item {operator}= key;\n"
                    f"        {varName} += (char)(item);\n"
                    "}"
                )

                self.rewriter.replaceRangeTokens(t.start, t.stop, modified_text)

            t = t.parentCtx