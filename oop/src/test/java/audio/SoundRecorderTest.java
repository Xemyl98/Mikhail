package audio;

import constant.AudioConstant;
import constant.PathToFile;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class SoundRecorderTest {

    private static SoundRecorder recorder;
    private static File recordedFile;

    @BeforeClass
    public static void setUp() {
        recordedFile = new File(PathToFile.PATH_TO_OUTPUT_FILE);
        recorder = new SoundRecorder();
    }

    @Test
    public void recordedFileIsExist() {
        recorder.recorderAudioFromMicrophone(AudioConstant.RECORDER_TIME);
        assertTrue(recordedFile.exists());
    }

}