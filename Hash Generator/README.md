# Hash Generator

   This program allows you to generate hash values for input strings using *SHA-2* and MD5 algorithms. 
   The program utilizes the hashlib library in Python to perform the hashing operations. 

## Features

   * Generates hash values for input strings using various algorithms.
   * Supports *SHA-224*, *SHA-256*, *SHA-384*, *SHA-512*, and *MD5*.
   * Displays the input string and corresponding hash values in the console.

## Usage

   1. Run the program.
   2. Enter the desired string for which you want to calculate hash values.
   3. The program will display the input string and the corresponding hash values for *MD5*, *SHA-224*, *SHA-256*, *SHA-384*, and *SHA-512* algorithms.

                                This program requires the hashlib library. You can install it using (pip):

                                                    -------------------------------
                                                    |     pip install hashlib     |
                                                    -------------------------------

## Example
   
     -----------------------------------------------------------------------------------------------------------------------------------------------------------------
     | Please enter the desired String: Hello World
     -----------------------------------------------------------------------------------------------------------------------------------------------------------------
     | Your String            |  Hello World
     -----------------------------------------------------------------------------------------------------------------------------------------------------------------
     | MD5 Hash               |  ed076287532e86365e841e92bfc50d8c                                                                                                    |
     -----------------------------------------------------------------------------------------------------------------------------------------------------------------
     | SHA-224 Hash           |  2ef7bde608ce5404e97d5f042f95f89f1c232871                                                                                            |
     -----------------------------------------------------------------------------------------------------------------------------------------------------------------
     | SHA-256 Hash           |  2ef7bde608ce5404e97d5f042f95f89f1c232871f2def15c95e15a87a12bd4aa                                                                    |
     -----------------------------------------------------------------------------------------------------------------------------------------------------------------
     | SHA-384 Hash           |  9d4e1e23bd5b727046a9e3b4b7db57ed9d6b6ec121448c0d6821dda2f8d14559f7f6ecd43fd81b8d9441be9bc9a3a467                                    |
     -----------------------------------------------------------------------------------------------------------------------------------------------------------------
     | SHA-512 Hash           |  98c615784ccb5fe5936fbc0c09c9d4c4c4955f756a962825d6e0891b9ef7b961db050602849055e2d9cd335915d54cb193bfe9a0893bf7a625fca8e97f9c16b9    |
     -----------------------------------------------------------------------------------------------------------------------------------------------------------------

## References

   * [MD5](https://en.wikipedia.org/wiki/MD5)
   * [SHA-2](https://en.wikipedia.org/wiki/SHA-2)
   * [hashlib](https://pypi.org/project/hashlib/)
   * [Secure Hash Standard (SHS)](https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.180-4.pdf)
   * [hashlib, Secure hashes and message digests](https://docs.python.org/3/library/hashlib.html#:~:text=To%20calculate%20hash%20of%20some,for%20hex%2Dencoded%20string)
   * [How to Use Hashing Algorithms in Python using hashlib](https://thepythoncode.com/article/hashing-functions-in-python-using-hashlib)