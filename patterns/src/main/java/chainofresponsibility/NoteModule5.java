package chainofresponsibility;

public class NoteModule5 extends NoteModule {
    String takeMoney(Money money) {
        int countNode = money.getSum() / Note.R5;
        ATM.setPayoutResult("Issued " + countNode + " bills in denominations of " + Note.R5);
        return ATM.getPayoutResult().toString();
    }
}
