package tasks.strings;

import org.junit.Before;
import org.junit.Test;
import tasks.exceptions.InvalidArgumentException;

import static org.junit.Assert.assertEquals;

public class StringTaskTest {
    private tasks.strings.StringTask stringTask;

    @Before
    public void setUp() {
        stringTask = new tasks.strings.StringTask();
    }

    @Test(expected = NullPointerException.class)
    public void removingSpacesOfEmptyString() {
        stringTask.removingSpacesInTheEnteringSpace("");
    }

    @Test(expected = NullPointerException.class)
    public void cyclicShiftOfEmptyString() throws InvalidArgumentException {
        stringTask.cyclicShiftStringLooking("", "");
    }

    @Test(expected = NullPointerException.class)
    public void removingSpacesOfUninitializedString() {
        stringTask.removingSpacesInTheEnteringSpace(null);
    }

    @Test(expected = NullPointerException.class)
    public void cyclicShiftOfUninitializedString() throws InvalidArgumentException {
        stringTask.cyclicShiftStringLooking(null, null);
    }

    @Test(expected = InvalidArgumentException.class)
    public void incorrectSizeStringForCyclicMatching() throws InvalidArgumentException {
        stringTask.cyclicShiftStringLooking("dsf", "dsfdsf");
    }

    @Test
    public void inputMismatchedStringsInCyclicShift() throws InvalidArgumentException {
        assertEquals(null, stringTask.cyclicShiftStringLooking("bcd ifa", "abcs if"));
    }

    @Test
    public void correctStringValueForCyclicMatching() throws InvalidArgumentException {
        assertEquals("bcd ifa", stringTask.cyclicShiftStringLooking("bcd ifa", "abcd if"));
    }

    @Test
    public void removingSpacesInStringWithOneSpace() {
        assertEquals("", stringTask.removingSpacesInTheEnteringSpace(" "));
    }

    @Test
    public void removingSpacesInStringConsistingOfTheSpaces() {
        assertEquals("", stringTask.removingSpacesInTheEnteringSpace("      "));
    }

    @Test
    public void removingSpacesInStringWithSpaceOnBeginningAndEndOfLine() {
        assertEquals("UsualString", stringTask.removingSpacesInTheEnteringSpace(" Usual String "));
    }

    @Test
    public void removingSpacesInStringWithMultipleSpacesBetweenWords() {
        assertEquals("UsualStringWithMultipleSpaces", stringTask.removingSpacesInTheEnteringSpace("Usual  String   With   Multiple   Spaces"));
    }

    @Test
    public void defaultUserStringInput() {
        String outputString = stringTask.removingSpacesInTheEnteringSpace("English texts for beginners to practice reading and comprehension online and for free. Practicing your comprehension of written English will both improve your vocabulary and understanding of grammar and word order.");
        String expectedString = "Englishtextsforbeginnerstopracticereadingandcomprehensiononlineandforfree.PracticingyourcomprehensionofwrittenEnglishwillbothimproveyourvocabularyandunderstandingofgrammarandwordorder.";
        assertEquals(expectedString, outputString);
    }
}