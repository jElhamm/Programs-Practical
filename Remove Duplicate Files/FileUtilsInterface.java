
import java.io.IOException;
import java.util.List;

public interface FileUtilsInterface {
    List<String> getAllFiles(String inputRootPath) throws IOException;
}