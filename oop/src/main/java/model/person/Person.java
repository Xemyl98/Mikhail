package model.person;

/**
 * @author Mikhail Yolkin
 * @version 1.0
 * @since 2019-04-11
 */
public class Person {

    private String name;
    private String surname;
    private String login;
    private String password;

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
