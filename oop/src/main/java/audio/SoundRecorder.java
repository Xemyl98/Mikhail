package audio;

import constant.AudioConstant;
import constant.PathToFile;
import utils.audio.SoundRecorderUtil;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundRecorder extends Thread {
    private static TargetDataLine record;

    public void recorderAudioFromMicrophone(int recordingTimeInMillis) {
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, AudioConstant.audioFormat);
        try {
            record = (TargetDataLine) AudioSystem.getLine(info);
            record.open(AudioConstant.audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        }
        SoundRecorderUtil.startRecording(record);
        startThread();
        SoundRecorderUtil.recordingTime(recordingTimeInMillis);
        SoundRecorderUtil.stopRecording(record);
    }

    private void startThread() {
        super.start();
    }

    @Override
    public void run() {
        try {
            AudioSystem.write(
                    new AudioInputStream(record),
                    AudioFileFormat.Type.WAVE,
                    new File(PathToFile.PATH_TO_OUTPUT_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

