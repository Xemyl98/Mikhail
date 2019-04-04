package builder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class CarTest {
    private Car car;

    @Before
    public void setUp() {
    }

    @Test
    public void CarBuilderWithAllParameters() {
        car=new CarBuilder().buildBrand("myBrand").buildSpeed(150).buildTransmission("Auto").build();
        assertEquals("Car [brand=myBrand transmission =Auto maxSpeed =150]",car.toString());
    }
    @Test
    public void CarBuilderWithoutBrand() {
        car=new CarBuilder().buildSpeed(150).buildTransmission("Auto").build();
        assertEquals("Car [brand=Default transmission =Auto maxSpeed =150]",car.toString());
    }
    @Test
    public void CarBuilderWithoutSpeed() {
        car=new CarBuilder().buildBrand("myBrand").buildTransmission("Manual").build();
        assertEquals("Car [brand=myBrand transmission =Manual maxSpeed =100]",car.toString());
    }
    @Test
    public void CarBuilderWithoutAllParameters() {
        car=new CarBuilder().build();
        assertEquals("Car [brand=Default transmission =Manual maxSpeed =100]",car.toString());
    }
}