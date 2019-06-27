package service;

public class FirstService implements Service {

    public boolean execute() {
        return true;
    }

    @Override
    public String getName() {
        return "First Service";
    }
}
