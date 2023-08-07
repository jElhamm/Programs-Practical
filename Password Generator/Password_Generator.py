# You can use this program to generate random passwords.

import random

def banner():
    print("""
    ---------------------------------------------------------------
    |  Choose the types of characters for the password:           |
    |  1- Lowercase letters                                       |
    |  2- Uppercase letters                                       |
    |  3- Numeric digits                                          |
    |  4- Special characters                                      |
    ---------------------------------------------------------------
    """)

def main():
    print("\n---------------------------------------------------------------")
    passwordLength = int(input("   Hello, please enter the length of the password: "))

    numeric = "0123456789"
    uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    lowercase = "abcdefghijklmnopqrstuvwxyz"
    special = "()<>[]{}/!?*@#&$^%_-+="
    password = ""
    select = ""

    banner()
    choices = input("    Enter your choices: ")

    if "1" in choices:
        select += lowercase
    if "2" in choices:
        select += uppercase
    if "3" in choices:
        select += numeric
    if "4" in choices:
        select += special

    for i in range(passwordLength):
        random_index = random.randint(0, len(select) - 1)
        password += select[random_index]

    print("---------------------------------------------------------------")
    print("   *** Generated Password: " + password)
    print("---------------------------------------------------------------")

if __name__ == "__main__":
    main()