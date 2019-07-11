package audio;

import constant.PathToFile;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.audio.WaveDataUtil;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OperationsTest {

    private static Operations operations;
    private static float[] originalSignal;
    private static float[] silenceRemovedSignal;
    private static List<Float> silenceRemovedSignalFromTestFile;
    private static File testWavFile;

    @BeforeClass
    public static void setUp() {
        operations = new Operations();
        testWavFile = new File(PathToFile.EXAMPLE_INPUT_FILE);
        originalSignal = operations.extractFloatArrayFromFile(testWavFile);
        silenceRemovedSignal = operations.getSilenceRemovedSignal(originalSignal);
        silenceRemovedSignalFromTestFile = WaveDataUtil.readFloatListFromFile(new File(PathToFile.SILENCE_REMOVED_SIGNAL_EXAMPLE_FILE));
    }

    @Test
    public void silenceRemovedSignalTest() {
        assertEquals(silenceRemovedSignalFromTestFile, WaveDataUtil.convertArrayToObject(silenceRemovedSignal));
    }

}