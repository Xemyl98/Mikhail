import org.junit.Test;

import static org.junit.Assert.*;

public class RemovingSpacesTest {

    @Test
    public void emptyLine() {
        RemovingSpaces removingSpaces=new RemovingSpaces();
        String actual= removingSpaces.Remove("");
        assertEquals(null,actual);
    }
    @Test
    public void space()
    {
        RemovingSpaces removingSpaces=new RemovingSpaces();
        String actual=removingSpaces.Remove(" ");
        assertEquals(null,actual);
    }
    @Test
    public void manySpaces()
    {
        RemovingSpaces removingSpaces=new RemovingSpaces();
        String actual=removingSpaces.Remove("      ");
        assertEquals(null,actual);
    }
    @Test
    public void spaceStartEnd()
    {
        RemovingSpaces removingSpaces=new RemovingSpaces();
        String actual=removingSpaces.Remove(" Usual String ");
        assertEquals("UsualString",actual);
    }
    @Test
    public void usualString()
    {
        RemovingSpaces removingSpaces=new RemovingSpaces();
        String actual=removingSpaces.Remove("English texts for beginners to practice reading and comprehension online and for free. Practicing your comprehension of written English will both improve your vocabulary and understanding of grammar and word order.");
        assertEquals("Englishtextsforbeginnerstopracticereadingandcomprehensiononlineandforfree.PracticingyourcomprehensionofwrittenEnglishwillbothimproveyourvocabularyandunderstandingofgrammarandwordorder.",actual);
    }
}