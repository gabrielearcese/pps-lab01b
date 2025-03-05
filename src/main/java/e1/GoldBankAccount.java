package e1;

public class GoldBankAccount extends AbstractBankAccount {

    private static final int GOLD_AMOUNT_OVERDRAFT = 500;

    public GoldBankAccount() {
        super(INITIAL_BALANCE);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return this.getBalance() + GOLD_AMOUNT_OVERDRAFT >= amount;
    }

    @Override
    protected int modifyAmount(int amount) {
        return amount;
    }
}
