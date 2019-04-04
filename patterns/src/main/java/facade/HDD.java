package facade;

public class HDD {
    public String copyFromDVD(DVDRom dvdRom) {
        if (dvdRom.hasData()) {
            return "Copy Successfully";
        }
        else
            return "Copy Failed";
    }
}
