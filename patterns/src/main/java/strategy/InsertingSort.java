package strategy;

public class InsertingSort implements Sorting {
    @Override
    public int[] sort(int[] array) {
        for (int barrier = 1; barrier < array.length; barrier++) {
            int index = barrier;
            while (index - 1 >= 0 && array[index] < array[index - 1]) {
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
        return array;
    }
}
