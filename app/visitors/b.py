import random
import time

operators = ["+", "-", "*", "/", "<<", ">>"]
keyModifications = []


def modify_key(key):
    random_modification = random.choice(operators)
    modification_value = random.randint(1, 10)
    result = int(apply_operator(key, random_modification, modification_value))
    if result != int:
        keyModifications.append(
            {"key": key, "operand": random_modification, "value": modification_value}
        )
    return result


def generate_key():
    return random.randint(1, 255)


def secure_transform(numbers, key, operator):
    transformed_numbers = [apply_operator(num, operator, key) for num in numbers]

    while any(
        not (isinstance(element, int) or element.is_integer())
        or transformed_numbers == numbers
        or transformed_numbers == [0] * len(numbers)
        for element in transformed_numbers
    ):
        key = modify_key(key)
        operator = random.choice(operators)
        transformed_numbers = [apply_operator(num, operator, key) for num in numbers]

    return transformed_numbers, key, operator


def restore_transformed_numbers(transformed_numbers, key, operator):
    operator_map = {"*": "/", "+": "-", "-": "+", "/": "*", "<<": ">>", ">>": "<<"}
    inverted_operator = operator_map.get(operator, operator)
    return [apply_operator(num, inverted_operator, key) for num in transformed_numbers]


def apply_operator(num, operator, key):
    if operator == "*":
        return num * key
    elif operator == "+":
        return num + key
    elif operator == "-":
        return num - key
    elif operator == "/" and key != 0:
        return num / key
    elif operator == ">>" and 0 < key < 32:
        return num >> key
    elif operator == "<<" and 0 < key < 32:
        return num << key
    return num


def convert_text(text: str):
    original_numbers = [ord(character) for character in text]
    # print(f"original text : {text}")
    
    initalKey = generate_key()
    key = initalKey
    for _ in range(3):
        key = modify_key(key)

    transformed_numbers, modified_key, operator = secure_transform(
        original_numbers, key, random.choice(operators)
    )

    # print(f"\ntransformed numbers : {transformed_numbers}\n")
    # print(f"Inital Key : {initalKey}")
    # print(f"Key Modifications : {keyModifications}")

    while all(element == 0 for element in transformed_numbers):
        transformed_numbers, modified_key, operator = secure_transform(
            original_numbers, modified_key, random.choice(operators)
        )

    restored_numbers = restore_transformed_numbers(
        transformed_numbers, modified_key, operator
    )
    restored_text = "".join([chr(int(character)) for character in restored_numbers])
    # print(f"restored text : {restored_text}")
    operator_map = {"*": "/", "+": "-", "-": "+", "/": "*", "<<": ">>", ">>": "<<"}
    return (
        [hex(x) for x in transformed_numbers],
        hex(initalKey),
        keyModifications,
        operator_map.get(operator, operator),
        modified_key,
    )


if __name__ == "__main__":
    main()
