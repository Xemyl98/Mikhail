package model.account;

import userinterface.Admin;

import java.util.HashMap;
import java.util.Map;

public class AdminList {
    private static Map<Integer, Admin> admins = new HashMap<>();

    public static Map<Integer, Admin> getAdmins() {
        return admins;
    }

    public static void setAdmin(Admin admin) {
        admins.put(admins.size() + 1, admin);
    }

    public static Admin getAdminById(int id) {
        return admins.get(id);
    }

    public static void removeAllAdmins() {
        admins.clear();
    }

}
