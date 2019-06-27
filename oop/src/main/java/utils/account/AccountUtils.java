package utils.account;

import model.account.UserList;

public class AccountUtils {
    public static boolean userAccountIsExist(String login, String password) {
        for (int i : UserList.getAllUsers().keySet())
            if (login.equals(UserList.getUser(i).getLogin()) && password.equals(UserList.getUser(i).getPassword()))
                return true;

        return false;
    }

    public static boolean userLoginIsExist(String login) {
        for (int i : UserList.getAllUsers().keySet())
            if (login.equals(UserList.getUser(i).getLogin()))
                return true;
        return false;
    }
}
