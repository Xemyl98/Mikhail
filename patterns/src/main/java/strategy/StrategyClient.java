package strategy;

public class StrategyClient {

    Sorting strategy;
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public int[] executeStrategy(int[]array)
    {
      return   strategy.sort(array);
    }
}
