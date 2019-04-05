package сhainofresponsibility;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChainOfResponsibilityTest {
    private static NoteModule500 noteModule500;
    private static StringBuilder correctDataOutput;
    private static StringBuilder issuedFromLastNoteModuleOutput;
    private static ATM atm;

    @BeforeClass
    public static void beforeClass() {
        correctDataOutput = new StringBuilder
                ("Issued 8 bills in denominations of 500\n" +
                        "Issued 1 bills in denominations of 200\n" +
                        "Issued 1 bills in denominations of 20\n" +
                        "Issued 1 bills in denominations of 5\n");
        issuedFromLastNoteModuleOutput = new StringBuilder(
                "Issued 1 bills in denominations of 5\n"
        );
        NoteModule5 noteModule5 = new NoteModule5();
        NoteModule10 noteModule10 = new NoteModule10();
        NoteModule20 noteModule20 = new NoteModule20();
        NoteModule50 noteModule50 = new NoteModule50();
        NoteModule100 noteModule100 = new NoteModule100();
        NoteModule200 noteModule200 = new NoteModule200();
        noteModule500 = new NoteModule500();
        noteModule500.setNextMoneyModule(noteModule200);
        noteModule200.setNextMoneyModule(noteModule100);
        noteModule100.setNextMoneyModule(noteModule50);
        noteModule50.setNextMoneyModule(noteModule20);
        noteModule20.setNextMoneyModule(noteModule10);
        noteModule10.setNextMoneyModule(noteModule5);
    }

    @Before
    public void setUp() {
        atm = new ATM();
    }

    @After
    public void after() {
        atm.clearIssue();
    }

    @Test
    public void correctDataInput() {
        assertEquals(correctDataOutput.toString(), noteModule500.takeMoney(new Money(4225)));
    }

    @Test
    public void issuedFromLastNoteModuleOutputTest() {
        assertEquals(issuedFromLastNoteModuleOutput.toString(), noteModule500.takeMoney(new Money(5)));
    }

    @Test(expected = RuntimeException.class)
    public void inputUnsupportedValueTest() {
        noteModule500.takeMoney(new Money(5500));
    }

}
