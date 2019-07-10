package audio;

import constant.PathToFile;
import org.junit.Test;

import java.io.File;

public class OperationsTest {

    @Test
    public void operationTest() {
        Operations operations = new Operations();
        File file = new File(PathToFile.PATH_TO_OUTPUT_FILE);
        operations.extractFeatureFromFile(file);
    }
}