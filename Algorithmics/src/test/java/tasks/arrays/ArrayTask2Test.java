package tasks.arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayTask2Test {

    final int[] CORRECT_DATA_FOR_FIRST_ARRAY = {1, 2, 3, 4, 5, 6, 7};
    final int[] CORRECT_DATA_FOR_SECOND_ARRAY = {1, 2, 3, 4, 5};
    final int[] EXPECTED_CORRECT_DATA = {6, 7, 8, 9, 10, 11, 12};
    final int[] FIRST_ARRAY_WITH_INCORRECT_SIZE = {1};
    final int[] SECOND_ARRAY_WITH_INCORRECT_SIZE = {1};
    final int[] ARRAY_WITH_ALL_ZERO_VALUE = {0, 0, 0, 0, 0};
    final int[] EXPECTED_ARRAY_WITH_ALL_ZERO_VALUE = {0};
    private ArrayTask2 arrayTask2;

    @Before
    public void setUp() {
        arrayTask2 = new ArrayTask2();
    }

    @Test
    public void inputArraysWithCorrectValue() {
        assertArrayEquals(EXPECTED_CORRECT_DATA, arrayTask2.findEqualsAmountsInArrays(CORRECT_DATA_FOR_FIRST_ARRAY, CORRECT_DATA_FOR_SECOND_ARRAY));
    }

    @Test(expected = NullPointerException.class)
    public void inputOfUninitializedArrays() {
        arrayTask2.findEqualsAmountsInArrays(null, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findEqualsAmountsInArraysWithIncorrectSize() {
        arrayTask2.findEqualsAmountsInArrays(FIRST_ARRAY_WITH_INCORRECT_SIZE, SECOND_ARRAY_WITH_INCORRECT_SIZE);
    }

    @Test
    public void findEqualsAmountInArraysWithAllZeroValue() {
        assertArrayEquals(EXPECTED_ARRAY_WITH_ALL_ZERO_VALUE, arrayTask2.findEqualsAmountsInArrays(ARRAY_WITH_ALL_ZERO_VALUE, ARRAY_WITH_ALL_ZERO_VALUE));
    }
}