package utils.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static int[] searchIdenticalValueInArrays(int[] arrayForSplittingIntoPairs, int[] arrayForSplittingIntoThrees) {
        final int[] arrayWithSplittingPairs = getTheSumOfAllPairsInTheArray(arrayForSplittingIntoPairs);
        final int[] arrayWithSplittingThrees = getTheSumOfEachTripleOfValuesInTheArray(arrayForSplittingIntoThrees);
        List<Integer> matchesOfArraysWithoutDuplicates = new ArrayList<>();
        for (int i = 0; i < arrayWithSplittingPairs.length; i++) {
            for (int j = 0; j < arrayWithSplittingThrees.length; j++) {
                if (arrayWithSplittingPairs[i] == arrayWithSplittingThrees[j] && (!matchesOfArraysWithoutDuplicates
                        .contains(arrayWithSplittingPairs[i])))
                    matchesOfArraysWithoutDuplicates.add(arrayWithSplittingPairs[i]);
            }
        }
        return convertArrayListToInteger(matchesOfArraysWithoutDuplicates);
    }

    public static int[][] getArrayOfMovingZeroElementsToEndOfLine(int[][] arrayToSortByZero) {
        for (int rowIndex = 0; rowIndex < arrayToSortByZero.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < arrayToSortByZero[0].length - 1; columnIndex++) {
                if (arrayToSortByZero[rowIndex][columnIndex] == 0) {
                    movingZeroElementToEndLineOfArray(arrayToSortByZero, rowIndex, columnIndex, arrayToSortByZero[0].length);
                }
            }
        }
        return arrayToSortByZero;
    }

    public static void ArrayIsUninitialized(int[] oneDimensionalArray) {
        if (oneDimensionalArray == null) throw new NullPointerException("not initialized array passed");
    }

    public static void ArrayIsUninitialized(int[][] twoDimensionalArray) {
        if (twoDimensionalArray == null) throw new NullPointerException("not initialized array passed");
    }

    public static void checkArraySize(int arraySize, int minimumArraySize) {
        if (arraySize < minimumArraySize) throw new ArrayIndexOutOfBoundsException();
    }

    public static void checkArraySize(int arraySize, int secondDimensionArraySize, int minimumArraySize, int minimumSecondDimensionArraySize) {
        if (arraySize != minimumArraySize || secondDimensionArraySize != minimumSecondDimensionArraySize) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    private static int[] convertArrayListToInteger(List<Integer> matchesOfArraysWithoutDuplicates) {
        int[] convertedDataFromArrayListToIntegerArray = new int[matchesOfArraysWithoutDuplicates.size()];
        for (int i = 0; i < matchesOfArraysWithoutDuplicates.size(); i++) {
            convertedDataFromArrayListToIntegerArray[i] = matchesOfArraysWithoutDuplicates.get(i);
        }
        return convertedDataFromArrayListToIntegerArray;
    }

    private static int[] getTheSumOfAllPairsInTheArray(int[] arrayForSplittingIntoPairs) {
        int n = 0;
        int[] sum = new int[getNumberOfPossiblePermutations(arrayForSplittingIntoPairs.length, 2)];
        for (int i = 0; i < getNumberOfPossiblePermutations(arrayForSplittingIntoPairs.length, 2) - 1; i++) {
            for (int j = i + 1; j < arrayForSplittingIntoPairs.length; j++) {
                sum[n] = getSumOfElementsInTheArray(arrayForSplittingIntoPairs[i], arrayForSplittingIntoPairs[j]);
                n++;
            }
        }
        return sum;
    }


    private static int[] getTheSumOfEachTripleOfValuesInTheArray(int[] arrayForSplittingIntoThrees) {
        int n = 0;
        int[] sum = new int[getNumberOfPossiblePermutations(arrayForSplittingIntoThrees.length, 3)];
        for (int i = 0; i < getNumberOfPossiblePermutations(arrayForSplittingIntoThrees.length, 3) - 2; i++) {
            for (int j = i + 1; j < arrayForSplittingIntoThrees.length - 1; j++) {
                for (int k = j + 1; k < arrayForSplittingIntoThrees.length; k++) {
                    sum[n] = getSumOfElementsInTheArray(arrayForSplittingIntoThrees[i], arrayForSplittingIntoThrees[j], arrayForSplittingIntoThrees[k]);
                    n++;
                }
            }
        }
        return sum;
    }

    private static int getSumOfElementsInTheArray(int firstElementOfArrayForSplittingIntoPairs, int secondElementOfArrayForSplittingIntoPairs) {
        return firstElementOfArrayForSplittingIntoPairs + secondElementOfArrayForSplittingIntoPairs;
    }

    private static int getSumOfElementsInTheArray(int firstElementOfArrayForSplittingIntoPairs, int secondElementOfArrayForSplittingIntoPairs, int thirdElementOfArrayForSplittingIntoPairs) {
        return getSumOfElementsInTheArray(firstElementOfArrayForSplittingIntoPairs, secondElementOfArrayForSplittingIntoPairs) + thirdElementOfArrayForSplittingIntoPairs;
    }

    private static int getNumberOfPossiblePermutations(int length, int numberOfCombination) {
        final int lengthFactorial = calculateFactorial(length);
        final int numberOfCombinationFactorial = calculateFactorial(numberOfCombination);
        return lengthFactorial / (numberOfCombinationFactorial * calculateFactorial(length - numberOfCombination));
    }

    private static int calculateFactorial(int numberToCalculate) {
        int calculationResult = 1;
        for (int i = 1; i <= numberToCalculate; i++) {
            calculationResult = calculationResult * i;
        }
        return calculationResult;
    }

    private static void movingZeroElementToEndLineOfArray(int[][] arrayToSortByZero, int rowIndex, int columnIndex, int countElementsOnArray) {
        for (int k = columnIndex + 1; k < countElementsOnArray; k++) {
            if (arrayToSortByZero[rowIndex][k] != 0) {
                movementOfNeighboringElements(arrayToSortByZero, rowIndex, columnIndex, k);
                break;
            }
        }
    }

    private static void movementOfNeighboringElements(int[][] arrayToSortByZero, int i, int j, int k) {
        final int temp = arrayToSortByZero[i][k];
        arrayToSortByZero[i][k] = arrayToSortByZero[i][j];
        arrayToSortByZero[i][j] = temp;
    }
}
