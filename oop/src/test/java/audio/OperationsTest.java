package audio;

import audio.feature.FeatureVector;
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
    private static float[][] framedSignal;
    private static List<Float> silenceRemovedSignalFromTestFile;
    private static File testWavFile;

    @BeforeClass
    public static void setUp() {
        operations = new Operations();
        testWavFile = new File(PathToFile.EXAMPLE_INPUT_FILE_WITHOUT_SILENCE_IN_START);
        originalSignal = operations.extractFloatArrayFromFile(testWavFile);
        silenceRemovedSignal = operations.getSilenceRemovedSignal(originalSignal);
        // WaveDataUtil.writeArrayToFile(new File(PathToFile.SILENCE_REMOVED_SIGNAL_FROM_EXAMPLE_FILE_WITHOUT_SILENCE_IN_START), silenceRemovedSignal);
        silenceRemovedSignalFromTestFile = WaveDataUtil.readFloatListFromFile(new File(PathToFile.SILENCE_REMOVED_SIGNAL_FROM_EXAMPLE_FILE_WITHOUT_SILENCE_IN_START));
        framedSignal = operations.getFramedSignal(originalSignal, silenceRemovedSignal);
        // WaveDataUtil.writeArrayToFile(new File(PathToFile.FRAMED_SIGNAL_FROM_EXAMPLE_FILE),framedSignal);
        FeatureVector featureVector = operations.extractFeatureFromExtractedAmplitureByteArray(originalSignal);
        WaveDataUtil.writeArrayToFile(new File(PathToFile.FEATURE_VECTOR_FROM_EXAMPLE_FILE_WITHOUT_SILENCE_IN_START), featureVector.getFeatureVector());
        int a = 0;
    }

    @Test
    public void silenceRemovedSignalTest() {
        assertEquals(silenceRemovedSignalFromTestFile, WaveDataUtil.convertArrayToObject(silenceRemovedSignal));
    }

}