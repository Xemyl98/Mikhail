package audio;

public class EndPointDetection {

    private float[] originalSignal; // input
    //    private static float[] originalSignalWithoutStartSilence;
    private float[] silenceRemovedSignal;// output
    private int samplingRate;
    private int firstSamples;
    private int samplePerFrame;

    private float sum = 0;
    private float[] voiced;
    private double average = 0.0;
    private double standardDeviation = 0.0;
    private int usefulFramesCount = 1;
    private int frameCount = 0;
    private int[] voicedFrame;

    public EndPointDetection(float[] originalSignal, int samplingRate) {
        this.originalSignal = originalSignal;
        this.samplingRate = samplingRate;
        setSamplePerFrame();
        setFirstSamples();
        setVoiced(new float[originalSignal.length]);
    }

    public void setOriginalSignal(float[] originalSignal) {
        this.originalSignal = originalSignal;
    }

    public void setSamplingRate(int samplingRate) {
        this.samplingRate = samplingRate;
    }

    public void setFirstSamples() {
        this.firstSamples = samplePerFrame * 200;
    }

    public void setVoiced(float[] voiced) {
        this.voiced = voiced;
    }

    public void setSamplePerFrame() {
        this.samplePerFrame = samplingRate / 1000;
    }

    public float[] getSilenceRemovedSignal() {
        return silenceRemovedSignal;
    }

    public float[] getVoiced() {
        return voiced;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public int[] getVoicedFrame() {
        return voicedFrame;
    }

    private double calculationTheAverage() {
        for (int i = 0; i < firstSamples; i++) {
            sum += originalSignal[i];
        }
        average = sum / firstSamples;
        sum = 0;
        return average;
    }

    private double calculationOfStandardDeviation() {
        for (int i = 0; i < firstSamples; i++) {
            sum += Math.pow((originalSignal[i] - average), 2);
        }
        standardDeviation = Math.sqrt(sum / firstSamples);
        return standardDeviation;
    }

    private float[] identifyingWhetherOneDimensionalMahalanobisDistanceFunction() {
        for (int i = 0; i < originalSignal.length; i++) {
            if ((Math.abs(originalSignal[i] - average) / standardDeviation) > 2) {
                voiced[i] = 1;
            } else {
                voiced[i] = 0;
            }
        }
        return voiced;
    }

    private int calculationOfVoicedAndUnvoicedSignals() {
        int count_voiced = 0;
        int count_unvoiced = 0;
        voicedFrame = new int[originalSignal.length / samplePerFrame];
        int loopCount = originalSignal.length - (originalSignal.length % samplePerFrame);

        for (int i = 0; i < loopCount; i += samplePerFrame) {
            count_voiced = 0;
            count_unvoiced = 0;
            for (int j = i; j < i + samplePerFrame; j++) {
                if (voiced[j] == 1) {
                    count_voiced++;
                } else {
                    count_unvoiced++;
                }
            }
            if (count_voiced > count_unvoiced) {
                usefulFramesCount++;
                voicedFrame[frameCount++] = 1;
            } else {
                voicedFrame[frameCount++] = 0;
            }
        }
        return usefulFramesCount;
    }

    private float[] silenceRemoval() {
        silenceRemovedSignal = new float[usefulFramesCount * samplePerFrame];
        int k = 0;
        for (int i = 0; i < frameCount; i++) {
            if (voicedFrame[i] == 1) {
                for (int j = i * samplePerFrame; j < i * samplePerFrame + samplePerFrame; j++) {
                    silenceRemovedSignal[k++] = originalSignal[j];
                }
            }
        }
        return silenceRemovedSignal;
    }

    public float[] calculateSilenceRemovedSignal() {
        calculationTheAverage();
        calculationOfStandardDeviation();
        identifyingWhetherOneDimensionalMahalanobisDistanceFunction();
        calculationOfVoicedAndUnvoicedSignals();
        return silenceRemoval();
    }
}
