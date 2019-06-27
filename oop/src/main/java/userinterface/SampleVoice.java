package userinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SampleVoice {
    private static PersonalUserAccount personalUserAccount;

    private static Map<Integer, ArrayList<Double>> samples = new HashMap<>();

    public static void setSamples(ArrayList<Double> sample) {
        samples.put(samples.size() + 1, sample);
    }

    public static Map<Integer, ArrayList<Double>> getSamples() {
        return samples;
    }

    public static void clearAllSample() {
        samples.clear();
    }

    public static void removeSampleVoice(int id) {
        samples.remove(id);
    }

    public static void setPersonalUserAccount(PersonalUserAccount account) {
        personalUserAccount = account;
    }

    public static PersonalUserAccount getPersonalUserAccount() {
        return personalUserAccount;
    }


}
