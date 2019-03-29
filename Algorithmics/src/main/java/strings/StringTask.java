package strings;

public class StringTask {
    public String removingSpaces(String inputString) {
        try {
            if (inputString.length() == 0 && inputString.equals(""))
                throw new NullPointerException();
            for (int i = 0; i < inputString.length(); i++) {

                if (inputString.charAt(i) == ' ' && inputString.length() == 1)
                    throw new NullPointerException();
                else if (inputString.charAt(i) == ' ') {
                    if (i == inputString.length() - 1)
                        inputString = inputString.substring(0, i);
                    else {
                        inputString = inputString.substring(0, i) + inputString.substring(i + 1, inputString.length());
                        i--;
                    }
                }
            }
        } catch (NullPointerException ex) {
            return null;
        }
        return inputString;
    }
}
