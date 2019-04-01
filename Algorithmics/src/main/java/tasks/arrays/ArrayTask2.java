package tasks.arrays;

import tasks.arrays.utility.ArraysUtilities;

public class ArrayTask2 {
    public int[] findEqualsAmountsInArrays(int [] firstArray, int [] secondArray)
    {
        ArraysUtilities.testEmptyArray(firstArray);
        ArraysUtilities.testEmptyArray(secondArray);
        ArraysUtilities.testOnCorrectSizeOfArray(firstArray.length,2);
        ArraysUtilities.testOnCorrectSizeOfArray(secondArray.length,3);
        return ArraysUtilities.searchForIdenticalValuesInArrays(firstArray,secondArray);
    }
}
