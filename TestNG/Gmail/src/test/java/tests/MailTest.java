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
    private SentPage sentPage;
    private LogOffPage logOffPage;

    @DataProvider(name = "validEmails", parallel = true)
    public Object[][] validEmailsProvider() {
        return new Object[][]{
                {new String[]{"damok57280@introace.com", "pefara6648@goflipa.com", "pogec27763@goflipa.com",
                        "kehevi9847@introace.com", "riwil28368@mevori.com"}},
        };
    }

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = createChromeDriver();
        login();
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        logOff();
        driver.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);
        composeMailPage = new ComposeMailPage(driver);
        draftsPage = new DraftsPage(driver);
        sentPage = new SentPage(driver);
        logOffPage = new LogOffPage(driver);
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    private void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        inboxPage = loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(inboxPage.isInboxDisplayed(), "Login was not successful!");
    }

    private void logOff() {
        logOffPage = new LogOffPage(driver);
        logOffPage.logOff();
        Assert.assertTrue(logOffPage.isLoggedOff(), "User is not logged off.");
    }

    @Test(dataProvider = "validEmails", description = "Create draft message and verify that it is saved")
    public void createAndVerifyDraftMessage(String[] validEmails) {
        String email = getRandomEmail(validEmails);
        SoftAssert softAssert = new SoftAssert();

        draftsPage.open();
        if ((draftsPage.isFirstDraftPresent())){
            draftsPage.discardDrafts();
        }

        inboxPage.openNewMail();
        composeMailPage.createMail(email, SUBJECT, MESSAGE);
        composeMailPage.closeMail();

        softAssert.assertTrue(draftsPage.isFirstDraftPresent(), "Draft message not found in 'Drafts' folder.");

        draftsPage.openFirstDraft();
        String actualEmail = composeMailPage.getEmailValue();
        softAssert.assertEquals(actualEmail, email, "Incorrect addressee in draft message.");
        String subject = composeMailPage.getSubject();
        softAssert.assertEquals(subject, SUBJECT, "Incorrect subject in draft message.");
        String message = composeMailPage.getMessage();
        softAssert.assertEquals(message, MESSAGE, "Incorrect body in draft message.");
        composeMailPage.closeMail();
        softAssert.assertAll();
    }

    @Test(dataProvider = "validEmails", description = "Create and send mail")
    public void createAndSendMail(String[] validEmails) {
        String email = getRandomEmail(validEmails);

        sentPage.open();
        if ((sentPage.isFirstSentMailPresent())){
            sentPage.deleteSentMails();
        }

        inboxPage.openNewMail();
        composeMailPage.createMail(email, SUBJECT, MESSAGE);
        composeMailPage.sendMail();
        sentPage.open();
        Assert.assertTrue(sentPage.isFirstSentMailPresent(), "Sent mail not found.");
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
