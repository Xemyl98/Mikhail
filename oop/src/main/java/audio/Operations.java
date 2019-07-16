package audio;

import java.io.File;

public class Operations {

    PreProcess prp;
    FormatControlConf fc = new FormatControlConf();
    int samplingRate = (int) fc.getRate();
    FeatureExtract fExt;
    WaveData wd;
    private byte[] arrFile;

    public Operations() {
        wd = new WaveData();
    }

    public float[] extractFloatArrayFromFile(File speechFile) {
        return wd.extractFloatArrayFromFile(speechFile);
    }

    public float[] getSilenceRemovedSignal(float[] originalSignal) {
        EndPointDetection endPointDetection = new EndPointDetection(originalSignal, samplingRate);
        return endPointDetection.calculateSilenceRemovedSignal();
    }

    public float[][] getFramedSignal(float[] originalSignal, float[] silenceRemovedSignal) {
        prp = new PreProcess(originalSignal, silenceRemovedSignal, samplingRate);
        prp.normalizePCM();
        prp.doFraming();
        return prp.doWindowing();
    }

    public void extractFeatureFromExtractedAmplitureByteArray(float[] originalSignal) {
        EndPointDetection endPointDetection = new EndPointDetection(originalSignal, samplingRate);
        prp = new PreProcess(originalSignal, endPointDetection.getSilenceRemovedSignal(), samplingRate);
        //   ByteBuffer.allocate(4).putFloat(prp.afterEndPtDetection).array();
        //fExt = new FeatureExtract(prp.framedSignal, samplingRate, samplePerFrame);
        //fExt.makeMfccFeatureVector();
        //return fExt.getFeatureVector();
        return;
    }
}