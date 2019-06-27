package audio;

import constant.AudioConstant;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Converter {


    public static final String PATHNAME = "D:\\3.wav";

    public static File mp3ToWav(File mp3Data) throws UnsupportedAudioFileException, IOException {
        // open stream
        File wavFile = new File(PATHNAME);
        AudioInputStream mp3Stream = AudioSystem.getAudioInputStream(mp3Data);
        AudioFormat sourceFormat = mp3Stream.getFormat();
        // create audio format object for the desired stream/audio format
        // this is *not* the same as the file format (wav)
        AudioFormat convertFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_UNSIGNED,
                sourceFormat.getSampleRate(),
                AudioConstant.SAMPLE_SIZE_IN_BITS,
                1,
                2,
                sourceFormat.getFrameRate(),
                false);
        // create stream that delivers the desired format
        //   AudioInputStream test = AudioSystem.getAudioInputStream(convertToMono(convertFormat,mp3Stream,sourceFormat));
        AudioInputStream converted = new AudioInputStream(convertToMono(convertFormat, mp3Stream, sourceFormat), convertToMono(convertFormat, mp3Stream, sourceFormat).getFormat(), mp3Stream.getFrameLength());
        // write stream into a file with file format wav

        AudioSystem.write(converted, AudioFileFormat.Type.WAVE, wavFile);

        return wavFile;
    }

    private static AudioInputStream convertToMono(
            final AudioFormat desiredFormat, AudioInputStream in,
            final AudioFormat inputFormat)
            throws UnsupportedAudioFileException, IOException {
        if (desiredFormat.getSampleSizeInBits() != 16) {
            throw new UnsupportedOperationException(
                    "Only 16-bit samples are supported at the moment "
                            + "(you requested "
                            + desiredFormat.getSampleSizeInBits() + ")");
        }
        if (desiredFormat.getChannels() != 1) {
            throw new UnsupportedOperationException(
                    "Desired number of channels should be 1 "
                            + "(you requested "
                            + desiredFormat.getChannels() + ")");
        }
        if (inputFormat.getChannels() == 1) {
            return AudioSystem.getAudioInputStream(desiredFormat, in);
        } else if (inputFormat.getChannels() == 2) {
            AudioFormat stereoDesiredFormat = new AudioFormat(
                    desiredFormat.getEncoding(),
                    desiredFormat.getSampleRate(), 16, 2, 4,
                    desiredFormat.getFrameRate(),
                    desiredFormat.isBigEndian(), desiredFormat.properties());
            final AudioInputStream stereoIn = AudioSystem
                    .getAudioInputStream(stereoDesiredFormat, in);
            InputStream mixed = new InputStream() {

                byte[] monobuf = new byte[16384];
                int offset = 0;
                int length = 0;

                long bytesRead = 0;

                @Override
                public int read() throws IOException {
                    if (offset < length) {
                        bytesRead++;
                        return monobuf[offset++] & 0xff;
                    }
                    length = stereoIn.read(monobuf);
                    if (length <= 0) {

                        return -1;
                    }
                    // monobuf now contains stereo samples. let's mix them down.
                    for (int i = 0; i < length; i += 4) {
                        int lh, ll, rh, rl;
                        if (desiredFormat.isBigEndian()) {
                            lh = monobuf[i + 0];
                            ll = monobuf[i + 1] & 0xff;
                            rh = monobuf[i + 2];
                            rl = monobuf[i + 3] & 0xff;
                        } else {
                            lh = monobuf[i + 1];
                            ll = monobuf[i + 0] & 0xff;
                            rh = monobuf[i + 3];
                            rl = monobuf[i + 2] & 0xff;
                        }
                        int left = (lh << 8 | ll);
                        int right = (rh << 8 | rl);
                        int mixed = (left + right) / 2;
                        if (desiredFormat.isBigEndian()) {
                            monobuf[(i / 2) + 1] = (byte) (mixed & 0xff);
                            monobuf[(i / 2) + 0] = (byte) ((mixed >> 8) & 0xff);
                        } else {
                            monobuf[(i / 2) + 0] = (byte) (mixed & 0xff);
                            monobuf[(i / 2) + 1] = (byte) ((mixed >> 8) & 0xff);
                        }
                    }
                    length /= 2;
                    offset = 0;
                    return monobuf[offset++] & 0xff;
                }

                @Override
                public synchronized void mark(int readlimit) {
                    throw new UnsupportedOperationException(
                            "Mark not supported");
                }
            };
            return new AudioInputStream(mixed, desiredFormat,
                    stereoIn.getFrameLength());
        } else {
            throw new UnsupportedAudioFileException(
                    "Unsupported number of channels: "
                            + inputFormat.getChannels());
        }
    }


}
