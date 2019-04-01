package tasks.arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayTaskTest {


    private tasks.arrays.ArrayTask arrayTask;
    private static int[][] arrayWithAllZeroValue;
    private static int[][] arrayWithoutZeroValue;
    private static int[][] arrayWithCorrectDataValueOutput;
    private static int[][] arrayWithIncorrectSize;
    private static int[][] arrayWithCorrectDataValueInput;

    @BeforeClass
    public static void beforeClass() {
        arrayWithAllZeroValue = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        arrayWithoutZeroValue = new int[][]{{1, 2, 3, 4, 5, 6}, {8, 7, 9, 10, 11, -12}, {13, 14, 17, 16, 15, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}};
        arrayWithCorrectDataValueOutput = new int[][]{{1, 2, 3, 4, 0, 0}, {1, 2, 3, 4, 0, 0}, {1, 2, 3, 4, 5, 0}, {1, 2, 3, 0, 0, 0}, {1, 2, 0, 0, 0, 0}};
        arrayWithCorrectDataValueInput = new int[][]{{1, 2, 3, 0, 0, 4}, {1, 2, 3, 0, 4, 0}, {0, 1, 2, 3, 4, 5}, {1, 2, 0, 0, 0, 3}, {0, 0, 1, 2, 0, 0}};
        arrayWithIncorrectSize = new int[][]{{1, 2, 3}, {}};
    }

    @Before
    public void setUp() {
        arrayTask = new tasks.arrays.ArrayTask();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void moveZerosToTheEndOfTheArrayRowWithIncorrectArraySize() {
        arrayTask.moveZerosToTheEndOfTheArrayRow(arrayWithIncorrectSize);
    }

    @Test(expected = NullPointerException.class)
    public void inputOfUninitializedArray() {
        arrayTask.moveZerosToTheEndOfTheArrayRow(null);
    }

    @Test
    public void inputArrayWithAllZeroValue() {
        assertArrayEquals(arrayWithAllZeroValue, arrayTask.moveZerosToTheEndOfTheArrayRow(arrayWithAllZeroValue));
    }


    @Test
    public void inputArrayWithoutZeroValue() {
        assertArrayEquals(arrayWithoutZeroValue, arrayTask.moveZerosToTheEndOfTheArrayRow(arrayWithoutZeroValue));
    }

    @Test
    public void inputArrayWithCorrectValue() {
        assertArrayEquals(arrayWithCorrectDataValueOutput, arrayTask.moveZerosToTheEndOfTheArrayRow(arrayWithCorrectDataValueInput));
    }
}