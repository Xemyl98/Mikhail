package files;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class FileTaskTest {
    public static final String TESTFILE = "C:\\Project\\MikhailYolkin\\Algorithmics\\src\\main\\resources\\logfiles\\Test.txt";
    public static final String ACTUALFILE = "C:\\Project\\MikhailYolkin\\Algorithmics\\src\\main\\resources\\logfiles\\filteredLog.txt";
    public static final String LOG = "C:\\Project\\MikhailYolkin\\Algorithmics\\src\\main\\resources\\logfiles\\Log.txt";
    public static final String EMPTYDOCUMENT = "C:\\Project\\MikhailYolkin\\Algorithmics\\src\\main\\resources\\logfiles\\EmptyDocument.txt";
    public static final String ONEIPTEST = "C:\\Project\\MikhailYolkin\\Algorithmics\\src\\main\\resources\\logfiles\\OneIpTest.txt";
    public static final String ONEIPTESTRESULT = "C:\\Project\\MikhailYolkin\\Algorithmics\\src\\main\\resources\\logfiles\\OneIpTest.txt";
    private Path testFile = Paths.get(TESTFILE);
    private Path actualFile = Paths.get(ACTUALFILE);
    private Path oneIpFileTest = Paths.get(ONEIPTEST);
    private Path oneIpFileResultTest = Paths.get(ONEIPTESTRESULT);
    private FileTask fileTask;
    Logger logger = Logger.getLogger(FileTaskTest.class.getName());

    @Before
    public void setUp() {
        fileTask = new FileTask();
    }

    @Test
    public void defaultDataTest() {
        fileTask.fileRead(LOG);
        fileTask.removeIpFromDayAndTime();
        fileTask.filteredLog();
        try {
            assertEquals(Files.readAllLines(testFile), Files.readAllLines(actualFile));
        } catch (Exception ex) {
            logger.info("Test failed " + ex);
        }
    }

    @Test(expected = NullPointerException.class)
    public void emptyDocument() {
        fileTask.fileRead(EMPTYDOCUMENT);
        fileTask.removeIpFromDayAndTime();
        fileTask.filteredLog();
    }

    @Test
    public void oneWordDataTest() {
        fileTask.fileRead(ONEIPTEST);
        fileTask.removeIpFromDayAndTime();
        fileTask.filteredLog();
        try {
            assertEquals(Files.readAllLines(oneIpFileTest), Files.readAllLines(oneIpFileResultTest));
        } catch (Exception ex) {
            logger.info("Test failed " + ex);
        }
    }
}