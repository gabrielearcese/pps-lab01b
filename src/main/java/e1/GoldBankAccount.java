package e1;

public class GoldBankAccount implements BankAccount{

    public static final int GOLD_AMOUNT_OVERDRAFT = 500;

    private CoreBankAccount base = new CoreBankAccount(INITIAL_BALANCE);

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + GOLD_AMOUNT_OVERDRAFT < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
