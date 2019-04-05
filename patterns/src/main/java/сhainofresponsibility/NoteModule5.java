package сhainofresponsibility;

public class NoteModule5 extends NoteModule {
    String takeMoney(Money money) {
        int countNode=money.getSum()/Note.R5;
        int remind=money.getSum()%Note.R5;
        if(countNode>0)
            ATM.setPayoutResult("Issued "+countNode+" bills in denominations of "+Note.R5);
        if(remind>0&&next!=null)
            return next.takeMoney(new Money(remind));
        else
            return ATM.getPayoutResult().toString();
    }
}
