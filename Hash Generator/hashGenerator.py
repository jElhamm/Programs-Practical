# In this program, SHA_2 and MD5 algorithms are used to generate hash and encrypt each input string.

import hashlib

def SHA_256(string):
    stringBytes = string.encode('utf-8')               # Convert String to byte
    sha256_hash = hashlib.sha256()                     # Create a SHA-256 hash object
    sha256_hash.update(stringBytes)                    # Update hash with string bytes
    hashBytes  = sha256_hash.digest()                  # Get the hash value in bytes
    hashString = hashBytes.hex()                       # Convert hash bytes to hex string
    return hashString

def SHA_512(string):
    stringBytes = string.encode('utf-8')
    sha512_hash = hashlib.sha512()
    sha512_hash.update(stringBytes)
    hashBytes  = sha512_hash.digest()
    hashString = hashBytes.hex()
    return hashString

def SHA_224(string):
    stringBytes = string.encode('utf-8')
    sha224_hash = hashlib.sha224()
    sha224_hash.update(stringBytes)
    hashBytes  = sha224_hash.digest()
    hashString = hashBytes.hex()
    return hashString

def SHA_384(string):
    stringBytes = string.encode('utf-8')
    sha384_hash = hashlib.sha384()
    sha384_hash.update(stringBytes)
    hashBytes  = sha384_hash.digest()
    hashString = hashBytes.hex()
    return hashString

def MD5_hash(string):
    stringBytes = string.encode('utf-8')
    md5_hash = hashlib.md5()
    md5_hash.update(stringBytes)
    hashBytes  = md5_hash.digest()
    hashString = hashBytes.hex()
    return hashString

print("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------")
input = input("| Please enter the desired String: ")
sha256_hash = SHA_256(input)
sha512_hash = SHA_512(input)
sha224_hash = SHA_224(input)
sha384_hash = SHA_384(input)
md5_hash = MD5_hash(input)
print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------")
print("| Your String            |  " + input)
print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------")
print("| MD5 Hash               |  " + md5_hash + "                                                                                                     |")
print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------")
print("| SHA-224 Hash           |  " + sha224_hash + "                                                                             |")
print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------")
print("| SHA-256 Hash           |  " + sha256_hash + "                                                                     |")
print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------")
print("| SHA-384 Hash           |  " + sha384_hash + "                                     |")
print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------")
print("| SHA-512 Hash           |  " + sha512_hash+ "     |")
print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n")