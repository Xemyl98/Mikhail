package strategy;

public class StrategyClient {

    Sorting strategy;
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[]array)
    {
        strategy.sort(array);
    }
}
