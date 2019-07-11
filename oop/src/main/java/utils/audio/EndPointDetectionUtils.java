package utils.audio;

public class EndPointDetectionUtils {
    private static float[] originalSignal; // input
    private static float[] originalSignalWithoutStartSilence;
    private static float[] silenceRemovedSignal;// output
    private static int samplingRate;
    private static int firstSamples;
    private static int samplePerFrame;

    private static float sum = 0;
    private static float[] voiced;
    private static double average = 0.0;
    private static double standardDeviation = 0.0;
    private static int usefulFramesCount = 1;
    private static int frameCount = 0;
    private static int[] voicedFrame;

    public static void setOriginalSignal(float[] originalSignal) {
        EndPointDetectionUtils.originalSignal = originalSignal;
    }

    public static void setSamplingRate(int samplingRate) {
        EndPointDetectionUtils.samplingRate = samplingRate;
    }

    public static void setFirstSamples() {
        EndPointDetectionUtils.firstSamples = samplePerFrame * 200;
    }

    public static void setVoiced(float[] voiced) {
        EndPointDetectionUtils.voiced = voiced;
    }

    public static void setSamplePerFrame() {
        EndPointDetectionUtils.samplePerFrame = samplingRate / 1000;
    }

    public static float[] getSilenceRemovedSignal() {
        return silenceRemovedSignal;
    }

    public static float[] getVoiced() {
        return voiced;
    }

    public static int getFrameCount() {
        return frameCount;
    }

    public static int[] getVoicedFrame() {
        return voicedFrame;
    }

    public static double calculationTheAverage() {
        for (int i = 0; i < firstSamples; i++) {
            sum += originalSignal[i];
        }
        average = sum / firstSamples;
        sum = 0;
        return average;
    }

    public static double calculationOfStandardDeviation() {
        for (int i = 0; i < firstSamples; i++) {
            sum += Math.pow((originalSignal[i] - average), 2);
        }
        standardDeviation = Math.sqrt(sum / firstSamples);
        return standardDeviation;
    }

    public static float[] identifyingWhetherOneDimensionalMahalanobisDistanceFunction() {
        for (int i = 0; i < originalSignal.length; i++) {
            if ((Math.abs(originalSignal[i] - average) / standardDeviation) > 2) {
                voiced[i] = 1;
            } else {
                voiced[i] = 0;
            }
        }
        return voiced;
    }

    public static int calculationOfVoicedAndUnvoicedSignals() {
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

    public static float[] silenceRemoval() {
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

}
