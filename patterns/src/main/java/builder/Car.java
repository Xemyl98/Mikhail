package builder;
public class Car {
    String brand;
    String transmission;
    int maxSpeed;
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    @Override
    public String toString()
    {
        return "Car [brand="+brand+" transmission ="+transmission+" maxSpeed ="+maxSpeed+"]";
    }

}
