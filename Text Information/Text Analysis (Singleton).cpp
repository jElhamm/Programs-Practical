/**
 * The following program is implemented with the design pattern Singleton,
 *  which takes a file with the extension .txt and analyzes your text.
 **/

#include <iostream>
#include <fstream>
#include <map>

class FileManager {
private:
    static FileManager* instance;
    FileManager() {}

public:
    static FileManager* getInstance() {
        if (instance == nullptr) {
            instance = new FileManager();
        }
        return instance;
    }
    void analyzeFile(const std::string& fileName) {
        try {
            std::ifstream file(fileName);
            if (!file.is_open()) {
                throw std::runtime_error("File not found!");
            }
            
            std::string line;
            int lineCount = 0;
            int wordCount = 0;
            int characterCount = 0;
            std::map<char, int> characterCountMap;
            
            while (std::getline(file, line)) {
                lineCount++;
                // wordCount += std ::count_if(line.begin(), line.end(), [](char c) {return std::isspace(c); }) + 1;
                characterCount += line.size();
                std::istringstream iss(line);
                std::string word;
                while (iss >> word) {
                    wordCount++;
                }
                characterCount += line.size();
                for (char c : line) {
                    if (characterCountMap.find(c) != characterCountMap.end()) {
                        characterCountMap[c]++;
                    } else {
                        characterCountMap[c] = 1;
                    }
                }
            }

            std::cout << "---------------------------------------------------------\n";
            std::cout << "  # File Analysis Summary\n";
            std::cout << "  ## File Name: " << fileName << "\n";
            std::cout << "  ### Line Count: " << lineCount << "\n";
            std::cout << "  #### Word Count: " << wordCount << "\n";
            std::cout << "  ##### Character Count: " << characterCount << "\n";
            std::cout << "---------------------------------------------------------\n";
            std::cout << "  Character Frequencies:\n";
            for (const auto& entry : characterCountMap) {
                std::cout << "    ==> " << entry.first << ": " << entry.second << "\n";
            }
            std::cout << "---------------------------------------------------------\n";
            file.close();
        } catch (const std::exception& e) {
            std::cerr << "Error: " << e.what() << "\n";
        }
    }
};

FileManager* FileManager::instance = nullptr;
int main() {
    FileManager* fileManager = FileManager::getInstance();
    std::string filePath;
    std::cout << "\n---------------------------------------------------------\n";
    std::cout << "  Enter the file path: ";
    std::getline(std::cin, filePath);
    fileManager->analyzeFile(filePath);
    return 0;
}