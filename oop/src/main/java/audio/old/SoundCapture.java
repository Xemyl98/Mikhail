package audio.old;

import audio.EndPointDetection;
import audio.FormatControlConf;
import audio.PreProcess;
import audio.WaveData;

import java.io.File;

public class SoundCapture {
    WaveData wd;
    PreProcess prp;
    EndPointDetection end;
    FormatControlConf fc = new FormatControlConf();
    int samplingRate = (int) fc.getRate();

    public SoundCapture() {
        wd = new WaveData();
    }

    public float[] extractFeatureFromFileByteArray(File file) throws Exception {
        float[] arrAmp;

        arrAmp = wd.extractAmplitudeFromFile(file);
        prp = new PreProcess(arrAmp, 512, samplingRate);

        return (arrAmp);
    }
}
