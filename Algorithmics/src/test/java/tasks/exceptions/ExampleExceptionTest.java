package tasks.exceptions;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExampleExceptionTest {
    private ExampleException exampleException;

    @Before
    public void setUp() {
        exampleException = new ExampleException();
    }

  @Ignore
  @Test(expected = ArithmeticException.class)
    public void divisionByZero()  {
        exampleException.divideByZeroException(10);
    }
    @Ignore
    @Test(expected = IOException.class)
    public void exceptionFromFile()  {
        exampleException.exceptionsFromFile();
    }
    @Ignore
    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundException()  {
        exampleException.fileNotFoundException();
    }
    @Ignore
    @Test(expected = IndexOutOfBoundsException.class)
    public void arrayIndexOutOfBoundsException()  {
        exampleException.indexOutOfBoundsException();
    }
    @Ignore
    @Test(expected = NullPointerException.class)
    public void nullPointerException()  {
        exampleException.nullPointerException(null);
    }
    @Ignore
    @Test(expected = ArithmeticException.class)
    public void tryCatchInsideEachOtherException()  {
        exampleException.tryCatchInsideEachOther();
    }

}