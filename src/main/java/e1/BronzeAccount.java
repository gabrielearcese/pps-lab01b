package e1;

public class BronzeAccount implements BankAccount{

    public static final int WITHDRAW_100 = 100;
    private CoreBankAccount base = new CoreBankAccount(INITIAL_BALANCE);

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }else if (amount < WITHDRAW_100) {
            this.base.withdraw(amount);
        }else{
            this.base.withdraw(amount + 1);
        }
    }
}
