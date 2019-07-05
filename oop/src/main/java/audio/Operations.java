package audio;

import java.io.File;

public class Operations {

    PreProcess prp;
    FormatControlConf fc = new FormatControlConf();
    int samplingRate = (int) fc.getRate();
    int samplePerFrame = 512;// 23.22ms
    FeatureExtract fExt;
    WaveData wd;
    private byte[] arrFile;

    Operations() {
        wd = new WaveData();
    }

    public void extractFeatureFromExtractedAmplitureByteArray(float[] arrAmp) {
        prp = new PreProcess(arrAmp, samplePerFrame, samplingRate);
        //   ByteBuffer.allocate(4).putFloat(prp.afterEndPtDetection).array();
        //fExt = new FeatureExtract(prp.framedSignal, samplingRate, samplePerFrame);
        //fExt.makeMfccFeatureVector();
        //return fExt.getFeatureVector();
        return;
    }

    /**
     * @param speechFile
     * @return
     * @throws Exception
     */
    public void extractFeatureFromFile(File speechFile) {
        float[] arrAmp;

        arrAmp = wd.extractAmplitudeFromFile(speechFile);

        //  return extractFeatureFromExtractedAmplitureByteArray(arrAmp);
        extractFeatureFromExtractedAmplitureByteArray(arrAmp);
        ;
    }
}