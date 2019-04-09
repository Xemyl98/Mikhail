package tasks.arrays;

import utility.arrays.ArraysUtilities;

class ArrayTask {

    int[][] moveZerosToEndRowOfArray(int[][] arrayToSortByZero, ArraysUtilities arraysUtilities) {
        arraysUtilities.checkForAUninitializedArrayInput(arrayToSortByZero);
        arraysUtilities.checkArraySize(arrayToSortByZero.length, arrayToSortByZero[0].length, 5, 6);
        return arraysUtilities.getAnArrayOfMovingZeroElementsToEndOfLine(arrayToSortByZero);
    }

    int[] findEqualsAmountsInArrays(int[] firstElementOfArrayForSplittingIntoPairs, int[] secondElementOfArrayForSplittingIntoPairs, ArraysUtilities arraysUtilities) {
        arraysUtilities.checkForAUninitializedArrayInput(firstElementOfArrayForSplittingIntoPairs);
        arraysUtilities.checkForAUninitializedArrayInput(secondElementOfArrayForSplittingIntoPairs);
        arraysUtilities.checkArraySize(firstElementOfArrayForSplittingIntoPairs.length, 2);
        arraysUtilities.checkArraySize(secondElementOfArrayForSplittingIntoPairs.length, 3);
        return arraysUtilities.searchIdenticalValueInArrays(firstElementOfArrayForSplittingIntoPairs, secondElementOfArrayForSplittingIntoPairs);
    }
}