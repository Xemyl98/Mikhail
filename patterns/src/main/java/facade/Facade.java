package facade;

public class Facade {
    private DVDRom dvd = new DVDRom();
    private HDD hdd = new HDD();
    private Power power = new Power();

    public String copyFromDVDToHDD(boolean powerOfComputer, boolean dataLoad) {

        if (powerOfComputer)
            power.powerOn();
        else
            power.powerOff();
        if (dataLoad)
            dvd.load();
        else
            dvd.unload();
        return hdd.copyFromDVD(dvd, power);
    }
}
