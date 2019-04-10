package chainofresponsibility;

public class Money {
    private int sum;
    public Money(int sum)
    {
        setSum(sum);
    }
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        if(sum>=5&&sum<=5000&&sum%Note.R5==0)
            this.sum=sum;
        else
            throw new RuntimeException("The sum must be no more than 1000 and a multiple of 5");
    }
}
