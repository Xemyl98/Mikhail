package tasks.exceptions;

import org.junit.Before;
import org.junit.Test;
import tasks.exceptions.utility.InvalidArgumentException;

import static org.junit.Assert.assertEquals;

public class SquareParametersTest {

    private SquareParameters squareParameters;

    @Before
    public void setUp() {
        squareParameters = new SquareParameters();
    }

    @Test
    public void calculateSquareWithCorrectParameters() throws InvalidArgumentException {
        assertEquals("12.0", squareParameters.calculateSquare(2,6));
    }
    @Test(expected = InvalidArgumentException.class)
    public void calculateSquareWithIncorrectWidth() throws InvalidArgumentException {
        squareParameters.calculateSquare(-1,6);
    }
}