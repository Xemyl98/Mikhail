package tasks.strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTaskTest {
    private tasks.strings.StringTask stringTask;

    @Before
    public void initTest() {
        stringTask = new tasks.strings.StringTask();
    }

    @Test (expected = NullPointerException.class)
    public void emptyLineInput() {
        String outputString = stringTask.removingSpaces("");
        assertEquals(null, outputString);
    }

    @Test (expected = NullPointerException.class)
    public void nullLineInput() { assertEquals(null, stringTask.removingSpaces(null));
    }

    @Test
    public void inputLineWithOneSpace() {
        assertEquals("", stringTask.removingSpaces(" "));
    }

    @Test
    public void inputLineWithManySpaces() {
        assertEquals("", stringTask.removingSpaces("      "));
    }

    @Test
    public void inputLineWithSpaceOnBeginningAndEndOfLine() {
        assertEquals("UsualString", stringTask.removingSpaces(" Usual String "));
    }

    @Test
    public void defaultUserStringInput() {
        String outputString = stringTask.removingSpaces("English texts for beginners to practice reading and comprehension online and for free. Practicing your comprehension of written English will both improve your vocabulary and understanding of grammar and word order.");
        String expectedString = "Englishtextsforbeginnerstopracticereadingandcomprehensiononlineandforfree.PracticingyourcomprehensionofwrittenEnglishwillbothimproveyourvocabularyandunderstandingofgrammarandwordorder.";
        assertEquals(expectedString, outputString);
    }
}