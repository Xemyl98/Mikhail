package userinterface;

import model.account.AdminList;
import model.account.UserList;

public class PersonalAdminAccount {

    Admin admin;

    public PersonalAdminAccount(Admin admin) {
        this.admin = admin;
        AdminList.setAdmin(admin);
    }

    public void createNewAdminAccount(String name, String surname, String login, String password) {
        new Admin(name, surname, login, password);
    }

    public void createNewUser(String name, String surname, String login, String password) {
        new User(name, surname, login, password);
    }

    public void removeUser(int id) {
        UserList.removeUserById(id);
    }

    public void removeUser(User user) {
        UserList.removeUser(user);
    }
}
