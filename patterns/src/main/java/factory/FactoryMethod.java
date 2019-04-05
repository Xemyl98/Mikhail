package factory;

public class FactoryMethod {
    public  WatchMaker getMarkerByName(String maker)
    {
        if(maker.equals("Digital")) {
            return new DigitalWatchMaker();
        }
        else if(maker.equals("Rome"))
            return new RomeWatchMaker();
        throw new RuntimeException("Not Supported Line Of Watch "+maker);
    }
}
