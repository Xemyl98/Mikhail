package tasks.arrays.utility;

import utility.CommonUtilities;

import java.util.ArrayList;

public class ArraysUtilities {

    private ArraysUtilities() {
    }

    public static int[] getOneDimensionalArray() {
        return oneDimensionalArray;
    }

    public static void setOneDimensionalArray(int[] oneDimensionalArray) {
        ArraysUtilities.oneDimensionalArray = oneDimensionalArray;
    }

    private static int[] oneDimensionalArray;

    public static int[][] getTwoDimensionalArray() {
        return twoDimensionalArray;
    }

    public static void setTwoDimensionalArray(int[][] twoDimensionalArray) {
        ArraysUtilities.twoDimensionalArray = twoDimensionalArray;
    }

    private static int[][] twoDimensionalArray;


    public static void testEmptyArray(int[] oneDimensionalArray) {
        if (oneDimensionalArray == null)
            throw new NullPointerException();
    }

    public static void testEmptyArray(int[][] twoDimensionalArray) {
        if (twoDimensionalArray == null)
            throw new NullPointerException();
    }

    public static void testOnCorrectSizeOfArray(int row, int minRow) {
        if (row < minRow)
            throw new ArrayIndexOutOfBoundsException();
    }

    public static void testOnCorrectSizeOfArray(int row, int column, int minRow, int minColumn) {
        if (row < minRow || column < minColumn)
            throw new ArrayIndexOutOfBoundsException();
    }

    public static int[] searchForIdenticalValuesInArrays(int[] firstArray, int[] secondArray) {
        firstArray = getTheSumOfAllPairsInTheArray(firstArray);
        secondArray = getTheSumOfEachTripleInTheArray(secondArray);
        ArrayList<Integer> resultingArray = new ArrayList<>();
        for (int i = 0; i < firstArray.length; i++)
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j])
                    if (!resultingArray.contains(firstArray[i]))
                        resultingArray.add(firstArray[i]);
            }
        return convertArrayListToInteger(resultingArray);
    }

    public static void getAnArrayOfMovingTheZeroToEndOfTheLine() {
        for (int i = 0; i < twoDimensionalArray.length; i++)
            for (int j = 0; j < twoDimensionalArray[0].length - 1; j++)
                if (twoDimensionalArray[i][j] == 0)
                    movingZeroElementToEndLineOfArray(twoDimensionalArray, i, j, twoDimensionalArray[0].length);
    }

    private static int[] convertArrayListToInteger(ArrayList<Integer> list) {
        int[] resultConverting = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            resultConverting[i] = list.get(i);
        return resultConverting;
    }

    private static int[] getTheSumOfAllPairsInTheArray(int[] firstArray) {

        int n = 0;
        int[] sum = new int[getNumberOfPossiblePermutations(firstArray.length, 2)];
        for (int i = 0; i < getNumberOfPossiblePermutations(firstArray.length, 2) - 1; i++)
            for (int j = i + 1; j < firstArray.length; j++) {
                sum[n] = getSumOfElementsInTheArray(firstArray[i], firstArray[j]);
                n++;
            }
        return sum;
    }


    private static int[] getTheSumOfEachTripleInTheArray(int[] secondArray) {
        int n = 0;
        int[] sum = new int[getNumberOfPossiblePermutations(secondArray.length, 3)];
        for (int i = 0; i < getNumberOfPossiblePermutations(secondArray.length, 3) - 2; i++)
            for (int j = i + 1; j < secondArray.length - 1; j++)
                for (int k = j + 1; k < secondArray.length; k++) {
                    sum[n] = getSumOfElementsInTheArray(secondArray[i], secondArray[j], secondArray[k]);
                    n++;
                }
        return sum;
    }

    private static int getSumOfElementsInTheArray(int firstElement, int secondElement) {
        return firstElement + secondElement;
    }

    private static int getSumOfElementsInTheArray(int firstElement, int secondElement, int third) {
        return firstElement + secondElement + third;
    }

    private static int getNumberOfPossiblePermutations(int length, int numberOfCombination) {
        int lengthFactorial = CommonUtilities.calculateFactorial(length);
        int numberOfCombinationFactorial = CommonUtilities.calculateFactorial(numberOfCombination);
        return lengthFactorial / (numberOfCombinationFactorial * CommonUtilities.calculateFactorial(length - numberOfCombination));
    }

    private static void movingZeroElementToEndLineOfArray(int[][] inputArray, int i, int j, int countElementsOnArray) {
        for (int k = j + 1; k < countElementsOnArray; k++) {
            if (inputArray[i][k] != 0) {
                movementOfNeighboringElements(i, j, k);
                break;
            }
        }
    }

    private static void movementOfNeighboringElements(int i, int j, int k) {
        int temp = twoDimensionalArray[i][k];
        twoDimensionalArray[i][k] = twoDimensionalArray[i][j];
        twoDimensionalArray[i][j] = temp;
    }
}
