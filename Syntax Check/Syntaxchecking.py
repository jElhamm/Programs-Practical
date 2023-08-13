# The following program has the ability to check the syntax of codes written in different languages.
# It should be noted that the (Factory pattern design) was used for the implementation.


import ast
import os.path
from pygments import highlight
from pygments.formatters import TerminalFormatter
from pygments.lexers import PythonLexer, JavaLexer, CppLexer, CLexer, GoLexer, RubyLexer, CSharpLexer, HtmlLexer, CssLexer, PhpLexer

class LexerFactory:
    @staticmethod
    def create_lexer(fileExtension):
        if fileExtension == '.py':
            return PythonLexer()
        elif fileExtension == '.java':
            return JavaLexer()
        elif fileExtension == '.cpp':
            return CppLexer()
        elif fileExtension == '.c':
            return CLexer()
        elif fileExtension == '.go':
            return GoLexer()
        elif fileExtension == '.rb':
            return RubyLexer()
        elif fileExtension == '.cs':
            return CSharpLexer()
        elif fileExtension == '.html':
            return HtmlLexer()
        elif fileExtension in ['.css', '.scss']:
            return CssLexer()
        elif fileExtension == '.php':
            return PhpLexer()
        else:
            raise ValueError(f"Unsupported file type: {fileExtension}")

class SyntaxChecker:
    @staticmethod
    def isSupported_fileType(file_path):
        supported_extensions = ['.py', '.java', '.cpp', '.c', '.cs', '.css', '.scss', '.html', '.php','.go', '.rb']
        if not any(file_path.endswith(ext) for ext in supported_extensions):
            print(f"Unsupported file type: {file_path}")
            return False
        return True

    @staticmethod
    def check_syntax(file_path):
        if not os.path.exists(file_path):
            print(f"File does not exist: {file_path}")
            return
        if not SyntaxChecker.isSupported_fileType(file_path):
            print(f"Unsupported file type: {file_path}")
            return
        
        try:
            with open(file_path, 'r') as file:
                sourceCode = file.read()
                fileExtension = file_path[file_path.rfind('.'):].lower()
                lexer = LexerFactory.create_lexer(fileExtension)
                ast.parse(sourceCode)
                print("  ( Syntax is correct. )  ")
        except SyntaxError as error:
            print(f"\n  ! Syntax error in file ! : {file_path}")
            print(f"***********************************************************************")
            print("           List of errors:\n")
            print("  " + error.msg)
            print(f"  On line {error.lineno}: {highlight(sourceCode, lexer, TerminalFormatter())}")

def  banner():
    print("""

################################################################################
#                          ####   Welcome   ####                               #
#                                                                              #
#    #  The following program has the ability to check the syntax              #
#       of codes written in different languages.                               #
#    ##  You can use it for programs written in the following languages:       #
#                                                                              #
#                    *******************************                           #
#                    *  Python  *  Java   *   go   *                           #
#                    *  C       *  C++    *   C#   *                           #
#                    *  HTML    *  CSS    *   PHP  *                           #
#                    *  Ruby    *  go     *   :))  *                           #
#                    *******************************                           #
#                                                                              #
################################################################################
    """)

def main():
    banner()
    file_path = input("===> Please enter the path of the File: (path/to/your/File-Name) ")
    SyntaxChecker.check_syntax(file_path)

if __name__ == "__main__":
    main()