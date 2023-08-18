/** 
 * In this class, the hash of each file is calculated using the SHA_256 algorithm.
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HashCalculator implements HashCalculatorInterface {
    private static HashCalculator instance;
    private HashCalculator() {}

    public static HashCalculator getInstance() {
        if (instance == null) {
            instance = new HashCalculator();
        }
        return instance;
    }
    @Override
    public String calculateHashCode(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try (InputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesRead;

            while ((bytesRead = is.read(buffer)) != -1) {
                md.update(buffer, 0, bytesRead);
            }
        }
        byte[] hashBytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    @Override
    public void computeHashes(List<String> inputFilePaths, Map<String, List<String>> hashToFilePaths) throws NoSuchAlgorithmException, IOException {
        for (String filePath : inputFilePaths) {
            File newFile = new File(filePath);
            String newHash = calculateHashCode(newFile);

            List<String> sameHash = new ArrayList<>();
            if (hashToFilePaths.containsKey(newHash)) {
                sameHash = hashToFilePaths.get(newHash);
            }
            sameHash.add(filePath);
            hashToFilePaths.put(newHash, sameHash);
        }
    }
}
