package tasks.strings;

import tasks.exceptions.InvalidArgumentException;
import utility.strings.StringUtilities;

class StringTask {
    String removeSpacesInTheEnteringSpace(String textToRemoveSpace,StringUtilities stringUtilities) {
        stringUtilities.validationOfString(textToRemoveSpace);
        return stringUtilities.removeSpacesInString(textToRemoveSpace);
    }

    String cyclicShiftStringSearch(String sampleLine, String stringToCompare,StringUtilities stringUtilities) throws InvalidArgumentException {
        stringUtilities.validationOfString(sampleLine);
        stringUtilities.validationOfString(stringToCompare);
        stringUtilities.lengthOfTwoLineIsSame(sampleLine, stringToCompare);
        return stringUtilities.searchMatchesWithCyclicShift(sampleLine, stringToCompare);
    }
}
