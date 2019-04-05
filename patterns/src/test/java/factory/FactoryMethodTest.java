package factory;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FactoryMethodTest {
    private static FactoryMethod factoryMethod;
    private static Watch digitalWatch;
    private static Watch romeWatch;
    private static Watch unsupportedWatch;

    @BeforeClass
    public static void beforeClass() {
        factoryMethod = new FactoryMethod();
        WatchMaker watch = factoryMethod.getMarkerByName("Digital");
        digitalWatch = watch.createWatch();
        watch = factoryMethod.getMarkerByName("Rome");
        romeWatch = watch.createWatch();
    }

    @Test(expected = RuntimeException.class)
    public void unsupportedWatchTest() {
        WatchMaker watch = factoryMethod.getMarkerByName("Unsupported watch");
    }

    @Test(expected = RuntimeException.class)
    public void uninitializedWatchTest() {
        WatchMaker watch = factoryMethod.getMarkerByName(null);
    }

    @Test
    public void digitalWatchTest() {
        assertEquals(new Date().toString(), digitalWatch.showTime());
    }

    @Test
    public void romeWatchTest() {
        assertEquals("VII-XX", romeWatch.showTime());
    }

}