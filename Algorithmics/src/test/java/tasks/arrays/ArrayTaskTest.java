package tasks.arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayTaskTest {


    private ArrayTask arrayTask;

    private final int[] CORRECT_DATA_FOR_FIRST_ARRAY = {1, 2, 3, 4, 5, 6, 7};
    private final int[] CORRECT_DATA_FOR_SECOND_ARRAY = {1, 2, 3, 4, 5};
    private final int[] EXPECTED_CORRECT_DATA = {6, 7, 8, 9, 10, 11, 12};
    private final int[] FIRST_ARRAY_WITH_INCORRECT_SIZE = {1};
    private final int[] SECOND_ARRAY_WITH_INCORRECT_SIZE = {1};
    private final int[] ARRAY_WITH_ALL_ZERO_VALUE = {0, 0, 0, 0, 0};
    private final int[] EXPECTED_ARRAY_WITH_ALL_ZERO_VALUE = {0};
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void findEqualsAmountsInArraysWithIncorrectArraySize() {
        arrayTask.findEqualsAmountsInArrays(FIRST_ARRAY_WITH_INCORRECT_SIZE, SECOND_ARRAY_WITH_INCORRECT_SIZE);
    }

    @Test(expected = NullPointerException.class)
    public void moveZerosToTheEndOfTheArrayRowWithUninitializedArray() {
        arrayTask.moveZerosToTheEndOfTheArrayRow(null);
    }

    @Test(expected = NullPointerException.class)
    public void findEqualsAmountsInArraysWithUninitializedArray() {
        arrayTask.findEqualsAmountsInArrays(null, null);
    }

    @Test
    public void moveZerosToTheEndOfTheArrayRowWithAllZeroValue() {
        assertArrayEquals(arrayWithAllZeroValue, arrayTask.moveZerosToTheEndOfTheArrayRow(arrayWithAllZeroValue));
    }

    @Test
    public void findEqualsAmountInArraysWithAllZeroValue() {
        assertArrayEquals(EXPECTED_ARRAY_WITH_ALL_ZERO_VALUE, arrayTask.findEqualsAmountsInArrays(ARRAY_WITH_ALL_ZERO_VALUE, ARRAY_WITH_ALL_ZERO_VALUE));
    }

    @Test
    public void inputArrayWithoutZeroValue() {
        assertArrayEquals(arrayWithoutZeroValue, arrayTask.moveZerosToTheEndOfTheArrayRow(arrayWithoutZeroValue));
    }

    @Test
    public void inputArrayWithCorrectValue() {
        assertArrayEquals(arrayWithCorrectDataValueOutput, arrayTask.moveZerosToTheEndOfTheArrayRow(arrayWithCorrectDataValueInput));
    }

    @Test
    public void findEqualsAmountsInArraysWithCorrectValue() {
        assertArrayEquals(EXPECTED_CORRECT_DATA, arrayTask.findEqualsAmountsInArrays(CORRECT_DATA_FOR_FIRST_ARRAY, CORRECT_DATA_FOR_SECOND_ARRAY));
    }
}