package audio;

import utils.audio.WaveDataUtil;

import java.io.File;

public class WaveData {

    public WaveData() {
    }

    public float[] extractFloatArrayFromFile(File wavFile) {
        WaveDataUtil.convertFileToByteArray(wavFile);
        WaveDataUtil.convertByteArrayToAudioInputStreamByteArray();
        return WaveDataUtil.convertAudioInputStreamByteArrayToFloatArray();
    }
}
