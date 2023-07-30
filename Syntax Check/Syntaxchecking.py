import ast
from pygments import highlight
from pygments.lexers import PythonLexer, JavaLexer, CppLexer, CLexer, CSharpLexer, GoLexer, RubyLexer
from pygments.formatters import TerminalFormatter

def isSupportedFileType(filePath):
    supportedExtensions = ['.py', '.java', '.cpp', '.c', '.go', '.rb']
    if not any(filePath.endswith(ext) for ext in supportedExtensions):
        print(f"Unsupported file type: {filePath}")
        return False
    return True

def checkSyntax(filePath):
    if not isSupportedFileType(filePath):
        print("  ! That file type is not supported !  ")
        return
    try:
        with open(filePath, 'r') as file:
            sourceCode = file.read()
            if filePath.endswith('.py'):
                lexer = PythonLexer()
            elif filePath.endswith('.java'):
                lexer = JavaLexer()
            elif filePath.endswith('.cpp'):
                lexer = CppLexer()
            elif filePath.endswith('.c'):
                lexer = CLexer()
            elif filePath.endswith('.go'):
                lexer = GoLexer()
            elif filePath.endswith('.rb'):  
                lexer = RubyLexer()

            ast.parse(sourceCode)
            print("  ( Syntax is correct. )  ")
    except SyntaxError as error:
        print(f"\n  ! Syntax error in file ! : {filePath}")
        print(f"***********************************************************************")
        print("           List of errors:\n")
        print("  " + error.msg)
        print(f"  On line {error.lineno}: {highlight(sourceCode, lexer, TerminalFormatter())}")

print("\n***********************************************************************")
filePath = input("  Please enter the path of the File (path/to/your/file.py, .java, .cpp, .c, .go, .rb): ")
checkSyntax(filePath)