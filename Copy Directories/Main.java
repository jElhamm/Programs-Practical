/**
 * You can use this program to copy any type of file (folder, text, video, image, etc.) from one folder on your computer to another folder. 
 **/

import java.util.Scanner;

public class Main 
{
    public static void main( String[] args )
    {
        Scanner cin = new Scanner(System.in);
        try {
            System.out.println("\n-------------------------------------------------------------------");
            System.out.print("  # Please, Enter source directory path:  ");
            String sourcePath = cin.nextLine();
            System.out.print("  ## And, Enter destination directory path:  ");
            String destinationPath = cin.nextLine();

            CopyDirectoryProgram program = new CopyDirectoryProgram(sourcePath, destinationPath);
            program.copyDirectory();
        } finally {
            cin.close();
        }
    }
}