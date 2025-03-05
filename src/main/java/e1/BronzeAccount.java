package e1;

public class BronzeAccount extends AbstractBankAccount {

    private static final int WITHDRAW_100 = 100;

    public BronzeAccount() {
        super(INITIAL_BALANCE);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return this.getBalance() >= amount;
    }

    @Override
    protected int modifyAmount(int amount) {
        return (amount < WITHDRAW_100) ? amount : amount + 1;
    }
}
