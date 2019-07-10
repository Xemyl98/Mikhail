package utils.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WaveDataUtil {

    private static byte[] arrFile;
    private static byte[] audioBytes;
    private static float[] audioData;
    private static FileOutputStream fos;
    //    private static ByteArrayInputStream bis;
    private static AudioInputStream audioInputStream;
    private static AudioFormat format;
    private static double durationSec;

    public byte[] getAudioBytes() {
        return audioBytes;
    }

    public double getDurationSec() {
        return durationSec;
    }

    public float[] getAudioData() {
        return audioData;
    }

    public AudioFormat getFormat() {
        return format;
    }


    public static byte[] convertFileToByteArray(File wavFile) {
        try {
            FileInputStream fis = new FileInputStream(wavFile);
            arrFile = new byte[(int) wavFile.length()];
            fis.read(arrFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return arrFile;
    }

    public byte[] getAudioBytes(byte[] arrFile) {
        // System.out.println("File :  "+wavFile+""+arrFile.length);
        ByteArrayInputStream bis = new ByteArrayInputStream(arrFile);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(bis);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        float milliseconds = ((audioInputStream.getFrameLength() * 1000) / audioInputStream.getFormat().getFrameRate());
        durationSec = (long) milliseconds / 1000.0;

        format = audioInputStream.getFormat();
        audioBytes = new byte[(int) (audioInputStream.getFrameLength() * format.getFrameSize())];
        // calculate durationSec

        // System.out.println("The current signal has duration "+durationSec+" Sec");
        try {
            audioInputStream.read(audioBytes);
        } catch (IOException e) {
            System.out.println("IOException during reading audioBytes");
            e.printStackTrace();
        }

        //    return extractAmplitudeFromFileByteArrayInputStream(bis);
        return audioBytes;
    }
    // public float[] getAudioBytes(byte[] arrFile) {


    public static List<Byte> convertByteArrayToByteObject(byte[] bytes) {
        List<Byte> byteList = new ArrayList<>();
        for (byte b : bytes) {
            byteList.add(b);
        }
        return byteList;
    }

    public static List<Byte> readByteListFromFile(File file) {
        List<Byte> bytesFromTestFile = new ArrayList<>();
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                bytesFromTestFile.add(Byte.parseByte(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return bytesFromTestFile;
    }
}
