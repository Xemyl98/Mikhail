package tasks.exceptions;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExampleExceptionTest {
    private ExampleException exampleException;

    @Before
    public void setUp() {
        exampleException = new ExampleException();
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() {
        exampleException.divideByZeroException(10);
    }

    @Test(expected = IOException.class)
    public void exceptionFromFile() throws IOException {
        exampleException.exceptionsFromFile();
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundException() throws FileNotFoundException {
        exampleException.fileNotFoundException();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void arrayIndexOutOfBoundsException() {
        exampleException.indexOutOfBoundsException(6);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerException() {
        exampleException.nullPointerException(null);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void tryCatchInsideEachOtherException() {
        exampleException.tryCatchInsideEachOther();
    }

}