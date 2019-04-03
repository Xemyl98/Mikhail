package tasks.files;

import org.junit.Before;
import org.junit.Test;
import utility.files.FilesUtilities;

import static org.junit.Assert.assertEquals;

public class FileTaskTest {
    private static final String LOG = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\Log.txt";
    private static final String FILTERED_LOG = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\FilteredLog.txt";
    private static final String EMPTY_DOCUMENT = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\EmptyDocument.txt";
    private static final String ONE_IP_TEST = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\OneIpTest.txt";
    private static final String ONE_IP_TEST_RESULT = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\OneIpTestResult.txt";
    private static final String FILE_WITHOUT_PART_OF_IP = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\FileWithoutPartOfIp.txt";
    private static final String FILE_WITH_EXTRA_SPACE = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\FileWithExtraSpace.txt";
    private static final String FILE_WITH_INCORRECT_DAY_OF_WEEK = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\FileWithIncorrectDayOfWeek.txt";
    private static final String FILE_WITHOUT_PART_OF_TIME = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\FileWithoutPartOfTime.txt";
    private static final String FILE_WITH_INCORRECT_TIME = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\logfiles\\FileWithIncorrectTime.txt";
    private tasks.files.FileTask fileTask;

    @Before
    public void setUp() {
        fileTask = new tasks.files.FileTask();
    }

    @Test
    public void getFilteredLogFromFileWithCorrectDataValue() {
        fileTask.getFilteredLogFile(LOG, FILTERED_LOG);
        assertEquals(FilesUtilities.readFromFileIntoArrayList(FILTERED_LOG), FilesUtilities.readFromFileIntoArrayList(FILTERED_LOG));
    }

    @Test(expected = NullPointerException.class)
    public void getFilteredLogFromEmptyFile() {
        fileTask.getFilteredLogFile(EMPTY_DOCUMENT, EMPTY_DOCUMENT);
    }

    @Test
    public void getFilteredLogFromFileWithOneIpRepeatedManyTimes() {
        fileTask.getFilteredLogFile(ONE_IP_TEST, ONE_IP_TEST_RESULT);
        assertEquals(FilesUtilities.readFromFileIntoArrayList(ONE_IP_TEST_RESULT), FilesUtilities.readFromFileIntoArrayList(ONE_IP_TEST_RESULT));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredLogFromFileWithoutPartOfIp() {
        fileTask.getFilteredLogFile(FILE_WITHOUT_PART_OF_IP, FILE_WITHOUT_PART_OF_IP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredLogFromFileWithExtraSpace() {
        fileTask.getFilteredLogFile(FILE_WITH_EXTRA_SPACE, FILE_WITH_EXTRA_SPACE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredLogFromFileWithIncorrectDayOfWeek() {
        fileTask.getFilteredLogFile(FILE_WITH_INCORRECT_DAY_OF_WEEK, FILE_WITH_INCORRECT_DAY_OF_WEEK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredLogFromFileWithoutPartOfTime() {
        fileTask.getFilteredLogFile(FILE_WITHOUT_PART_OF_TIME, FILE_WITHOUT_PART_OF_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredLogFromFileWithIncorrectTime() {
        fileTask.getFilteredLogFile(FILE_WITH_INCORRECT_TIME, FILE_WITH_INCORRECT_TIME);
    }

}