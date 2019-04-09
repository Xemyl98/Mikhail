package utility.strings;

import tasks.exceptions.InvalidArgumentException;

public class StringUtilities {


    public void validationOfString(String inputText) {
        stringIsUninitialized(inputText);
        stringIsEmpty(inputText);
    }

    private void stringIsUninitialized(String inputText) {
        if (inputText == null)
            throw new NullPointerException();
    }

    private void stringIsEmpty(String inputText) {
        if (inputText.length() == 0 && inputText.equals(""))
            throw new NullPointerException();
    }

    public String removeSpacesInString(String inputText) {
        for (int i = 0; i < inputText.length(); i++) {
            if (inputText.charAt(i) == ' ') {
                inputText = getSubstringWithoutSpace(inputText, i);
                i--;
            }
        }
        return inputText;
    }

    public void lengthOfTwoLineIsSame(String sampleLine, String stringToCompare) throws InvalidArgumentException {
        if (sampleLine.length() != stringToCompare.length())
            throw new InvalidArgumentException(sampleLine.length() + "!=" + stringToCompare.length());
    }

    public String searchMatchesWithCyclicShift(String sampleLine, String stringToCompare) {
        for (int i = 0; i < stringToCompare.length(); i++)
            if (!stringToCompare.equals(sampleLine))
                stringToCompare = stringToCompare.charAt(stringToCompare.length() - 1) + stringToCompare.substring(0, stringToCompare.length() - 1);
            else
                return stringToCompare;
        return null;
    }

    private String getSubstringWithoutSpace(String inputText, int indexOfSpace) {
        if (indexOfSpace == inputText.length() - 1)
            inputText = getWord(inputText, indexOfSpace);
        else {
            inputText = getWord(inputText, indexOfSpace) + inputText.substring(indexOfSpace + 1);
        }
        return inputText;
    }

    private String getWord(String inputString, int index) {
        return inputString.substring(0, index);
    }

}
