package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private static final int DEPOSIT_1000 = 1000;
    private static final int INITIAL_BALANCE = 0;
    private static final int EXPECTED_1000 = 1000;
    private static final int WITHDRAW_200 = 200;
    private static final int WITHDRAW_1200 = 1200;
    private static final int EXPECTED_800 = 800;
    private static final int WITHDRAW_10 = 10;
    private static final int WITHDRAW_1500 = 1500;
    private static final int GOLD_ACCOUNT_MAX_OVERDRAFT = 500;
    private static final int EXPECTED_799 = 799;
    private static final int EXPECTED_990 = 990;
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
        assertEquals(EXPECTED_1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT_1000);
        this.account.withdraw(WITHDRAW_200);
        assertEquals(EXPECTED_799, this.account.getBalance());
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
        assertEquals(goldAccount.getBalance(), EXPECTED_800);
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
        assertEquals(bronzeAccount.getBalance(), EXPECTED_990);
    }

    @Test
    public void testBronzeWithdrawWithFee(){
        this.bronzeAccount.deposit(DEPOSIT_1000);
        this.bronzeAccount.withdraw(WITHDRAW_200);
        assertEquals(bronzeAccount.getBalance(), EXPECTED_799);
    }

    @Test
    public void testBronzeCannotWithdrawMoreThanAvailable(){
        this.bronzeAccount.deposit(DEPOSIT_1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(WITHDRAW_1200));
    }

    @Test
    public void testGoldWithdrawWithoutMoneyOnTheAccount(){
        this.goldAccount.withdraw(WITHDRAW_200);
        assertTrue(goldAccount.getBalance()>=-GOLD_ACCOUNT_MAX_OVERDRAFT);
    }
}
