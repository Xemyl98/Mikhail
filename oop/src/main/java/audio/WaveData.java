package audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class WaveData {
    private byte[] arrFile;
    private byte[] audioBytes;
    private float[] audioData;
    private FileOutputStream fos;
    private ByteArrayInputStream bis;
    private AudioInputStream audioInputStream;
    private AudioFormat format;
    private double durationSec;

    public WaveData() {
    }

    public float[] extractAmplitudeFromFile(File wavFile) throws Exception {
        try {
            // create file input stream
            FileInputStream fis = new FileInputStream(wavFile);
            // create bytearray from file
            arrFile = new byte[(int) wavFile.length()];
            fis.read(arrFile);
        } catch (Exception e) {
            System.out.println("SomeException : " + e.toString());
        }
        return extractAmplitudeFromFileByteArray(arrFile);
    }

    public float[] extractAmplitudeFromFileByteArray(byte[] arrFile) throws Exception {
        // System.out.println("File :  "+wavFile+""+arrFile.length);
        bis = new ByteArrayInputStream(arrFile);
        return extractAmplitudeFromFileByteArrayInputStream(bis);
    }

    public float[] extractAmplitudeFromFileByteArrayInputStream(ByteArrayInputStream bis) throws Exception {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(bis);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("unsupported file type, during extract amplitude");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException during extracting amplitude");
            e.printStackTrace();
        }
        float milliseconds = (long) ((audioInputStream.getFrameLength() * 1000) / audioInputStream.getFormat().getFrameRate());
        durationSec = milliseconds / 1000.0;
        return extractFloatDataFromAudioInputStream(audioInputStream);
    }

    public float[] extractFloatDataFromAudioInputStream(AudioInputStream audioInputStream) throws Exception {
        format = audioInputStream.getFormat();
        audioBytes = new byte[(int) (audioInputStream.getFrameLength() * format.getFrameSize())];
        // calculate durationSec
        float milliseconds = (long) ((audioInputStream.getFrameLength() * 1000) / audioInputStream.getFormat().getFrameRate());
        durationSec = milliseconds / 1000.0;
        // System.out.println("The current signal has duration "+durationSec+" Sec");
        try {
            audioInputStream.read(audioBytes);
        } catch (IOException e) {
            System.out.println("IOException during reading audioBytes");
            e.printStackTrace();
        }
        return extractFloatDataFromAmplitudeByteArray(format, audioBytes);
    }

    public float[] extractFloatDataFromAmplitudeByteArray(AudioFormat format, byte[] audioBytes) throws Exception {
        // convert
        audioData = null;
        if (format.getSampleSizeInBits() == 16) {
            int nlengthInSamples = audioBytes.length / 2;
            audioData = new float[nlengthInSamples];
            if (format.isBigEndian()) {
                for (int i = 0; i < nlengthInSamples; i++) {
                    /* First byte is MSB (high order) */
                    int MSB = audioBytes[2 * i];
                    /* Second byte is LSB (low order) */
                    int LSB = audioBytes[2 * i + 1];
                    audioData[i] = MSB << 8 | (255 & LSB);
                }
            } else {
                for (int i = 0; i < nlengthInSamples; i++) {
                    /* First byte is LSB (low order) */
                    int LSB = audioBytes[2 * i];
                    /* Second byte is MSB (high order) */
                    int MSB = audioBytes[2 * i + 1];
                    audioData[i] = MSB << 8 | (255 & LSB);
                }
            }
        } else if (format.getSampleSizeInBits() == 8) {
            int nlengthInSamples = audioBytes.length;
            audioData = new float[nlengthInSamples];
            if (format.getEncoding().toString().startsWith("PCM_SIGN")) {
                for (int i = 0; i < audioBytes.length; i++) {
                    audioData[i] = audioBytes[i];
                }
            } else {
                for (int i = 0; i < audioBytes.length; i++) {
                    audioData[i] = audioBytes[i] - 128;
                }
            }
        }// end of if..else
        // System.out.println("PCM Returned===============" +
        // audioData.length);
        CustomWaveFile wf = new CustomWaveFile(2, 48000, 1, audioData);
        wf.saveFile(new File("D:\\31.wav"));
        return audioData;
    }
}
