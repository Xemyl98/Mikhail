package userinterface;

import audio.old.SoundCapture;
import constant.PathToFile;
import exception.InvalidArgumentException;
import model.account.AdminList;
import model.account.UserList;
import model.system.System;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {
    private static ArrayList<Double> arrayList;
    private static Map<Integer, ArrayList<Double>> samples = new HashMap<>();
    private static PersonalUserAccount personalUserAccount;
    private static PersonalAdminAccount personalAdminAccount;
    private User user;
    private Admin admin;
    private System system;

    @BeforeClass
    public static void beforeClass() {
        arrayList = new ArrayList<>();
        arrayList.add(1.9);
        arrayList.add(2.0);
        samples.put(samples.size() + 1, arrayList);
    }

    @Before
    public void setUp() throws InvalidArgumentException {
        system = new System();
        admin = AdminList.getAdminById(1);
        personalAdminAccount = admin.getPersonalAdminAccount();
        personalAdminAccount.createNewAdminAccount("new", "ad", "with", "pass");
        user = system.createUser("Mikhail", "Yolkin", "login", "password");
        personalUserAccount = user.getPersonalUserAccount();
        personalUserAccount.addSampleVoice(arrayList);
    }

    @After
    public void after() {
        SampleVoice.clearAllSample();
        UserList.removeAllUsers();
        AdminList.removeAllAdmins();
    }

    @Test
    public void positiveSampleTest() {
        assertEquals(samples, SampleVoice.getSamples());
    }

    @Test
    public void userNameTest() {
        assertEquals(user.getName(), UserList.getUser(1).getName());
    }

    @Test
    public void createNewAdmin() {
        assertEquals("new", AdminList.getAdminById(2).getName());
    }

    @Test(expected = InvalidArgumentException.class)
    public void positiveAuthorisationTest() throws InvalidArgumentException {
        user = system.createUser("Mikhail", "Yolkin", "login", "password");
        assertTrue(system.authorisationWithLoginAndPassword("login", "password"));
    }

    @Test
    public void negativeAuthorisationTest() {
        assertFalse(system.authorisationWithLoginAndPassword("no", "content"));
    }

    @Test
    public void test() throws Exception {
        File file = new File(PathToFile.PATH_TO_OUTPUT_FILE);
        SoundCapture soundCapture = new SoundCapture();
        assertEquals("f", soundCapture.extractFeatureFromFileByteArray(file));
    }
}
