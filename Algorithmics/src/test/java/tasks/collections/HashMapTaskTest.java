package tasks.collections;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HashMapTaskTest {
    private HashMapTask hashMapTask;
    private static Map<Integer,Integer> correctDataInputValue;
    @BeforeClass
    public static void initializeArrayList()
    {
        correctDataInputValue =new HashMap<>();

    }
    @Before
    public void setUp()
    {
        hashMapTask=new HashMapTask();
    }
    @Test
    public void deleteWordsEndingInSWithCorrectInputValue() {
        assertEquals("",hashMapTask.CalculateTheNumberOfRepetitionsOfRandomGeneration());
    }

}