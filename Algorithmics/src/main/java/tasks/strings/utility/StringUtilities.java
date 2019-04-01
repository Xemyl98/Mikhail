package tasks.strings.utility;

import tasks.exceptions.utility.InvalidArgumentException;

public class StringUtilities {
    private StringUtilities() {}
    public static String getInputString() {
        return inputString;
    }

    public static void setInputString(String inputString) {
        StringUtilities.inputString = inputString;
    }

    private static String inputString;
    public static void testOnNullString(String string)
    {
        if(string==null)
            throw new NullPointerException();
    }
    public static void testOnEmptyString(String string)
    {
        if (string.length() == 0 && string.equals(""))
            throw new NullPointerException();
    }
    public static void testOnStringOnlyWithSpaces()
    {
        if (inputString.charAt(0) == ' ' && inputString.length() == 1)
            inputString="";
    }
    public static void removingSpacesOnString()
    {
        for (int i = 0; i < inputString.length(); i++) {

            if (inputString.charAt(i) == ' ')
                i=getSubstringWithoutSpace(i);
        }
    }
    public static void equalSizeCheck(String line1,String line2) throws InvalidArgumentException {
        if(line1.length()!=line2.length())
            throw new InvalidArgumentException(line1.length()+"!="+line2.length());
    }
    public static String cyclicShiftSearch(String line1,String line2)
    {
        for(int i=0;i<line1.length();i++)
            if(!line1.equals(line2))
                 line1 = line1.charAt(line1.length() - 1) + line1.substring(0, line1.length() - 1);
            else
                return line1;
        return null;
    }

    private static char[] swapAdjacentElements(char[] line,int i,int j )
    {
        char temp=line[i];
        line[i]=line[j];
        line[j]=temp;
        return line;
    }
    private static int getSubstringWithoutSpace(int indexOfSpace)
    {
        if (indexOfSpace == inputString.length() - 1)
            inputString= getSubstring(indexOfSpace);
        else {
            inputString = getSubstring(indexOfSpace) + inputString.substring(indexOfSpace+1);
            indexOfSpace--;
        }
        return indexOfSpace;
    }
    private static String getSubstring(int i)
    {
        String subInputString=inputString.substring(0,i);
        return subInputString;
    }



}
