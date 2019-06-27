package tasks.strings;

import org.junit.Before;
import org.junit.Test;
import tasks.exceptions.InvalidArgumentException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringTaskTest {
    private StringTask stringTask;

    @Before
    public void setUp() {
        stringTask = new tasks.strings.StringTask();
    }

    @Test(expected = NullPointerException.class)
    public void removingSpacesFromEmptyString() {
        stringTask.removeSpacesInTheEnteringSpace("");
    }

    @Test(expected = NullPointerException.class)
    public void cyclicShiftInEmptyString() throws InvalidArgumentException {
        stringTask.cyclicShiftStringSearch("", "");
    }

    @Test(expected = NullPointerException.class)
    public void removingSpacesInUninitializedString() {
        stringTask.removeSpacesInTheEnteringSpace(null);
    }

    @Test(expected = NullPointerException.class)
    public void cyclicShiftInUninitializedString() throws InvalidArgumentException {
        stringTask.cyclicShiftStringSearch(null, null);
    }

    @Test(expected = InvalidArgumentException.class)
    public void cyclicShiftInAStringWithIncorrectLength() throws InvalidArgumentException {
        stringTask.cyclicShiftStringSearch("dsf", "dsfdsf");
    }

    @Test
    public void negativeCyclicShiftTest() throws InvalidArgumentException {
        assertNull(stringTask.cyclicShiftStringSearch("bcd ifa", "abcs if"));
    }

    @Test
    public void checkCyclicShiftStringSearch() throws InvalidArgumentException {
        assertEquals("bcd ifa", stringTask.cyclicShiftStringSearch("bcd ifa", "abcd if"));
    }

    @Test
    public void removeSpacesInStringWithOneSpace() {
        assertEquals("", stringTask.removeSpacesInTheEnteringSpace(" "));
    }

    @Test
    public void removingSpacesInStringConsistingOfTheSpaces() {
        assertEquals("", stringTask.removeSpacesInTheEnteringSpace("      "));
    }

    @Test
    public void removingSpacesFromStringWithSpaceOnFirstAndLastElementsOfLine() {
        assertEquals("Usual\nString", stringTask.removeSpacesInTheEnteringSpace(" Usual\n String "));
    }

    @Test
    public void removingSpacesFromStringWithMultipleSpacesBetweenWords() {
        assertEquals("UsualStringWithMultipleSpaces", stringTask.removeSpacesInTheEnteringSpace("Usual  String   With   Multiple   Spaces"));
    }

    @Test
    public void removeSpacesInCorrectString() {
        String outputText = "English texts for beginners to practice reading and comprehension online and for free. Practicing your comprehension of written English will both improve your vocabulary and understanding of grammar and word order.";
        String expectedString = "Englishtextsforbeginnerstopracticereadingandcomprehensiononlineandforfree.PracticingyourcomprehensionofwrittenEnglishwillbothimproveyourvocabularyandunderstandingofgrammarandwordorder.";
        outputText = stringTask.removeSpacesInTheEnteringSpace(outputText);
        assertEquals(expectedString, outputText);
    }
}