package userinterface;

import model.account.UserList;

import java.util.ArrayList;

/**
 * @author Mikhail Yolkin
 * @version 1.0
 * @since 2019-04-11
 */
public class PersonalUserAccount {

    private PersonalUserAccount personalUserAccount;
    private User user;

    public PersonalUserAccount(User user) {
        this.user = user;
        UserList.setUser(user);
        SampleVoice.setPersonalUserAccount(PersonalUserAccount.this);
    }

    public void changeLogin(String newLogin) {
        user.setLogin(newLogin);
    }

    public void changePassword(String password) {

        user.setPassword(password);
    }


    public void addSampleVoice(ArrayList<Double> sample) {
        SampleVoice.setSamples(sample);
    }

    public void removeSampleVoice(int id) {
        SampleVoice.removeSampleVoice(id);
    }

    public void restoreAccess() {//TODO описать

    }

}
