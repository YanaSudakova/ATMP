package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MailTest {

    private static final String EMAIL = "webdrivertestngjava@gmail.com";
    private static final String PASSWORD = "dg4VDqXw38iFBhs";
    private static final String SUBJECT = "Webdriver - " + getTimeStamp();
    private static final String MESSAGE = "Hi from Webdriver - " + getTimeStamp();

    private WebDriver driver;
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private ComposeMailPage composeMailPage;
    private DraftsPage draftsPage;
    private SentMailPage sentMailPage;
    private LogOffPage logOffPage;

    @DataProvider(name = "validEmails")
    public Object[][] validEmailsProvider() {
        return new Object[][]{
                {new String[]{"damok57280@introace.com", "pefara6648@goflipa.com", "pogec27763@goflipa.com",
                        "kehevi9847@introace.com", "riwil28368@mevori.com"}},
        };
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

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    @Test(priority = 1, description = "Login to the mail box.")
    public void login() {
        loginPage.open();
        InboxPage inboxPage = loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(inboxPage.isInboxDisplayed(), "Login was not successful!");
    }

    @Test(dataProvider = "validEmails", priority = 2,
            description = "Create draft message and verify that it is saved")
    public void createAndVerifyDraftMessage(String[] validEmails) {
        String email = getRandomEmail(validEmails);
        SoftAssert softAssert = new SoftAssert();

        inboxPage.openNewMail();
        composeMailPage.createMail(email, SUBJECT, MESSAGE);
        composeMailPage.closeMail();
        draftsPage.open();
        softAssert.assertTrue(draftsPage.isDraftPresent(), "Draft message not found in 'Drafts' folder.");

        draftsPage.openDraft();
        String actualEmail = composeMailPage.getEmail();
        softAssert.assertEquals(actualEmail, email, "Incorrect addressee in draft message.");
        String subject = composeMailPage.getSubject();
        softAssert.assertEquals(subject, SUBJECT, "Incorrect subject in draft message.");
        String message = composeMailPage.getMessage();
        softAssert.assertEquals(message, MESSAGE, "Incorrect body in draft message.");
        composeMailPage.closeMail();
        softAssert.assertAll();
    }

    @Test(dataProvider = "validEmails", priority = 3, description = "Create and send mail")
    public void CreateAndSendMail(String[] validEmails) {
        String email = getRandomEmail(validEmails);

        inboxPage.openNewMail();
        composeMailPage.createMail(email, SUBJECT, MESSAGE);
        composeMailPage.sendMail();
        sentMailPage.open();
        Assert.assertTrue(sentMailPage.isSentMailPresent(), "Sent mail not found.");
    }

    @Test(priority = 4, description = "Log off")
    public void logOff() {
        logOffPage.logOff();
        Assert.assertTrue(logOffPage.isLoggedOff(), "User is not logged off.");
    }

    private static String getTimeStamp() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    private String getRandomEmail(String[] validEmails) {
        Random random = new Random();
        int index = random.nextInt(validEmails.length);
        return validEmails[index];
    }
}
