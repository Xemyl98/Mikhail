package singleton;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    private static final int NUMBER = 1;
    private static Singleton singleton = Singleton.getInstance();

    @BeforeClass
    public static void before() {
        singleton.setNumber(NUMBER);
    }

    @Test
    public void singletonNumberPositiveTest() {
        assertEquals(NUMBER, Singleton.getInstance().getNumber());
    }

    @Test
    public void singletonObjectPositiveTest() {
        assertEquals(singleton, Singleton.getInstance());
    }

    @Test
    public void singletonNumberNegativeTest() {
        assertNotEquals(10, Singleton.getInstance().getNumber());
    }

    @Test
    public void singletonObjectNegativeTest() {
        assertNotEquals(new Thread(), Singleton.getInstance());
    }

    @Test
    public void singletonNullObjectNegativeTest() {
        assertNotEquals(null, Singleton.getInstance());
    }
}