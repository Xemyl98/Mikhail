package utils.audio;

import constant.AudioConstant;

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
    private static AudioInputStream audioInputStream;
    private static AudioFormat format;
    private static double durationSec;


    public static double getDurationSec() {
        float milliseconds = ((audioInputStream.getFrameLength() * 1000) / audioInputStream.getFormat().getFrameRate());
        durationSec = (long) milliseconds / 1000.0;
        return durationSec;
    }

    public static float[] getAudioData() {
        return audioData;
    }

    public static byte[] getAudioBytes() {
        return audioBytes;
    }

    public static AudioFormat getFormat() {
        return format;
    }

    public static void setFormat() {
        format = audioInputStream.getFormat();
    }

    public static byte[] getArrFile() {
        return arrFile;
    }

    public static void convertFileToByteArray(File wavFile) {
        try {
            FileInputStream fis = new FileInputStream(wavFile);
            arrFile = new byte[(int) wavFile.length()];
            fis.read(arrFile);// TODO: 05.08.2019 посмотреть реализацию в 1 строку
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void convertByteArrayToAudioInputStreamByteArray() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new ByteArrayInputStream(arrFile));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setFormat();
        audioBytes = new byte[(int) (audioInputStream.getFrameLength() * format.getFrameSize())];
        try {
            audioInputStream.read(audioBytes);
        } catch (IOException e) {
            System.out.println("IOException during reading audioBytes");
            e.printStackTrace();
        }
    }

    public static float[] convertAudioInputStreamByteArrayToFloatArray() {
        audioData = null;
        if (format.getSampleSizeInBits() == 16) {
            int nlengthInSamples = audioBytes.length / 2;
            audioData = new float[nlengthInSamples];
            for (int i = 0; i < nlengthInSamples; i++) {
                int MSB = audioBytes[2 * i];
                int LSB = audioBytes[2 * i + 1];// TODO: 05.08.2019 расшифровать аббривеатуру
                if (format.isBigEndian()) {
                    audioData[i] = MSB << 8 | (255 & LSB);
                } else {
                    audioData[i] = LSB << 8 | (255 & MSB);
                }
            }

        } else {
            int nlengthInSamples = audioBytes.length;
            audioData = new float[nlengthInSamples];
            if (format.getEncoding().toString().startsWith(AudioConstant.PCM_SIGNED)) {
                for (int i = 0; i < audioBytes.length; i++) {
                    audioData[i] = audioBytes[i];
                }
            } else {
                for (int i = 0; i < audioBytes.length; i++) {
                    audioData[i] = audioBytes[i] - 128;
                }
            }
        }
        return audioData;
    }

    public static List<Byte> convertArrayToObject(byte[] bytes) {
        List<Byte> byteList = new ArrayList<>();
        for (byte b : bytes) {
            byteList.add(b);
        }
        return byteList;
    }

    public static List<Float> convertArrayToObject(float[] floats) {
        List<Float> floatList = new ArrayList<>();
        for (float b : floats) {
            floatList.add(b);
        }
        return floatList;
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

    public static List<Float> readFloatListFromFile(File file) {
        List<Float> floatFromTestFile = new ArrayList<>();
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                floatFromTestFile.add(Float.parseFloat(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return floatFromTestFile;
    }

    public static void writeArrayToFile(File file, byte[] bytes) {// TODO: 05.08.2019 generic
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            for (byte i : bytes) {
                fileWriter.write(i + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeArrayToFile(File file, float[] floats) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            for (float i : floats) {
                fileWriter.write(i + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeArrayToFile(File file, float[][] floats) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            for (float[] first : floats) {
                for (float second : first) {
                    fileWriter.write(second + " \t");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeArrayToFile(File file, double[][] floats) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            for (double[] first : floats) {
                for (double second : first) {
                    fileWriter.write(second + " \t");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
