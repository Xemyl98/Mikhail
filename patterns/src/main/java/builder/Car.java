package builder;

public class Car {
    private String brand;
    private String transmission;
    private int maxSpeed;

    void setBrand(String brand) {
        this.brand = brand;
    }

    void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [brand = " + brand + "; transmission = " + transmission + "; maxSpeed = " + maxSpeed + "]";
    }

}
