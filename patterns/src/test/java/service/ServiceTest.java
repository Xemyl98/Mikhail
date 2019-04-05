package service;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServiceTest {
    private static Service firstService;
    private static Service secondService;

    @BeforeClass
    public static void beforeClass() {
        firstService = ServiceLocator.getService("First Service");
    }

    @Test
    public void getFirstServiceName() {
        assertEquals("First Service", firstService.getName());
    }

    @Test
    public void firstServiceExecuteTest() {
        assertTrue(firstService.execute());
    }

    @Test(expected = NullPointerException.class)
    public void nonexistentServiceTest() {
        firstService = ServiceLocator.getService("Nonexistent Service");
    }
}