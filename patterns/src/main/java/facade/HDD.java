package facade;

public class HDD {
    public String copyFromDVD(DVDRom dvdRom, Power power) {
        if (power.hasPower()) {
            if (dvdRom.hasData())
                return "Copy Successfully";
            else
                return "Copy Failed";
        } else
            return "Power is off";
    }
}
