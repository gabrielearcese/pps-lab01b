package e1;

public abstract class AbstractBankAccount implements BankAccount {

    protected CoreBankAccount base;

    public AbstractBankAccount(int initialBalance) {
        this.base = new CoreBankAccount(initialBalance);
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public final void withdraw(int amount) {
        if (!canWithdraw(amount)) {
            throw new IllegalStateException("Saldo insufficiente per prelevare " + amount);
        }
        base.withdraw(modifyAmount(amount));
    }

    protected abstract boolean canWithdraw(int amount);
    protected abstract int modifyAmount(int amount);
}
