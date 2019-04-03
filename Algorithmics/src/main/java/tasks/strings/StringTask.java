package tasks.strings;

import tasks.exceptions.InvalidArgumentException;
import utility.strings.StringUtilities;

class StringTask {
    String removingSpacesInTheEnteringSpace(String textToRemoveSpace) {
        StringUtilities stringUtilities = new StringUtilities();
        stringUtilities.checkForCorrectStringInput(textToRemoveSpace);
        return stringUtilities.removingSpacesOnString(textToRemoveSpace);
    }

    String cyclicShiftStringLooking(String sampleLine, String stringToCompare) throws InvalidArgumentException {
        StringUtilities stringUtilities = new StringUtilities();
        stringUtilities.checkForCorrectStringInput(sampleLine);
        stringUtilities.checkForCorrectStringInput(stringToCompare);
        stringUtilities.checkForEqualSizeOfLines(sampleLine, stringToCompare);
        return stringUtilities.searchMatchesByCyclicShift(sampleLine, stringToCompare);
    }
}
