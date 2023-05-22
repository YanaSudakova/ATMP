package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ComposeMailPage;
import pages.LoginPage;
import pages.SentMailPage;

public class MailTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ComposeMailPage composeMailPage;
    private SentMailPage sentMailPage;

    private static final String EMAIL = "webdrivertestngjava@gmail.com";
    private static final String PASSWORD = "dg4VDqXw38iFBhs";

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = createChromeDriver();
    }

    @Test (description = "Login to the mail box.")
            public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(EMAIL, PASSWORD);
    }

//    @AfterMethod (alwaysRun = true)
//    public void browserTearDown(){
//        driver.quit();
//    }

    private static WebDriver createChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
