package utils.audio;

import audio.EndPointDetection;
import constant.AudioConstant;

public class PreProcessUtil {

    float[] originalSignal;
    float[] afterEndPtDetection;
    public int noOfFrames;
    int samplePerFrame = AudioConstant.SAMPLE_PER_FRAME;
    int framedArrayLength;
    public float[][] framedSignal;
    float[] hammingWindow;
    EndPointDetection epd;
    int samplingRate;
}
