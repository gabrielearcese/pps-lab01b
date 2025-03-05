package e1;

public class SilverBankAccount extends AbstractBankAccount {

    public SilverBankAccount() {
        super(INITIAL_BALANCE);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return this.getBalance() >= amount;
    }

    @Override
    protected int modifyAmount(int amount) {
        return amount + 1;
    }
}
