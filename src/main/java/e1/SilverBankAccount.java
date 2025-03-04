package e1;

public class SilverBankAccount implements BankAccount{

    private CoreBankAccount base = new CoreBankAccount(INITIAL_BALANCE);

    public int getBalance() {
        return this.base.getBalance();
    }

    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + 1);
    }
}
