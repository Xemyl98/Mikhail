package factory;

public class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
