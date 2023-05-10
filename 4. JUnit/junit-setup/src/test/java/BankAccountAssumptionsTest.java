import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest {
    @Test
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500,0);
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
        assertTrue(bankAccount.isActive());
    }
}
