package strategy;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StrategyClientTest {
    private static StrategyClient bubbleSortStrategyClient;
    private static StrategyClient insertingSortStrategyClient;
    private static StrategyClient selectionSortStrategyClient;
    private static final int[] ARRAY_WITH_UNSORTED_DATA_VALUE = {5, 4, 7, 4, 5, 6, 3};
    private static final int[] ARRAY_WITH_SORTED_DATA_VALUE = {3, 4, 4, 5, 5, 6, 7};

    @BeforeClass
    public static void beforeClass() {
        bubbleSortStrategyClient = new StrategyClient();
        insertingSortStrategyClient = new StrategyClient();
        selectionSortStrategyClient = new StrategyClient();
        bubbleSortStrategyClient.strategy = new BubbleSort();
        insertingSortStrategyClient.strategy = new InsertingSort();
        selectionSortStrategyClient.strategy = new SelectionSort();
    }

    @Test
    public void positiveBubbleSortTest() {
        assertArrayEquals(ARRAY_WITH_SORTED_DATA_VALUE, bubbleSortStrategyClient.executeStrategy(ARRAY_WITH_UNSORTED_DATA_VALUE));
    }

    @Test
    public void positiveInsertingSortTest() {
        assertArrayEquals(ARRAY_WITH_SORTED_DATA_VALUE, insertingSortStrategyClient.executeStrategy(ARRAY_WITH_UNSORTED_DATA_VALUE));
    }

    @Test
    public void positiveSelectionSortTest() {
        assertArrayEquals(ARRAY_WITH_SORTED_DATA_VALUE, selectionSortStrategyClient.executeStrategy(ARRAY_WITH_UNSORTED_DATA_VALUE));
    }
}