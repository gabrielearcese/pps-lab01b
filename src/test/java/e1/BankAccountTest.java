package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    public static final int DEPOSIT_1000 = 1000;
    public static final int INITIAL_BALANCE = 0;
    public static final int MONEY_1000 = 1000;
    public static final int WITHDRAW_200 = 200;
    public static final int WITHDRAW_1200 = 1200;
    public static final int MONEY_800 = 800;
    public static final int WITHDRAW_10 = 10;
    public static final int WITHDRAW_1600 = 1600;
    public static final int WITHDRAW_1500 = 1500;
    public static final int GOLD_ACCOUNT_MAX_OVERDRAFT = 500;
    public static final int MONEY_799 = 799;
    public static final int MONEY_900 = 900;
    public static final int MONEY_990 = 990;
    private BronzeAccount bronzeAccount;
    private SilverBankAccount account;
    private GoldBankAccount goldAccount;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount();
        this.goldAccount = new GoldBankAccount();
        this.bronzeAccount = new BronzeAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_1000);
        assertEquals(MONEY_1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT_1000);
        this.account.withdraw(WITHDRAW_200);
        assertEquals(MONEY_799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT_1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(WITHDRAW_1200));
    }

    @Test
    public void testGoldWithdraw(){
        this.goldAccount.deposit(DEPOSIT_1000);
        this.goldAccount.withdraw(WITHDRAW_200);
        assertEquals(goldAccount.getBalance(), MONEY_800);
    }

    @Test
    public void testGoldCanWithdrawMoreThanAvailable(){
        this.goldAccount.deposit(DEPOSIT_1000);
        this.goldAccount.withdraw(WITHDRAW_1500);
        assertTrue(goldAccount.getBalance()>=-GOLD_ACCOUNT_MAX_OVERDRAFT);
    }

    @Test
    public void testBronzeWithdrawWithoutFee(){
        this.bronzeAccount.deposit(DEPOSIT_1000);
        this.bronzeAccount.withdraw(WITHDRAW_10);
        assertEquals(bronzeAccount.getBalance(), MONEY_990);
    }

    @Test
    public void testBronzeWithdrawWithFee(){
        this.bronzeAccount.deposit(DEPOSIT_1000);
        this.bronzeAccount.withdraw(WITHDRAW_200);
        assertEquals(bronzeAccount.getBalance(), MONEY_799);
    }

    @Test
    public void testBronzeCannotWithdrawMoreThanAvailable(){
        this.bronzeAccount.deposit(DEPOSIT_1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(WITHDRAW_1200));
    }
}
