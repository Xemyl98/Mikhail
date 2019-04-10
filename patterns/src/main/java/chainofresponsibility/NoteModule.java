package chainofresponsibility;

public abstract class NoteModule {
    protected NoteModule next;

    abstract String takeMoney(Money money);
    void setNextMoneyModule(NoteModule module)
    {
        next=module;
    }
}
