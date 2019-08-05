package constant;

import javax.sound.sampled.AudioFormat;

public class AudioConstant {
    public static final float SAMPLE_RATE = 22050.0F;
    public static final float FRAME_RATE = 22050.0F;
    public static final int SAMPLE_SIZE_IN_BITS = 16;
    public static final int CHANNELS = 1;
    public static final int FRAME_SIZE = 2;
    public static final boolean BIG_ENDIAN = false;
    public static final String PCM_SIGNED = "PCM_SIGN";
    public static final int SAMPLE_PER_FRAME = 512;
    public static final double LENGTH_OF_TEST_WAV_FILE = 5.0;
    public static final AudioFormat audioFormat = new AudioFormat(// TODO: 05.08.2019 Constant
            AudioFormat.Encoding.PCM_SIGNED,
            AudioConstant.SAMPLE_RATE,
            AudioConstant.SAMPLE_SIZE_IN_BITS,
            AudioConstant.CHANNELS,
            AudioConstant.FRAME_SIZE,
            AudioConstant.FRAME_RATE,
            AudioConstant.BIG_ENDIAN);
    public static final int RECORDER_TIME = 5000;
}
