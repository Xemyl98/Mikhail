package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayTaskTest {

    final int[][] ALLZEROINPUTARRAY = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
    final int[][] ARRAYWITHOUTZERO = {{1, 2, 3, 4, 5, 6}, {8, 7, 9, 10, 11, -12}, {13, 14, 17, 16, 15, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}};
    final int[][] DEFAULTUSERARRAY = {{1, 2, 3, 4, 0, 0}, {1, 2, 3, 4, 0, 0}, {1, 2, 3, 4, 5, 0}, {1, 2, 3, 0, 0, 0}, {1, 2, 0, 0, 0, 0}};
    private ArrayTask arrayTask;

    @Before
    public void setUp() {
        arrayTask = new ArrayTask();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void incorrectArraySize() {
        int[][] inputArray = {{1, 2, 3}, {4, 5, 6}};
        assertArrayEquals(null, arrayTask.zeroTransferToEndLineOfArray(inputArray));
    }

    @Test(expected = NullPointerException.class)
    public void inputNull() {
        assertArrayEquals(null, arrayTask.zeroTransferToEndLineOfArray(null));
    }

    @Test
    public void allZeroInputArray() {
        int[][] inputArray = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        assertArrayEquals(ALLZEROINPUTARRAY, arrayTask.zeroTransferToEndLineOfArray(inputArray));
    }

    @Test
    public void inputArrayWithoutZero() {
        int[][] inputArray = {{1, 2, 3, 4, 5, 6}, {8, 7, 9, 10, 11, -12}, {13, 14, 17, 16, 15, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}};
        assertArrayEquals(ARRAYWITHOUTZERO, arrayTask.zeroTransferToEndLineOfArray(inputArray));
    }

    @Test
    public void defaultUserArrayInput() {
        int[][] inputArray = {{1, 2, 3, 0, 0, 4}, {1, 2, 3, 0, 4, 0}, {0, 1, 2, 3, 4, 5}, {1, 2, 0, 0, 0, 3}, {0, 0, 1, 2, 0, 0}};
        assertArrayEquals(DEFAULTUSERARRAY, arrayTask.zeroTransferToEndLineOfArray(inputArray));
    }
}