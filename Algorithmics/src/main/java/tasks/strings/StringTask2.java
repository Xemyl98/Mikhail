package tasks.strings;

import tasks.exceptions.utility.InvalidArgumentException;
import tasks.strings.utility.StringUtilities;

public class StringTask2 {

    public String CyclicShiftStringLookup(String line1,String line2) throws InvalidArgumentException {
        StringUtilities.testOnNullString(line1);
        StringUtilities.testOnEmptyString(line1);
        StringUtilities.testOnNullString(line2);
        StringUtilities.testOnEmptyString(line2);
        StringUtilities.equalSizeCheck(line1,line2);
        return StringUtilities.cyclicShiftSearch(line1,line2);
    }

}
