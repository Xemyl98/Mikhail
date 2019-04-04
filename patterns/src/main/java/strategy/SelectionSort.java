package strategy;

public class SelectionSort implements Sorting {
    @Override
    public int[] sort(int[] array) {
        for(int barrier=0;barrier<array.length-1;barrier++)
            for(int i=barrier+1;i<array.length;i++)
                if(array[i]<array[barrier])
                {
                    int temp=array[i];
                    array[i]=array[barrier];
                    array[barrier]=temp;
                }
        return array;
    }
}
