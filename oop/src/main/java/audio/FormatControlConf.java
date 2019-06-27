package audio;

import javax.sound.sampled.AudioFormat;

public class FormatControlConf {
    AudioFormat.Encoding encoding;
    int sampleSize;
    boolean bigEndian;
    int channels;
    float SAMPLING_RATE = 22050.0f;
    float rate;

    public FormatControlConf() {
        encoding = AudioFormat.Encoding.PCM_SIGNED;
        rate = (float) SAMPLING_RATE;
        sampleSize = 16;
        bigEndian = false;
        channels = 1; // mono channel
    }

    public float getRate() {
        return rate;
    }
}
