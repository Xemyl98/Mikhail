package tasks.collections;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArrayListTaskTest {

    private ArrayListTask arrayListTask;
    private static ArrayList<String> correctDataInputValue;
    private static ArrayList<String> correctDataOutputValue;
    private static ArrayList<String> manySpacesInputValue;
    private static ArrayList<String> manySpacesOutputValue;
    private static ArrayList<String> nullInputValue;
    private static ArrayList<String> nullOutputValue;

    @BeforeClass
    public static void initializeArrayList() {
        correctDataInputValue = new ArrayList<>();
        correctDataOutputValue = new ArrayList<>();
        manySpacesInputValue = new ArrayList<>();
        manySpacesOutputValue = new ArrayList<>();
        nullInputValue = new ArrayList<>();
        nullOutputValue = new ArrayList<>();
        correctDataInputValue.add("New My Lines In this tet");
        correctDataInputValue.add("Pop m4444 works or not");
        correctDataInputValue.add("next Provs");
        correctDataOutputValue.add("New My In tet");
        correctDataOutputValue.add("Pop m4444 or not");
        correctDataOutputValue.add("next ");
        manySpacesInputValue.add("       ");
        manySpacesInputValue.add("   world    and  words  ");
        manySpacesOutputValue.add("       ");
        manySpacesOutputValue.add("   world    and   ");
    }

    @Before
    public void setUp() {
        arrayListTask = new ArrayListTask();
    }

    @Test
    public void deleteWordsEndingInSWithCorrectInputValue() {
        assertEquals(correctDataOutputValue, arrayListTask.deleteWordsEndingInS(correctDataInputValue));
    }

    @Test
    public void inputArrayListWithManySpaces() {
        assertEquals(manySpacesOutputValue, arrayListTask.deleteWordsEndingInS(manySpacesInputValue));
    }

    @Test
    public void deleteWordsEndingInSWithInputValue() {
        assertEquals(nullOutputValue, arrayListTask.deleteWordsEndingInS(nullInputValue));
    }
}