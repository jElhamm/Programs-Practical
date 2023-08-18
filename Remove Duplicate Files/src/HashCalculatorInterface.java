
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public interface HashCalculatorInterface {
    public String calculateHashCode(File file) throws NoSuchAlgorithmException, IOException;
    public void computeHashes(List<String> inputFilePaths, Map<String, List<String>> hashToFilePaths) throws NoSuchAlgorithmException, IOException;
}