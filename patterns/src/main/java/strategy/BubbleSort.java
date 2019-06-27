package strategy;

public class BubbleSort implements Sorting {
    @Override
    public int[] sort(int[] array) {
        for (int barrier = array.length - 1; barrier >= 0; barrier--)
            for (int i = 0; i < barrier; i++)
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
        return array;
    }
}
