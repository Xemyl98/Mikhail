package service;

public class SecondService implements Service {
    public boolean execute() {
        return true;
    }

    @Override
    public String getName() {
        return "Second Service";
    }
}
