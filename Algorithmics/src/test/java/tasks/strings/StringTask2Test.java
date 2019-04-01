package tasks.strings;

import org.junit.Before;
import org.junit.Test;
import tasks.exceptions.utility.InvalidArgumentException;

import static org.junit.Assert.assertEquals;

public class StringTask2Test {

    StringTask2 stringTask2;
    @Before
    public void setUp()
    {
        stringTask2=new StringTask2();
    }
    @Test (expected = NullPointerException.class)
    public void sendingEmptyStringToCyclicShiftStringLookup() throws InvalidArgumentException {
         stringTask2.CyclicShiftStringLookup("","");

    }

    @Test (expected = NullPointerException.class)
    public void sendingNullStringToCyclicShiftStringLookup() throws InvalidArgumentException {
        assertEquals(null, stringTask2.CyclicShiftStringLookup(null,null));
    }

    @Test (expected = InvalidArgumentException.class)
    public void incorrectSizeStringForCyclicMatching() throws InvalidArgumentException {
        stringTask2.CyclicShiftStringLookup("dsf","dsfdsf");
    }
    @Test
    public void correctStringValueForCyclicMatching() throws InvalidArgumentException {
        assertEquals("abcd if",stringTask2.CyclicShiftStringLookup("bcd ifa","abcd if"));
    }
    @Test
    public void inputMismatchedStringsInCyclicShift() throws InvalidArgumentException {
        assertEquals(null,stringTask2.CyclicShiftStringLookup("bcd ifa","abcs if"));
    }

}