package audio;

import constant.AudioConstant;
import constant.PathToFile;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.audio.WaveDataUtil;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WaveDataTest {

    private static WaveData wavedata;
    private static File testWavFile;
    private static File testByteArrayFile;
    private static File testAudioInputStreamByteArrayFile;
    private static File testFloatArrayFile;
    private static List<Byte> bytesFromTestFile;
    private static List<Byte> audioInputStreamByteArrayFromTestFile;
    private static List<Float> floatArrayFromTestFile;

    private static void fillFileVariables() {
        testWavFile = new File(PathToFile.EXAMPLE_INPUT_FILE_WITHOUT_SILENCE_IN_START);
        testByteArrayFile = new File(PathToFile.BYTE_ARRAY_FROM_EXAMPLE_FILE_WITHOUT_SILENCE_IN_START);
        testAudioInputStreamByteArrayFile = new File(PathToFile.AUDIO_INPUT_STREAM_BYTE_ARRAY_FROM_EXAMPLE_FILE_WITHOUT_SILENCE_IN_START);
        testFloatArrayFile = new File(PathToFile.FLOAT_ARRAY_FROM_EXAMPLE_FILE_WITHOUT_SILENCE_IN_START);
    }

    private static void fillListVariables() {
        bytesFromTestFile = WaveDataUtil.readByteListFromFile(testByteArrayFile);
        audioInputStreamByteArrayFromTestFile = WaveDataUtil.readByteListFromFile(testAudioInputStreamByteArrayFile);
        floatArrayFromTestFile = WaveDataUtil.readFloatListFromFile(testFloatArrayFile);
    }

    @BeforeClass
    public static void setUp() {
        wavedata = new WaveData();
        fillFileVariables();
        fillListVariables();
        wavedata.extractFloatArrayFromFile(testWavFile);
/*        WaveDataUtil.writeArrayToFile(testByteArrayFile, WaveDataUtil.getArrFile());
        WaveDataUtil.writeArrayToFile(testAudioInputStreamByteArrayFile, WaveDataUtil.getAudioBytes());
        WaveDataUtil.writeArrayToFile(testFloatArrayFile, WaveDataUtil.getAudioData());*/
    }

    @Test
    public void convertingFileToByteArrayTest() {
        assertEquals(WaveDataUtil.convertArrayToObject(WaveDataUtil.getArrFile()), bytesFromTestFile);
    }

    @Test
    public void soundFileLengthTest() {
        assertEquals(WaveDataUtil.getDurationSec(), AudioConstant.LENGTH_OF_TEST_WAV_FILE, 1);
    }

    @Test
    public void convertByteArrayToAudioInputStreamByteArrayTest() {
        assertEquals(WaveDataUtil.convertArrayToObject(WaveDataUtil.getAudioBytes()), audioInputStreamByteArrayFromTestFile);
    }

    @Test
    public void convertAudioInputStreamByteArrayToFloatArrayTest() {
        assertEquals(WaveDataUtil.convertArrayToObject(WaveDataUtil.getAudioData()), floatArrayFromTestFile);
    }
}
