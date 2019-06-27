package service;

public class InitialContext {

    public Object lookup(String executeCheck) {
        if (executeCheck.equalsIgnoreCase("First Service"))
            return new FirstService();
        else if (executeCheck.equalsIgnoreCase("Second Service"))
            return new SecondService();
        return null;
    }
}
