package facade;

public class Computer {
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    public String copyFromDVDToHDD() {
        dvd.load();
        return hdd.copyFromDVD(dvd);
    }
}
