package builder;

class CarBuilder {
    private String brand = "Default";
    private String transmission = "Manual";
    private int speed = 100;

    CarBuilder buildBrand(String brand) {
        this.brand = brand;
        return this;
    }

    CarBuilder buildTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    CarBuilder buildSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setBrand(brand);
        car.setTransmission(transmission);
        car.setMaxSpeed(speed);
        return car;
    }
}
