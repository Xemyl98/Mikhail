package tasks.arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.arrays.ArraysUtilities;

import static org.junit.Assert.assertArrayEquals;

public class ArrayTaskTest {

    private ArrayTask arrayTask;
    private static ArraysUtilities arraysUtilities;
    private static int[] correctDataForFirstOneDimensionalArray;
    private static int[] correctDataForSecondOneDimensionalArray;
    private static int[] expectedCorrectDataForOneDimensionalArray;
    private static int[] firstOneDimensionalArrayWithIncorrectSize;
    private static int[] secondOneDimensionalArrayWithIncorrectSize;
    private static int[] oneDimensionalArrayWithAllZeroValue;
    private static int[] expectedDataValueFromOneDimensionalArrayWithAllZeroValue;
    private static int[][] twoDimensionalArrayWithAllZeroValue;
    private static int[][] twoDimensionalArrayWithoutZeroValue;
    private static int[][] twoDimensionalArrayWithCorrectDataValueOutput;
    private static int[][] twoDimensionalArrayWithCorrectDataValueInput;
    private static int[][] twoDimensionalArrayWithIncorrectSize;

    @BeforeClass
    public static void beforeClass() {
        arraysUtilities=new ArraysUtilities();
        correctDataForFirstOneDimensionalArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        correctDataForSecondOneDimensionalArray = new int[]{1, 2, 3, 4, 5};
        expectedCorrectDataForOneDimensionalArray = new int[]{6, 7, 8, 9, 10, 11, 12};
        firstOneDimensionalArrayWithIncorrectSize = new int[]{1};
        secondOneDimensionalArrayWithIncorrectSize = new int[]{1};
        expectedDataValueFromOneDimensionalArrayWithAllZeroValue = new int[]{0};
        oneDimensionalArrayWithAllZeroValue = new int[]{0, 0, 0, 0, 0};
        twoDimensionalArrayWithAllZeroValue = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        twoDimensionalArrayWithoutZeroValue = new int[][]{{1, 2, 3, 4, 5, 6}, {8, 7, 9, 10, 11, -12}, {13, 14, 17, 16, 15, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}};
        twoDimensionalArrayWithCorrectDataValueOutput = new int[][]{{1, 2, 3, 4, 0, 0}, {1, 2, 3, 4, 0, 0}, {1, 2, 3, 4, 5, 0}, {1, 2, 3, 0, 0, 0}, {1, 2, 0, 0, 0, 0}};
        twoDimensionalArrayWithCorrectDataValueInput = new int[][]{{1, 2, 3, 0, 0, 4}, {1, 2, 3, 0, 4, 0}, {0, 1, 2, 3, 4, 5}, {1, 2, 0, 0, 0, 3}, {0, 0, 1, 2, 0, 0}};
        twoDimensionalArrayWithIncorrectSize = new int[][]{{1, 2, 3}, {}};
    }

    @Before
    public void setUp() {
        arrayTask = new ArrayTask();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void moveZerosToEndRowOfArrayWithIncorrectSize() {
        arrayTask.moveZerosToEndRowOfArray(twoDimensionalArrayWithIncorrectSize,arraysUtilities);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findEqualsAmountsInArraysWithIncorrectArraySize() {
        arrayTask.findEqualsAmountsInArrays(firstOneDimensionalArrayWithIncorrectSize, secondOneDimensionalArrayWithIncorrectSize,arraysUtilities);
    }

    @Test(expected = NullPointerException.class)
    public void moveZerosToEndRowOfArrayWithUninitializedArray() {
        arrayTask.moveZerosToEndRowOfArray(null,arraysUtilities);
    }

    @Test(expected = NullPointerException.class)
    public void findEqualsAmountsInArraysWithUninitializedArray() {
        arrayTask.findEqualsAmountsInArrays(null, null,arraysUtilities);
    }

    @Test
    public void moveZerosToEndRowOfArrayWithAllZeroValue() {
        assertArrayEquals(twoDimensionalArrayWithAllZeroValue, arrayTask.moveZerosToEndRowOfArray(twoDimensionalArrayWithAllZeroValue,arraysUtilities));
    }

    @Test
    public void findEqualsAmountInArraysWithAllZeroValue() {//TODO equalsAmount
        assertArrayEquals(expectedDataValueFromOneDimensionalArrayWithAllZeroValue, arrayTask.findEqualsAmountsInArrays(oneDimensionalArrayWithAllZeroValue, oneDimensionalArrayWithAllZeroValue,arraysUtilities));
    }

    @Test
    public void moveZerosToEndRowOfArrayWithoutZeroValue() {
        assertArrayEquals(twoDimensionalArrayWithoutZeroValue, arrayTask.moveZerosToEndRowOfArray(twoDimensionalArrayWithoutZeroValue,arraysUtilities));
    }

    @Test
    public void moveZerosToEndRowOfArrayWithCorrectValue() {
        assertArrayEquals(twoDimensionalArrayWithCorrectDataValueOutput, arrayTask.moveZerosToEndRowOfArray(twoDimensionalArrayWithCorrectDataValueInput,arraysUtilities));
    }

    @Test
    public void findEqualsAmountsInArraysWithCorrectValue() {
        assertArrayEquals(expectedCorrectDataForOneDimensionalArray, arrayTask.findEqualsAmountsInArrays(correctDataForFirstOneDimensionalArray, correctDataForSecondOneDimensionalArray,arraysUtilities));
    }
}