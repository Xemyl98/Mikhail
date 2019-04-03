package tasks.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class ExampleException {
    private static final Logger log = Logger.getLogger(ExampleException.class.getName());

    public void divideByZeroException(int number) {
        try {
            int example = number / 0;
        } catch (ArithmeticException exception) {
            log.info("Division By Zero");
            throw new ArithmeticException();
        }
    }

    public void nullPointerException(String emptyLine) {
        try {
            char example = emptyLine.charAt(0);
        } catch (NullPointerException exception) {
            log.info("Null Pointer Exception");
            throw new NullPointerException();
        }
    }


    public void indexOutOfBoundsException() {
        try {
            int[] array = new int[5];
            int example = array[6];
        } catch (ArrayIndexOutOfBoundsException exception) {
            log.info("Array Index Out Of Bounds Exception");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void fileNotFoundException() throws FileNotFoundException {
        try {
            File file = new File("E://file.txt");
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException exception) {
            log.info("File Not Found Exception");
            throw new FileNotFoundException();
        }
    }

    public void tryCatchInsideEachOther() {
        try {
            String correctLine = "Example";
            char example = correctLine.charAt(10);
            try {
                int divisionByZero = 10 / 0;
            } catch (ArithmeticException ex1) {
                log.info("Division By Zero");
                throw new ArithmeticException();
            }
        } catch (StringIndexOutOfBoundsException ex1) {
            log.info("String Index Out Of Bounds Exception");
            throw new StringIndexOutOfBoundsException();
        }
    }

    public void exceptionsFromFile() throws IOException {
        try {
            FileReader reader = new FileReader("someFile");
            int i = 0;
            while (i != -1)
                i = reader.read();
            reader.close();
        } catch (FileNotFoundException e) {
            log.info("File Not Found Exception");
            throw new FileNotFoundException();
        } catch (IOException e) {
            log.info(e.toString());
            throw new IOException();
        }

        openFile();
    }

    private void openFile() throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader("someFile");
            int i = 0;
            while (i != -1)
                i = reader.read();
            int divisionByZero = i / 10;
        } catch (IOException e) {
            log.info(e.toString());
            throw new IOException();
        } catch (ArithmeticException ex) {
            log.info("Division By Zero");
            throw new ArithmeticException();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.info(e.toString());
                    throw new IOException();
                }
            }
        }
    }
}
