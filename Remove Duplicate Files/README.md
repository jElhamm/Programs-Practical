# File Duplicate Remover

   Duplicate File Remover provides an efficient way to identify and remove duplicate files from a specified directory.
   To remove duplicate files, it uses the hash calculation method for files. Here the (SHA-256) algorithm is implemented.
   This program follows the Singleton design pattern for the HashCalculator class and uses the Strategy design pattern 
   for the FileUtils class.


## Strategy Design Pattern

   The Strategy design pattern is used for the FileUtils class to provide a flexible and interchangeable method for retrieving all the files in a directory.
   The FileUtilsInterface defines the getAllFiles() method, which is implemented by the FileUtils class. 
   This allows for different implementations of the FileUtils class to be used without affecting the functionality of the program.

## Singleton Design Pattern

   The Singleton design pattern is used for the HashCalculator class to ensure that only one instance of the class is created. The getInstance() method returns the single instance of the class, allowing for centralized control over the creation and usage of the HashCalculator object.

## Usage

   1. Provide the root path of the directory from which duplicate files need to be removed.
   2. The program calculates the hash code of each file using the SHA-256 algorithm.
   3. Duplicate files are identified based on their hash codes.
   4. The program selects one file to keep and removes all other duplicate files.
   5. The result is displayed on the console, showing the file that is kept and the deleted files (if any).

## Execution

   To run the program, execute the Main class. 
   You may need to modify the inputRootPath variable to specify the root path of the directory containing the files.

## File Structure

   * 'HashCalculatorInterface': Defines the methods for calculating the hash code of a file and computing the hashes for
   multiple files.  
   * 'HashCalculator': Implements the HashCalculatorInterface and calculates the hash code of a file using the SHA-256 algorithm.
   * 'FileUtilsInterface': Defines the method for retrieving all the files in a directory.
   * 'FileUtils': Implements the FileUtilsInterface and retrieves all the files in a directory, recursively.
   * 'FileRemoverInterface': Defines the method for removing duplicate files.
   * 'FileRemover': Implements the FileRemoverInterface and removes duplicate files based on their hash codes.
   * 'Main.java': Main class to run the application and interact with the user.

## Prerequisites

   * Java JDK (version 8 or above)
   * Java IDE (e.g., IntelliJ IDEA, Visual Studio Code) or a text editor
   * Git