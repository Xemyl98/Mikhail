package utility.arrays;

import java.util.ArrayList;

public class ArraysUtilities {


    public void checkForAUninitializedArrayInput(int[] oneDimensionalArray) {
        if (oneDimensionalArray == null)
            throw new NullPointerException("not initialized array passed");
    }

    public void checkForAUninitializedArrayInput(int[][] twoDimensionalArray) {
        if (twoDimensionalArray == null)
            throw new NullPointerException("not initialized array passed");
    }

    public void checkArraySize(int arraySize, int minimumArraySize) {
        if (arraySize < minimumArraySize)
            throw new ArrayIndexOutOfBoundsException();
    }

    public void checkArraySize(int arraySize, int secondDimensionArraySize, int minimumArraySize, int minimumSecondDimensionArraySize) {
        if (arraySize < minimumArraySize || secondDimensionArraySize < minimumSecondDimensionArraySize)
            throw new ArrayIndexOutOfBoundsException();
    }

    public int[] searchIdenticalValueInArrays(int[] arrayForSplittingIntoPairs, int[] arrayForSplittingIntoThrees) {
        arrayForSplittingIntoPairs = getTheSumOfAllPairsInTheArray(arrayForSplittingIntoPairs);
        arrayForSplittingIntoThrees = getTheSumOfEachTripleOfValuesInTheArray(arrayForSplittingIntoThrees);
        ArrayList<Integer> matchesOfArraysWithoutDuplicates = new ArrayList<>();
        for (int i = 0; i < arrayForSplittingIntoPairs.length; i++)
            for (int j = 0; j < arrayForSplittingIntoThrees.length; j++) {
                if (arrayForSplittingIntoPairs[i] == arrayForSplittingIntoThrees[j]&&(!matchesOfArraysWithoutDuplicates.contains(arrayForSplittingIntoPairs[i])))
                        matchesOfArraysWithoutDuplicates.add(arrayForSplittingIntoPairs[i]);
            }
        return convertArrayListToInteger(matchesOfArraysWithoutDuplicates);
    }

    public int[][] getAnArrayOfMovingZeroElementsToEndOfLine(int[][] arrayToSortByZero) {
        for (int rowIndex = 0; rowIndex < arrayToSortByZero.length; rowIndex++)
            for (int columnIndex = 0; columnIndex < arrayToSortByZero[0].length - 1; columnIndex++)
                if (arrayToSortByZero[rowIndex][columnIndex] == 0)
                    movingZeroElementToEndLineOfArray(arrayToSortByZero, rowIndex, columnIndex, arrayToSortByZero[0].length);
        return arrayToSortByZero;
    }

    private int[] convertArrayListToInteger(ArrayList<Integer> matchesOfArraysWithoutDuplicates) {
        int[] convertedDataFromArrayListToIntegerArray = new int[matchesOfArraysWithoutDuplicates.size()];
        for (int i = 0; i < matchesOfArraysWithoutDuplicates.size(); i++)
            convertedDataFromArrayListToIntegerArray[i] = matchesOfArraysWithoutDuplicates.get(i);
        return convertedDataFromArrayListToIntegerArray;
    }

    private int[] getTheSumOfAllPairsInTheArray(int[] arrayForSplittingIntoPairs) {

        int n = 0;
        int[] sum = new int[getNumberOfPossiblePermutations(arrayForSplittingIntoPairs.length, 2)];
        for (int i = 0; i < getNumberOfPossiblePermutations(arrayForSplittingIntoPairs.length, 2) - 1; i++)
            for (int j = i + 1; j < arrayForSplittingIntoPairs.length; j++) {
                sum[n] = getSumOfElementsInTheArray(arrayForSplittingIntoPairs[i], arrayForSplittingIntoPairs[j]);
                n++;
            }
        return sum;
    }


    private int[] getTheSumOfEachTripleOfValuesInTheArray(int[] arrayForSplittingIntoThrees) {
        int n = 0;
        int[] sum = new int[getNumberOfPossiblePermutations(arrayForSplittingIntoThrees.length, 3)];
        for (int i = 0; i < getNumberOfPossiblePermutations(arrayForSplittingIntoThrees.length, 3) - 2; i++)
            for (int j = i + 1; j < arrayForSplittingIntoThrees.length - 1; j++)
                for (int k = j + 1; k < arrayForSplittingIntoThrees.length; k++) {
                    sum[n] = getSumOfElementsInTheArray(arrayForSplittingIntoThrees[i], arrayForSplittingIntoThrees[j], arrayForSplittingIntoThrees[k]);
                    n++;
                }
        return sum;
    }

    private int getSumOfElementsInTheArray(int firstElementOfArrayForSplittingIntoPairs, int secondElementOfArrayForSplittingIntoPairs) {
        return firstElementOfArrayForSplittingIntoPairs + secondElementOfArrayForSplittingIntoPairs;
    }

    private int getSumOfElementsInTheArray(int firstElementOfArrayForSplittingIntoPairs, int secondElementOfArrayForSplittingIntoPairs, int thirdElementOfArrayForSplittingIntoPairs) {
        return getSumOfElementsInTheArray(firstElementOfArrayForSplittingIntoPairs, secondElementOfArrayForSplittingIntoPairs) + thirdElementOfArrayForSplittingIntoPairs;
    }

    private int getNumberOfPossiblePermutations(int length, int numberOfCombination) {
        int lengthFactorial = calculateFactorial(length);
        int numberOfCombinationFactorial = calculateFactorial(numberOfCombination);
        return lengthFactorial / (numberOfCombinationFactorial * calculateFactorial(length - numberOfCombination));
    }

    private int calculateFactorial(int numberToCalculate) {
        int calculationResult = 1;
        for (int i = 1; i <= numberToCalculate; i++) {
            calculationResult = calculationResult * i;
        }
        return calculationResult;
    }

    private void movingZeroElementToEndLineOfArray(int[][] arrayToSortByZero, int rowIndex, int columnIndex, int countElementsOnArray) {
        for (int k = columnIndex + 1; k < countElementsOnArray; k++) {
            if (arrayToSortByZero[rowIndex][k] != 0) {
                 movementOfNeighboringElements(arrayToSortByZero, rowIndex, columnIndex, k);
                break;
            }
        }
    }

    private void movementOfNeighboringElements(int[][] arrayToSortByZero, int i, int j, int k) {
        int temp = arrayToSortByZero[i][k];
        arrayToSortByZero[i][k] = arrayToSortByZero[i][j];
        arrayToSortByZero[i][j] = temp;
    }
}
