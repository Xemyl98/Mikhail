package userinterface;

import model.person.Person;

/**
 * @author Mikhail Yolkin
 * @version 1.0
 * @since 2019-04-11
 */
public class User extends Person {


    private PersonalUserAccount personalUserAccount;

    public User(String name, String surname, String login, String password) {
        setName(name);
        setName(surname);
        setLogin(login);
        setPassword(password);
        personalUserAccount = new PersonalUserAccount(User.this);
    }

    public PersonalUserAccount getPersonalUserAccount() {
        return personalUserAccount;
    }


}
