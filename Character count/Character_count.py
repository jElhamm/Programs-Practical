#Coding with Python

def countCharacters(file_path):
    charCount = {}
    
    with open(file_path, 'r') as file:
        textّّFile = file.read()
        
        for char in textّّFile:
            if char in charCount:
                charCount[char] += 1
            else:
                charCount[char] = 1
    
    return charCount

def displayCharacterCount(character_count):
    print("\nCharaCter\tCount\t\tASCII")
    print("-----------------------------------------")
    for char, count in character_count.items():
        ASCII_Code = ord(char)
        charPrint = char.replace('\t', 'Tab').replace('\n', 'Newline').replace(' ', 'Space')
        print(f"{charPrint}\t\t{count}\t\t{ASCII_Code}")
        print("-----------------------------------------")

file_path = input("Enter the file path: ")
countCharacters = countCharacters(file_path)
displayCharacterCount(countCharacters)