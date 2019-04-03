package tasks.arrays;

import utility.arrays.ArraysUtilities;

class ArrayTask {

/*    private ArraysUtilities arraysUtilities;
     ArrayTask()
     {
         arraysUtilities=new ArraysUtilities();
     }*/
    int[][] moveZerosToTheEndOfTheArrayRow(int[][] arrayToSortByZero) {
        ArraysUtilities arraysUtilities = new ArraysUtilities();
        arraysUtilities.checkForAUninitializedArrayInput(arrayToSortByZero);
        arraysUtilities.checkForAIncorrectSizeOfArray(arrayToSortByZero.length, arrayToSortByZero[0].length, 5, 6);
        return arraysUtilities.getAnArrayOfMovingTheZeroToEndOfTheLine(arrayToSortByZero);
    }

    int[] findEqualsAmountsInArrays(int[] firstElementOfArrayForSplittingIntoPairs, int[] secondElementOfArrayForSplittingIntoPairs) {
        ArraysUtilities arraysUtilities = new ArraysUtilities();
        arraysUtilities.checkForAUninitializedArrayInput(firstElementOfArrayForSplittingIntoPairs);
        arraysUtilities.checkForAUninitializedArrayInput(secondElementOfArrayForSplittingIntoPairs);
        arraysUtilities.checkForAIncorrectSizeOfArray(firstElementOfArrayForSplittingIntoPairs.length, 2);
        arraysUtilities.checkForAIncorrectSizeOfArray(secondElementOfArrayForSplittingIntoPairs.length, 3);
        return arraysUtilities.searchForIdenticalValuesInArrays(firstElementOfArrayForSplittingIntoPairs, secondElementOfArrayForSplittingIntoPairs);
    }
}