package audio;

import java.io.File;

public class Operations {

    PreProcess prp;
    FormatControlConf fc = new FormatControlConf();
    int samplingRate = (int) fc.getRate();
    FeatureExtract fExt;
    WaveData wd;
    private byte[] arrFile;

    Operations() {
        wd = new WaveData();
    }

    public void extractFeatureFromExtractedAmplitureByteArray(float[] originalSignal) {
        EndPointDetection endPointDetection = new EndPointDetection(originalSignal, samplingRate);
        //   prp = new PreProcess(arrAmp, samplingRate);
        //   ByteBuffer.allocate(4).putFloat(prp.afterEndPtDetection).array();
        //fExt = new FeatureExtract(prp.framedSignal, samplingRate, samplePerFrame);
        //fExt.makeMfccFeatureVector();
        //return fExt.getFeatureVector();
        return;
    }

    public float[] extractFloatArrayFromFile(File speechFile) {
        return wd.extractFloatArrayFromFile(speechFile);
    }
}