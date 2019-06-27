package model.account;

import userinterface.User;

import java.util.HashMap;
import java.util.Map;

public class UserList {
    private static Map<Integer, User> users = new HashMap<>();

    public static void setUser(User user) {
        users.put(users.size() + 1, user);
    }

    public static User getUser(int id) {
        return users.get(id);
    }

    public static void removeUserById(int id) {
        users.remove(id);
    }

    public static void removeUser(User user) {
        for (int i : users.keySet())
            if (users.get(i).equals(user)) {
                users.remove(i);
                break;
            }
    }

    public static Map<Integer, User> getAllUsers() {
        return users;
    }

    public static void removeAllUsers() {
        users.clear();
    }
}
