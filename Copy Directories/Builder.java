/**
 * We use this class because of the implementation of the program with Builder design pattern. 
 **/

public class Builder {
    private final String sourcePath;
    private final String destinationPath;

    public Builder(String sourcePath, String destinationPath) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
    }
    public CopyDirectoryProgram build() {
        return new CopyDirectoryProgram(sourcePath, destinationPath);
    }
}