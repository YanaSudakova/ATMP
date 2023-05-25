package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class MailTest {
    private static final String EMAIL = "webdrivertestngjava@gmail.com";
    private static final String PASSWORD = "dg4VDqXw38iFBhs";
    private static final String TO = "damok57280@introace.com";
    private static final String SUBJECT = "Webdriver";
    private static final String MESSAGE = "Hi from Webdriver";
    private WebDriver driver;
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private ComposeMailPage composeMailPage;
    private DraftsPage draftsPage;
    private SentMailPage sentMailPage;
    private LogOffPage logOffPage;

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = createChromeDriver();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);
        composeMailPage = new ComposeMailPage(driver);
        draftsPage = new DraftsPage(driver);
        sentMailPage = new SentMailPage(driver);
        logOffPage = new LogOffPage(driver);
    }

    @Test(priority = 1, description = "Login to the mail box.")
    public void login() {
        loginPage.open();
        InboxPage inboxPage = loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(inboxPage.isInboxDisplayed(), "Login was not successful!");
    }

    @Test(priority = 2, description = "Create a message abd save as draft")
    public void createDraftMessage() {
        inboxPage.openNewMail();
        composeMailPage.createDraftMail(TO, SUBJECT, MESSAGE);
        draftsPage.open();
        Assert.assertTrue(draftsPage.isDraftPresent(), "Draft message not found in 'Drafts' folder.");
    }

    @Test(priority = 3, description = "Verify draft message")
    public void verifyDraftMessage() {
        draftsPage.openDraft();
        String email = composeMailPage.getEmail();
        Assert.assertEquals(email, TO, "Incorrect addressee in draft message.");
        String subject = composeMailPage.getSubject();
        Assert.assertEquals(subject, SUBJECT, "Incorrect subject in draft message.");
        String message = composeMailPage.getMessage();
        Assert.assertEquals(message, MESSAGE, "Incorrect body in draft message.");
    }

    @Test(priority = 4, description = "Send draft")
    public void sendDraftMessage() {
        composeMailPage.sendMail();
        Assert.assertEquals(draftsPage.getDraftsHeaderText(), draftsPage.getDraftsHeaderMessage(),
                "Drafts header text is not as expected.");
    }

    @Test(priority = 5, description = "Verify sent mail")
    public void verifySentMail() {
        sentMailPage.open();
        Assert.assertTrue(sentMailPage.isSentMailPresent(), "Sent mail not found in 'Drafts' folder.");
    }

    @Test(priority = 6, description = "Log off")
    private void logOff() {
        logOffPage.logOff();
        Assert.assertTrue(logOffPage.isLoggedOff(), "User is not logged off.");
    }
}
