/**
 * You can use this program to delete duplicate files in your system.
 * In this program, hash calculation is used to find duplicate files. 
 * Implemented with Singleton Design Pattern
 **/

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    private static Map<String, List<String>> hashToFilePaths = new HashMap<>();
    private static HashCalculatorInterface hashCalculator = HashCalculator.getInstance();
    public static void main( String[] args )
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.print("  # Please enter the root path of the computer: ");
        String rootPath = cin.nextLine();
        cin.close();
        try {
            FileUtilsInterface fileUtils = new FileUtils();
            List<String> filePaths = fileUtils.getAllFiles(rootPath);

            hashCalculator.computeHashes(filePaths, hashToFilePaths);

            FileRemoverInterface fileRemover = new FileRemover(hashToFilePaths);
            fileRemover.removeFiles();

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("  ==> Deleted duplicate files.");
            System.out.println("-----------------------------------------------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}