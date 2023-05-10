import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class BankAccountConditionalTest {
    @Test
    @EnabledOnOs({OS.MAC})
    public void testMac() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_19})
    public void testJRE() {

    }

    @Test
    @DisabledOnJre(JRE.JAVA_19)
    public void testNoJRE19() {

    }
}
