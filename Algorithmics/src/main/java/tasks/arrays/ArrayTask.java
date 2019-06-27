package tasks.arrays;

import utils.arrays.ArrayUtils;

class ArrayTask {

    public int[][] moveZerosToEndRowOfArray(int[][] arrayToSortByZero) {
        ArrayUtils.ArrayIsUninitialized(arrayToSortByZero);
        ArrayUtils.checkArraySize(arrayToSortByZero.length, arrayToSortByZero[0].length, 5, 6);
        return ArrayUtils.getArrayOfMovingZeroElementsToEndOfLine(arrayToSortByZero);
    }

    public int[] findEqualsAmountsInArrays(int[] firstElementOfArrayForSplittingIntoPairs, int[] secondElementOfArrayForSplittingIntoPairs) {
        ArrayUtils.ArrayIsUninitialized(firstElementOfArrayForSplittingIntoPairs);
        ArrayUtils.ArrayIsUninitialized(secondElementOfArrayForSplittingIntoPairs);
        ArrayUtils.checkArraySize(firstElementOfArrayForSplittingIntoPairs.length, 2);
        ArrayUtils.checkArraySize(secondElementOfArrayForSplittingIntoPairs.length, 3);
        return ArrayUtils.searchIdenticalValueInArrays(firstElementOfArrayForSplittingIntoPairs, secondElementOfArrayForSplittingIntoPairs);
    }
}