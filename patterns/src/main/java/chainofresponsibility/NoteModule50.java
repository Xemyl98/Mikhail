package chainofresponsibility;

public class NoteModule50 extends NoteModule {
    String takeMoney(Money money) {
        int countNode = money.getSum() / Note.R50;
        int remind = money.getSum() % Note.R50;
        if (countNode > 0)
            ATM.setPayoutResult("Issued " + countNode + " bills in denominations of " + Note.R50);
        if (remind > 0 && next != null)
            return next.takeMoney(new Money(remind));
        else
            return ATM.getPayoutResult().toString();
    }
}
