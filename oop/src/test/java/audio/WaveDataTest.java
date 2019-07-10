package audio;

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
    private static List<Byte> bytesFromTestFile;

    @BeforeClass
    public static void setUp() {
        wavedata = new WaveData();
        testWavFile = new File(PathToFile.EXAMPLE_OUTPUT_FILE);
        testByteArrayFile = new File(PathToFile.BYTE_ARRAY_FROM_EXAMPLE_FILE);
        bytesFromTestFile = WaveDataUtil.readByteListFromFile(testByteArrayFile);
    }

    @Test
    public void convertingFileToByteArray() {
        assertEquals(WaveDataUtil.convertByteArrayToByteObject(wavedata.extractByteArrayFromFile(testWavFile)), bytesFromTestFile);
    }

    @Test
    public void getAudioBytes() {
        WaveDataUtil.
    }
}
