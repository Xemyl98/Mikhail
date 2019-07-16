package audio;

import constant.AudioConstant;

public class PreProcess {

    float[] originalSignal;// initial extracted PCM,
    float[] afterEndPtDetection;// after endPointDetection
    public int noOfFrames;// calculated total no of frames
    int samplePerFrame = AudioConstant.SAMPLE_PER_FRAME;// how many samples in one frame
    int framedArrayLength;// how many samples in framed array
    public float[][] framedSignal;
    float[] hammingWindow;
    int samplingRate;

    public PreProcess(float[] originalSignal, float[] silenceRemovedSignal, int samplingRate) {
        this.originalSignal = originalSignal;
        this.samplingRate = samplingRate;
        afterEndPtDetection = silenceRemovedSignal;
    }

    public void normalizePCM() {
        float max = originalSignal[0];
        for (int i = 1; i < originalSignal.length; i++) {
            if (max < Math.abs(originalSignal[i])) {
                max = Math.abs(originalSignal[i]);
            }
        }

        for (int i = 0; i < originalSignal.length; i++) {
            originalSignal[i] = originalSignal[i] / max;
        }
    }

    /**
     * divides the whole signal into frames of samplerPerFrame
     */
    public void doFraming() {
        // calculate no of frames, for framing

        noOfFrames = 2 * afterEndPtDetection.length / samplePerFrame - 1;

        framedSignal = new float[noOfFrames][samplePerFrame];
        for (int i = 0; i < noOfFrames; i++) {
            int startIndex = (i * samplePerFrame / 2);
            for (int j = 0; j < samplePerFrame; j++) {
                framedSignal[i][j] = afterEndPtDetection[startIndex + j];
            }
        }
    }

    /**
     * does hamming window on each frame
     */
    public float[][] doWindowing() {
        // prepare hammingWindow
        hammingWindow = new float[samplePerFrame + 1];
        // prepare for through out the data
        for (int i = 1; i <= samplePerFrame; i++) {

            hammingWindow[i] = (float) (0.54 - 0.46 * (Math.cos(2 * Math.PI * i / samplePerFrame)));
        }
        // do windowing
        for (int i = 0; i < noOfFrames; i++) {
            for (int j = 0; j < samplePerFrame; j++) {
                framedSignal[i][j] = framedSignal[i][j] * hammingWindow[j + 1];
            }
        }
        return framedSignal;
    }
}