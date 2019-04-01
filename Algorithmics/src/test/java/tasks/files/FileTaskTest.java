package tasks.files;

import org.junit.Before;
import org.junit.Test;
import utility.FileUtilities;

import static org.junit.Assert.assertEquals;

public class FileTaskTest {
    public static final String TEST_FILE = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\Test.txt";
    public static final String LOG = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\Log.txt";
    public static final String EMPTY_DOCUMENT = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\EmptyDocument.txt";
    public static final String ONE_IP_TEST = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\OneIpTest.txt";
    public static final String ONE_IP_TEST_RESULT = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\OneIpTestResult.txt";
    public static final String FILTERED_LOG = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\FilteredLog.txt";
    private tasks.files.FileTask fileTask;

    @Before
    public void setUp() {
        fileTask = new tasks.files.FileTask();
    }

    @Test
    public void readFromFileCorrectDataValue() {
        fileTask.getFilteredLogFile(LOG, FILTERED_LOG);
        assertEquals(FileUtilities.readFromFile(FILTERED_LOG), FileUtilities.readFromFile(FILTERED_LOG));
    }

    @Test(expected = NullPointerException.class)
    public void readFromFile() { fileTask.getFilteredLogFile(EMPTY_DOCUMENT, EMPTY_DOCUMENT);
    }

    @Test
    public void inputOneIpRepeatedManyTimes() {
        fileTask.getFilteredLogFile(ONE_IP_TEST, ONE_IP_TEST_RESULT);
        assertEquals(FileUtilities.readFromFile(ONE_IP_TEST_RESULT), FileUtilities.readFromFile(ONE_IP_TEST_RESULT));
    }
}