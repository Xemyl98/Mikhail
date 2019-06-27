package audio;

import org.junit.Test;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void mp3ToWav() throws IOException, UnsupportedAudioFileException {
        File mp3File = new File("D:\\test.mp3");
        File wavFile = new File("D:\\test.wav");
        AudioInputStream mp3Stream = AudioSystem.getAudioInputStream(Converter.mp3ToWav(mp3File));
        AudioInputStream wavStream = AudioSystem.getAudioInputStream(wavFile);
        AudioFormat sourceMp3Format = mp3Stream.getFormat();
        AudioFormat sourceWavFormat = wavStream.getFormat();
        assertEquals(sourceMp3Format, sourceWavFormat);
    }
}