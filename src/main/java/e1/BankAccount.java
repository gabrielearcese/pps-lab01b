package e1;

public interface BankAccount {

    int INITIAL_BALANCE = 0;

    /**
     * amount of money in the bank account
     *
     * @return balance of the bank account
     */
    int getBalance();

    /**
     * amount of money transfered in the account
     *
     * @param amount of money deposited
     */
    void deposit(int amount);

    /**
     *
     * @param amount of money withdrawed
     */
    void withdraw(int amount);
}
