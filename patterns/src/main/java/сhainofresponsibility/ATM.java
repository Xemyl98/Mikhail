package сhainofresponsibility;

public class ATM {
    private static StringBuilder payoutResult=new StringBuilder();

    public static StringBuilder getPayoutResult() {
        return payoutResult;
    }

    public static void setPayoutResult(String operationResult) {
        payoutResult.append(operationResult+"\n");
    }
    public void clearIssue()
    {
        payoutResult=new StringBuilder();
    }
}
