package audio;

import utils.audio.WaveDataUtil;

import java.io.File;

public class WaveData {

    public WaveData() {
    }

    private static void convertFileToByteArray(File wavFile) {
        WaveDataUtil.convertFileToByteArray(wavFile);
    }

    private static void convertByteArrayToAudioInputStreamByteArray() {
        WaveDataUtil.convertByteArrayToAudioInputStreamByteArray();
    }

    private static float[] convertAudioInputStreamByteArrayToFloatArray() {
        return WaveDataUtil.convertAudioInputStreamByteArrayToFloatArray();
    }

    public float[] extractFloatArrayFromFile(File wavFile) {
        convertFileToByteArray(wavFile);
        convertByteArrayToAudioInputStreamByteArray();
        return convertAudioInputStreamByteArrayToFloatArray();
    }
}
