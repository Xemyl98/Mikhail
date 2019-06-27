package userinterface;

import model.person.Person;

public class Admin extends Person {
    private PersonalAdminAccount personalAdminAccount;

    public Admin(String name, String surname, String login, String password) {
        setName(name);
        setSurname(surname);
        setLogin(login);
        setPassword(password);
        personalAdminAccount = new PersonalAdminAccount(getAdmin());
    }

    public PersonalAdminAccount getPersonalAdminAccount() {
        return personalAdminAccount;
    }

    public Admin getAdmin() {
        return Admin.this;
    }
}
