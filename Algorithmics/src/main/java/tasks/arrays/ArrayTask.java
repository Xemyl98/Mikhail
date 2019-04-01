package tasks.arrays;

import tasks.arrays.utility.ArraysUtilities;

public class ArrayTask {
    public int[][] moveZerosToTheEndOfTheArrayRow(int[][] inputArray) {
        ArraysUtilities.setTwoDimensionalArray(inputArray);
        ArraysUtilities.testEmptyArray(inputArray);
        ArraysUtilities.testOnCorrectSizeOfArray(inputArray.length, inputArray[0].length, 5, 6);
        ArraysUtilities.getAnArrayOfMovingTheZeroToEndOfTheLine();
        return ArraysUtilities.getTwoDimensionalArray();
    }

    }