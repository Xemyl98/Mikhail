package model.system;

import exception.InvalidArgumentException;
import model.account.AdminList;
import userinterface.Admin;
import userinterface.User;
import utils.account.AccountUtils;

public class System {

    public System() {
        if (AdminList.getAdmins().isEmpty())
            new Admin("default", "default", "admin", "admin");
    }

    public User createUser(String name, String surname, String login, String password) throws InvalidArgumentException {
        if (AccountUtils.userLoginIsExist(login))
            throw new InvalidArgumentException("Account With this login is exist");
        return new User(name, surname, login, password);
    }

    public boolean authorisationWithLoginAndPassword(String login, String password) {
        return AccountUtils.userAccountIsExist(login, password);
    }


}
