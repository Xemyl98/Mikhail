package tasks.files;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.files.FilesUtilities;

import static org.junit.Assert.assertEquals;

public class FileTaskTest {
    private static final String STATISTICS = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\Statistics.txt";
    private static final String FILTERED_IP_STATISTICS = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\FilteredIpStatistics.txt";
    private static final String EMPTY_DOCUMENT = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\EmptyDocument.txt";
    private static final String ONE_IP_TEST = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\OneIpTest.txt";
    private static final String ONE_IP_TEST_RESULT = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\OneIpTestResult.txt";
    private static final String FILE_WITHOUT_PART_OF_IP = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\FileWithoutPartOfIp.txt";
    private static final String FILE_WITH_EXTRA_SPACE = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\FileWithExtraSpace.txt";
    private static final String FILE_WITH_INCORRECT_DAY_OF_WEEK = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\FileWithIncorrectDayOfWeek.txt";
    private static final String FILE_WITHOUT_PART_OF_TIME = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\FileWithoutPartOfTime.txt";
    private static final String FILE_WITH_INCORRECT_TIME = "C:\\Project\\yolkin\\algorithmics\\src\\main\\resources\\files\\FileWithIncorrectTime.txt";
    private FileTask fileTask;//TODO static?
    private static FilesUtilities filesUtilities;

    @BeforeClass
    public static void beforeClass() {
        filesUtilities = new FilesUtilities();
    }

    @Before
    public void setUp() {
        fileTask = new FileTask();
    }

    @Test
    public void getFilteredIpStatisticsFromFileWithCorrectDataValue() {
        fileTask.getFileWithFilteredIpStatistics(STATISTICS, FILTERED_IP_STATISTICS, filesUtilities);
        assertEquals(FilesUtilities.readDataFromFileToArrayList(FILTERED_IP_STATISTICS), FilesUtilities.readDataFromFileToArrayList(FILTERED_IP_STATISTICS));
    }

    @Test(expected = NullPointerException.class)
    public void getFilteredIpStatisticsFromEmptyFile() {
        fileTask.getFileWithFilteredIpStatistics(EMPTY_DOCUMENT, EMPTY_DOCUMENT, filesUtilities);
    }

    @Test
    public void getFilteredIpStatisticsFromFileWithOneIpRepeatedManyTimes() {
        fileTask.getFileWithFilteredIpStatistics(ONE_IP_TEST, ONE_IP_TEST_RESULT, filesUtilities);
        assertEquals(FilesUtilities.readDataFromFileToArrayList(ONE_IP_TEST_RESULT), FilesUtilities.readDataFromFileToArrayList(ONE_IP_TEST_RESULT));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredIpStatisticsFromFileWithoutPartOfIp() {
        fileTask.getFileWithFilteredIpStatistics(FILE_WITHOUT_PART_OF_IP, FILE_WITHOUT_PART_OF_IP, filesUtilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredIpStatisticsFromFileWithExtraSpace() {
        fileTask.getFileWithFilteredIpStatistics(FILE_WITH_EXTRA_SPACE, FILE_WITH_EXTRA_SPACE, filesUtilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredIpStatisticsFromFileWithIncorrectDayOfWeek() {
        fileTask.getFileWithFilteredIpStatistics(FILE_WITH_INCORRECT_DAY_OF_WEEK, FILE_WITH_INCORRECT_DAY_OF_WEEK, filesUtilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredIpStatisticsFromFileWithoutPartOfTime() {
        fileTask.getFileWithFilteredIpStatistics(FILE_WITHOUT_PART_OF_TIME, FILE_WITHOUT_PART_OF_TIME, filesUtilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilteredIpStatisticsFromFileWithIncorrectTime() {
        fileTask.getFileWithFilteredIpStatistics(FILE_WITH_INCORRECT_TIME, FILE_WITH_INCORRECT_TIME, filesUtilities);
    }

}