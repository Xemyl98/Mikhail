package utility.strings;

import tasks.exceptions.InvalidArgumentException;

public class StringUtilities {


    public void checkForCorrectStringInput(String inputString) {
        checkForANullStringInput(inputString);
        checkForAEmptyStringInput(inputString);
    }

    private void checkForANullStringInput(String inputText) {
        if (inputText == null)
            throw new NullPointerException();
    }

    private void checkForAEmptyStringInput(String inputText) {
        if (inputText.length() == 0 && inputText.equals(""))
            throw new NullPointerException();
    }

    public String removingSpacesOnString(String textToRemoveSpace) {
        for (int i = 0; i < textToRemoveSpace.length(); i++) {
            if (textToRemoveSpace.charAt(i) == ' ') {
                textToRemoveSpace = getSubstringWithoutSpace(textToRemoveSpace, i);
                i--;
            }
        }
        return textToRemoveSpace;
    }

    public void checkForEqualSizeOfLines(String sampleLine, String stringToCompare) throws InvalidArgumentException {
        if (sampleLine.length() != stringToCompare.length())
            throw new InvalidArgumentException(sampleLine.length() + "!=" + stringToCompare.length());
    }

    public String searchMatchesByCyclicShift(String sampleLine, String stringToCompare) {
        for (int i = 0; i < stringToCompare.length(); i++)
            if (!stringToCompare.equals(sampleLine))
                stringToCompare = stringToCompare.charAt(stringToCompare.length() - 1) + stringToCompare.substring(0, stringToCompare.length() - 1);
            else
                return stringToCompare;
        return null;
    }

    private String getSubstringWithoutSpace(String inputText, int indexOfSpace) {
        if (indexOfSpace == inputText.length() - 1)
            inputText = getSubstringFromStartToIndex(inputText,indexOfSpace);
        else {
            inputText = getSubstringFromStartToIndex(inputText,indexOfSpace) + inputText.substring(indexOfSpace + 1);
        }
        return inputText;
    }

    private String getSubstringFromStartToIndex(String inputString,int index) {
        return inputString.substring(0,index);
    }

}
