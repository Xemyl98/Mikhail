package audio;

import utils.audio.EndPointDetectionUtils;

public class EndPointDetection {

    private float[] originalSignal;
    private int samplingRate;

    public EndPointDetection(float[] originalSignal, int samplingRate) {
        this.originalSignal = originalSignal;
        this.samplingRate = samplingRate;
        EndPointDetectionUtils.setOriginalSignal(originalSignal);
        EndPointDetectionUtils.setSamplingRate(samplingRate);
        EndPointDetectionUtils.setSamplePerFrame();
        EndPointDetectionUtils.setFirstSamples();
        EndPointDetectionUtils.setVoiced(new float[originalSignal.length]);
    }

    public float[] getSilenceRemovedSignal() {
        EndPointDetectionUtils.calculationTheAverage();
        EndPointDetectionUtils.calculationOfStandardDeviation();
        EndPointDetectionUtils.identifyingWhetherOneDimensionalMahalanobisDistanceFunction();
        EndPointDetectionUtils.calculationOfVoicedAndUnvoicedSignals();
        return EndPointDetectionUtils.silenceRemoval();
    }
}
