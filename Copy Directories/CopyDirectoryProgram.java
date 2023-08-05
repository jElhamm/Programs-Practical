/**
 * We use this class to copy files from the destination folder to the source folder. 
 * ( Note that the sub-folders of the source folder will also be copied )
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.*;

public class CopyDirectoryProgram {
    private final String sourcePath;
    private final String destinationPath;

    CopyDirectoryProgram(String sourcePath, String destinationPath) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
    }
    public void copyDirectory() {
        try {
            copyDirectory(new File(sourcePath), new File(destinationPath));
            System.out.println("-------------------------------------------------------------------");
            System.out.println("  ( File Copy Completed Successfully. )  ");
            System.out.println("-------------------------------------------------------------------\n");
        } catch (IOException e) {
            System.out.println("  ! An ERROR occurred !  ");
            System.out.println("-------------------------------------------------------------------\n");
        }
    }

    private void copyDirectory(File inputSource, File inputDestination) throws IOException {
        if (inputSource.isDirectory()){
            // Check if the destination directory already exists
            if (!inputDestination.exists()) {
                // Create the destination directory and any necessary parent directories
                inputDestination.mkdirs();     
            }

            // Copy each file within the source directory recursively
            String[] fileList = inputSource.list();
            if (fileList != null) {
                for(String file : fileList){
                    File srcFile = new File(inputSource, file);
                    File destFile = new File(inputDestination, file);
                    copyDirectory(srcFile, destFile);
                }
            }
        }
        else {
            // Copy the individual file from source to destination
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                inputStream = new FileInputStream(inputSource);
                outputStream = new FileOutputStream(inputDestination);
                byte[] buffer = new byte[1024];
                int length;
                while(true){
                    length = inputStream.read(buffer);
                    if (length <= 0) {
                        break;
                    }
                    outputStream.write(buffer, 0, length);
                }
            } finally {
                // Close the input and output streams when done
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }
}