/**
 * Section for removing duplicate files
 **/

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileRemover implements FileRemoverInterface{
    private Map<String, List<String>> hashToFilePaths;
    
    public FileRemover(Map<String, List<String>> hashToFilePaths) {
        this.hashToFilePaths = hashToFilePaths;
    }
    @Override
    public void removeFiles() {
        Iterator<List<String>> iterator = hashToFilePaths.values().iterator();
        while (iterator.hasNext()) {
            List<String> duplicateFiles = iterator.next();
            if (duplicateFiles.size() > 1) {
                // gather file data (name and size) for each file
                Map<String, Long> fileDataList = new HashMap<>();
                for (String filePath : duplicateFiles) {
                    File file = new File(filePath);
                    String fileName = file.getName();
                    long fileSize = file.length();
                    fileDataList.put(fileName, fileSize);
                }

                String fileToKeep = duplicateFiles.get(0);
                File keepFile = new File(fileToKeep);
                String keepFileName = keepFile.getName();
                long keepFileSize = keepFile.length();
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("  ==> Keeping file: " + keepFileName + " (Size: " + keepFileSize + " bytes)");

                // Delete files
                for (int i = 1; i < duplicateFiles.size(); i++) {
                    String fileToRemove = duplicateFiles.get(i);
                    File removeFile = new File(fileToRemove);
                    String removeFileName = removeFile.getName();
                    if (removeFile.delete()) {
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("  ==> Deleted file: " + removeFileName);
                    } else {
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("  ==> Failed to delete file: " + removeFileName);
                    }
                }
            } else {
                // check if file not found
                String fileToCheck = duplicateFiles.get(0);
                File checkFile = new File(fileToCheck);
                if (!checkFile.exists()) {
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("  ==> File not found: " + fileToCheck);
                }
                return;
            }
        }
    }
}