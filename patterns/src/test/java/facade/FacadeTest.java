package facade;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class FacadeTest {
    private Facade facade;
    @Before
    public void setUp()
    {
         facade=new Facade();
    }
    @Test
    public void positivePowerWithPositiveData()
    {
        assertEquals("Copy Successfully",facade.copyFromDVDToHDD(true,true));
    }
    @Test
    public void positivePowerWithNegativeData()
    {
        assertEquals("Copy Failed",facade.copyFromDVDToHDD(true,false));
    }
    @Test
    public void negativePowerWithPositiveData()
    {
        assertEquals("Power is off",facade.copyFromDVDToHDD(false,true));
    }
    @Test
    public void negativePowerWithNegativeData()
    {
        assertEquals("Power is off",facade.copyFromDVDToHDD(false,false));
    }
}