import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

//for all tests in class
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAccount bankAccount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void testDepositTimeoutAnnotation(BankAccount bankAccount) {

    }
}
