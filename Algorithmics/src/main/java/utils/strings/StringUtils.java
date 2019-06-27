package utils.strings;

import tasks.exceptions.InvalidArgumentException;

public class StringUtils {


    private StringUtils() {
    }

    public static void validationOfString(String inputText) {
        stringIsUninitialized(inputText);
        stringIsEmpty(inputText);
    }

    private static void stringIsUninitialized(String inputText) {
        if (inputText == null) throw new NullPointerException();
    }

    private static void stringIsEmpty(String inputText) {
        if (inputText.length() == 0 && inputText.equals("")) throw new NullPointerException();
    }

    public static String removeSpacesInString(String inputText) {
        String stringWithoutSpaces = inputText;
        for (int i = 0; i < stringWithoutSpaces.length(); i++) {
            if (stringWithoutSpaces.charAt(i) == ' ') {
                stringWithoutSpaces = getSubstringWithoutSpace(stringWithoutSpaces, i);
                i--;
            }
        }
        return stringWithoutSpaces;
    }


    public static String searchMatchesWithCyclicShift(String sampleLine, String stringToCompare) {
        String compareString = stringToCompare;
        for (int i = 0; i < compareString.length(); i++) {
            if (!compareString.equals(sampleLine)) {
                compareString = compareString.charAt(compareString.length() - 1) + compareString.substring(0, compareString.length() - 1);
            } else return compareString;
        }
        return null;
    }

    public static void lengthOfTwoLineIsSame(String sampleLine, String stringToCompare) throws InvalidArgumentException {
        if (sampleLine.length() != stringToCompare.length()) {
            throw new InvalidArgumentException(sampleLine.length() + "!=" + stringToCompare.length());
        }
    }

    private static String getSubstringWithoutSpace(String inputText, int indexOfSpace) {
        if (indexOfSpace == inputText.length() - 1) inputText = getWord(inputText, indexOfSpace);
        else inputText = getWord(inputText, indexOfSpace) + inputText.substring(indexOfSpace + 1);
        return inputText;
    }

    private static String getWord(String inputString, int index) {
        return inputString.substring(0, index);
    }

}
