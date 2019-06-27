package tasks.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExampleException {

    private static final String pathToNonExistentFile = "E://file.txt";

    public void divideByZeroException(int number) {
        try {
            int example = number / 0;
        } catch (ArithmeticException exception) {
            throw new ArithmeticException("Division by zero");
        }
    }

    public void nullPointerException(String emptyLine) {
        try {
            char example = emptyLine.charAt(0);
        } catch (NullPointerException exception) {
            throw new NullPointerException("Try to get data from empty line");
        }
    }


    public void indexOutOfBoundsException(int indexBiggerThanArraySize) {
        try {
            int[] array = new int[5];
            int example = array[indexBiggerThanArraySize];
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new ArrayIndexOutOfBoundsException("Try to get data from " + indexBiggerThanArraySize);
        }
    }

    public void fileNotFoundException() throws FileNotFoundException {
        try {
            File file = new File(pathToNonExistentFile);
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException exception) {
            throw new FileNotFoundException(pathToNonExistentFile + " does not exist");
        }
    }

    public void tryCatchInsideEachOther() {
        try {
            String correctLine = "Example";
            char example = correctLine.charAt(10);
            try {
                int divisionByZero = 10 / 0;
            } catch (ArithmeticException ex1) {
                throw new ArithmeticException("Division by zero");
            }
        } catch (StringIndexOutOfBoundsException ex1) {
            throw new StringIndexOutOfBoundsException("String Index Out Of Bounds Exception");
        }
    }

    public void exceptionsFromFile() throws IOException {
        try {
            FileReader reader = new FileReader(pathToNonExistentFile);
            int i = 0;
            while (i != -1)
                i = reader.read();
            reader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(pathToNonExistentFile + " does not exist");
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

        openFile();
    }

    private void openFile() throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader(pathToNonExistentFile);
            int i = 0;
            while (i != -1)
                i = reader.read();
            int divisionByZero = i / 10;
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } catch (ArithmeticException ex) {
            throw new ArithmeticException("Division by zero");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new IOException(e.getMessage());
                }
            }
        }
    }
}
