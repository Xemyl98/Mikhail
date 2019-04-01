package tasks.strings;

import tasks.strings.utility.StringUtilities;

public class StringTask {
    public String removingSpaces(String inputString) {
        StringUtilities.setInputString(inputString);
        StringUtilities.testOnNullString(inputString);
        StringUtilities.testOnEmptyString(inputString);
        StringUtilities.testOnStringOnlyWithSpaces();
        StringUtilities.removingSpacesOnString();
        return StringUtilities.getInputString();
    }
}
