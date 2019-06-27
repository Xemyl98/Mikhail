package facade;

public class Power {
    private boolean computerPower = false;

    public boolean hasPower() {
        return computerPower;
    }

    public void powerOn() {
        computerPower = true;
    }

    public void powerOff() {
        computerPower = false;
    }
}
