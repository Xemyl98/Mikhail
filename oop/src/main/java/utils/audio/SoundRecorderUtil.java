package utils.audio;

import constant.Constant;

import javax.sound.sampled.TargetDataLine;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class SoundRecorderUtil {
    private static Logger log = Logger.getLogger(SoundRecorderUtil.class.getName());

    public static void startRecording(TargetDataLine record) {
        log.info(Constant.RECORDER_STARTED);
        record.start();
    }

    public static void stopRecording(TargetDataLine record) {
        log.info(Constant.RECORDER_STOPPED);
        record.stop();
        record.close();
    }

    public static void recordingTime(int millis) {
        try {
            sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
