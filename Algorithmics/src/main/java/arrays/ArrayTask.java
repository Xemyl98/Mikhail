package arrays;

public class ArrayTask {
    public int[][] zeroTransferToEndLineOfArray(int[][] inputArray) {

        if (inputArray == null)
            throw new NullPointerException();
        if (inputArray.length != 5 && inputArray[0].length != 6)
            throw new ArrayIndexOutOfBoundsException();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (inputArray[i][j] == 0)
                    movingZeroElementToEndLineOfArray(inputArray, i, j);
        return inputArray;
    }

    private int[][] movingZeroElementToEndLineOfArray(int[][] inputArray, int elementPositionOnLine, int elementPositionOnColumn) {
        for (int k = elementPositionOnColumn + 1; k < 6; k++) {
            if (inputArray[elementPositionOnLine][k] != 0) {
                int temp = inputArray[elementPositionOnLine][k];
                inputArray[elementPositionOnLine][k] = inputArray[elementPositionOnLine][elementPositionOnColumn];
                inputArray[elementPositionOnLine][elementPositionOnColumn] = temp;
                break;
            }
        }
        return inputArray;
    }
}