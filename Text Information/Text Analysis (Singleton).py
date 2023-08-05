# The following program is implemented with the design pattern Singleton,
#  which takes a file with the extension .txt and analyzes your text.

class FileManager:
    __instance = None

    @staticmethod
    def getInstance():
        if FileManager.__instance is None:
            FileManager()
        return FileManager.__instance
    def init(self):
        if FileManager.__instance is not None:
            raise Exception("  ( ! This class is a singleton ! )  ")
        else:
            FileManager.__instance = self
    def analyzezFile(self, fileName):
        try:
            with open(fileName, 'r') as file:
                lines = file.readlines()
                lineCount = len(lines)
                wordCount = 0
                characterCount = 0
                characterCountMap = {}                      # dictionary to store character frequencies

                for  line in lines:
                    words = line.split()
                    wordCount += len(words)
                    characterCount += len(line)

                    for  char in line:
                        if char in characterCountMap:
                            characterCountMap[char] += 1
                        else:
                            characterCountMap[char] = 1
                
            print("---------------------------------------------------------")
            print("  # File Analysis Summary")
            print("  ## File Name:", fileName)
            print("  ### Line Count:", lineCount)
            print("  #### Word Count:", wordCount)
            print("  ##### Character Count:", characterCount)
            print("---------------------------------------------------------")
            print("  Character Frequencies:")
            for char, freq in sorted(characterCountMap.items()):
                print("    ==> {}: {}".format(char, freq))
            print("---------------------------------------------------------\n")

        except FileNotFoundError:
            print("  ( ! File not found ! )  ")

if __name__ == '__main__':
    file_Manager = FileManager.getInstance()
    file_Manager = FileManager()
    filePath = input("\n---------------------------------------------------------\n  Enter the file path: ")
    file_Manager.analyzezFile(filePath)