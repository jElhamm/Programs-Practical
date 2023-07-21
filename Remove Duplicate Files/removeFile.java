package com.remove_duplicate_files;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class removeFile 
{
    private static Map<String, List<String>> hashToFilePaths = new HashMap<>();
    public static void main( String[] args )
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.print("Please enter the root path of the computer: ");
        String rootPath = cin.nextLine();
        try {
            List<String> filePaths = getAllFiles(rootPath);
            computeHashes(filePaths);
            removeFiles();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Deleted duplicate files.");
            System.out.println("-----------------------------------------------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
    }

    public static void computeHashes(List<String> inputFilePaths) throws NoSuchAlgorithmException, IOException {
        HashCalculator new_HashCalculator = new HashCalculator();
        for (String filePath : inputFilePaths) {
            File newFile   = new File(filePath);
            String newHash = new_HashCalculator.calculateHashCode(newFile);

            List<String> sameHash = new ArrayList<>();
            if (hashToFilePaths.containsKey(newHash)) {
                sameHash = hashToFilePaths.get(newHash);
            }
            sameHash.add(filePath);
            hashToFilePaths.put(newHash, sameHash);
        }
    }

    public static void removeFiles() {
        Iterator<List<String>> newIterator = hashToFilePaths.values().iterator();
        while (newIterator.hasNext()) {
            List<String> ListOf_duplicateFiles = newIterator.next();
            if (ListOf_duplicateFiles.size() > 1) {
                // gather file data (name and size) for each file
                Map<String, Long> fileDataList = new HashMap<>();
                for (String filePath : ListOf_duplicateFiles) {
                    File   newFile  = new File(filePath);
                    String fileName = newFile.getName();
                    long   fileSize = newFile.length();
                    fileDataList.put(fileName, fileSize);
                }
 
                String fileToKeep   = ListOf_duplicateFiles.get(0);
                File   keepFile     = new File(fileToKeep);
                String keepFileName = keepFile.getName();
                long   keepFileSize = keepFile.length();
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("Keeping file: " + keepFileName + " (Size: " + keepFileSize + " bytes)");
        
                // Delete files
                for (int i = 1; i < ListOf_duplicateFiles.size(); i++) {
                    String fileToRemove   = ListOf_duplicateFiles.get(i);
                    File   removeFile     = new File(fileToRemove);
                    String removeFileName = removeFile.getName();
                    if (removeFile.delete()) {
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("Deleted file: " + removeFileName);
                    } else {
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("Failed to delete file: " + removeFileName);
                    }
                }
            } else{
                return;
            }
        }
    }

    public static List<String> getAllFiles(String inputRootPath) throws IOException {
        List<String> filePaths = new ArrayList<>();
        getAllFilesRecursive(inputRootPath, filePaths);
        return filePaths;
    }
    public static void getAllFilesRecursive(String inputPath, List<String> inputFilePaths) throws IOException {
        File root = new File(inputPath);
        File[] listFiles = root.listFiles();
    
        if (listFiles == null) {
            return;
        } else{
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    getAllFilesRecursive(file.getAbsolutePath(), inputFilePaths);
                } else {
                    inputFilePaths.add(file.getAbsolutePath());
                }
            }
        }
        
    }
}