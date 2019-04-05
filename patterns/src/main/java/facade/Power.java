package facade;

public class Power {
    private boolean power = false;
    public boolean hasPower()
    {
        return power;
    }
    public void powerOn()
    {
        power=true;
    }
    public void powerOff()
    {
        power=false;
    }
}
