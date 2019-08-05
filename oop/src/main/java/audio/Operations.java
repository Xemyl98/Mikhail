package audio;

import audio.feature.FeatureExtract;
import audio.feature.FeatureVector;
import constant.AudioConstant;

import java.io.File;

public class Operations {

    PreProcess prp;
    FormatControlConf fc = new FormatControlConf();
    int samplingRate = (int) fc.getRate();
    FeatureExtract fExt;
    WaveData wd;

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

    public FeatureVector extractFeatureFromExtractedAmplitureByteArray(float[] originalSignal) {
        EndPointDetection endPointDetection = new EndPointDetection(originalSignal, samplingRate);
        endPointDetection.calculateSilenceRemovedSignal();
        prp = new PreProcess(originalSignal, endPointDetection.getSilenceRemovedSignal(), samplingRate);
        prp.normalizePCM();
        prp.doFraming();
        prp.doWindowing();
        fExt = new FeatureExtract(prp.framedSignal, samplingRate, AudioConstant.SAMPLE_PER_FRAME);
        fExt.makeMfccFeatureVector();
        return fExt.getFeatureVector();

    }
}