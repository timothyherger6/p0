import org.junit.Test;
import org.junit.Assert;

public class BankAccountTest {

    @Test
    public void DepositTest() {
        BankAccountApp bank1 = new BankAccountApp("Tim", 12345, "Checking", 0.00);
        bank1.Deposit(100.00);
        double expected = 100.00;
        Assert.assertTrue(expected == bank1.getBalance());
    }

    @Test
    public void WithdrawTest() {
        BankAccountApp bank2 = new BankAccountApp("Bob", 14567, "Checking", 200.00 );
        bank2.Withdraw(50.00);
        double exp = 150.00;
        Assert.assertTrue(exp == bank2.getBalance());
    }
}
