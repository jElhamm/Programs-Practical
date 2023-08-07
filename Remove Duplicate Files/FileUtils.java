/**
 * In this class, all the files in the address are taken. 
 **/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils implements FileUtilsInterface{
    @Override
    public List<String> getAllFiles(String inputRootPath) throws IOException {
        List<String> filePaths = new ArrayList<>();
        getAllFilesRecursive(inputRootPath, filePaths);
        return filePaths;
    }
    private void getAllFilesRecursive(String inputPath, List<String> inputFilePaths) throws IOException {
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
