# Code Syntax Checker

   Welcome,This program allows users to check the syntax of code written in different programming languages. The implementation uses the Factory pattern design.

## Design Pattern Used: (Factory Pattern)

   The Factory pattern is used in this program to create objects of different lexer classes based on the file
   extension. 
   It provides an interface for creating objects, but allows subclasses to decide which class to  
   instantiate.
   In this case, the LexerFactory class creates lexer objects based on the file extension 
   provided.

## Supported Languages

   The program currently supports the following languages:

   * [Python](https://www.python.org/)
   * [Java](https://www.java.com/)
   * [C++](https://cplusplus.com/)
   * [C](https://en.wikipedia.org/wiki/C_(programming_language))
   * [C#](https://learn.microsoft.com/en-us/dotnet/csharp/tour-of-csharp/)
   * [CSS](https://en.wikipedia.org/wiki/CSS#:~:text=Cascading%20Style%20Sheets%20(CSS)%20is,Web%2C%20alongside%20HTML%20and%20JavaScript.)
   * [HTML](https://en.wikipedia.org/wiki/HTML)
   * [PHP](https://en.wikipedia.org/wiki/PHP#:~:text=PHP%20is%20a%20general%2Dpurpose,produced%20by%20the%20PHP%20Group.)
   * [Ruby](https://www.ruby-lang.org/en/)
   * [Go](https://go.dev/)

## How to Use the Program

   1. Run the program.
   2. Enter the path of the file you want to check the syntax for. The file path should include the extension (e.g., path/to/your/file.py, .java, .cpp, .c, .cs, .css, .scss, .html, .php, .go, .rb). 
   3. The program will check if the file type is supported. If not, an error message will be displayed.
   4. If the file type is supported, the program will attempt to read the file and parse the code using the 
    appropriate lexer for the file extension.
   5. If the syntax is correct, a success message will be displayed.
   6. If there is a syntax error, an error message will be displayed along with the list of errors and the     
    specific line of code where the error occurred.

## Dependencies

   * ast (for parsing the code)
   * pygments (for code highlighting)
   * pygments.formatters.TerminalFormatter (for formatting highlighted code)
   * pygments.lexers (for lexers of different programming languages)

## Note

   This program only checks the syntax of the code and does not perform any kind of semantic analysis or 
   execute the code.

Enjoy checking your code's syntax !