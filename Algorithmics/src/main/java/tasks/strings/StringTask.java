package tasks.strings;

import tasks.exceptions.InvalidArgumentException;
import utils.strings.StringUtils;

class StringTask {
    String removeSpacesInTheEnteringSpace(String textToRemoveSpace) {
        StringUtils.validationOfString(textToRemoveSpace);
        return StringUtils.removeSpacesInString(textToRemoveSpace);
    }

    String cyclicShiftStringSearch(String sampleLine, String stringToCompare) throws InvalidArgumentException {
        StringUtils.validationOfString(sampleLine);
        StringUtils.validationOfString(stringToCompare);
        StringUtils.lengthOfTwoLineIsSame(sampleLine, stringToCompare);
        return StringUtils.searchMatchesWithCyclicShift(sampleLine, stringToCompare);
    }
}
