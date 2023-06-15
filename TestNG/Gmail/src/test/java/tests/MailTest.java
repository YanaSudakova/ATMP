package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class MailTest {

    private static final String EMAIL = "webdrivertestngjava@gmail.com";
    private static final String PASSWORD = "dg4VDqXw38iFBhs";
    private static final String SUBJECT = "Webdriver - " + getTimeStamp();
    private static final String MESSAGE = "Hi from Webdriver - " + getTimeStamp();
    private static final String ARCHIVED_CONFIRMATION = "Conversation archived.";

    private WebDriver driver;
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private ComposeMailPage composeMailPage;
    private DraftsPage draftsPage;
    private SentPage sentPage;
    private LogOffPage logOffPage;

    @DataProvider(name = "validEmails")
    public Object[][] validEmailsProvider() {
        return new Object[][]{
                {new String[]{"damok57280@introace.com", "pefara6648@goflipa.com", "pogec27763@goflipa.com",
                        "kehevi9847@introace.com", "riwil28368@mevori.com"}},
        };
    }

    @DataProvider(name = "searchKeywords")
    public Object[][] searchKeywordsProvider() {
        return new Object[][]{
                {"starred"},
                {"snoozed"},
                {"imp"},
                {"sent"},
                {"draft"}
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException{
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setPlatform(Platform.ANY);
        capability.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);

        initializePages();
        login();
        assertLoginPage();
    }

    private void initializePages(){
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);
        composeMailPage = new ComposeMailPage(driver);
        draftsPage = new DraftsPage(driver);
        sentPage = new SentPage(driver);
        logOffPage = new LogOffPage(driver);
    }

    private void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        inboxPage = loginPage.login(EMAIL, PASSWORD);
    }

    private void assertLoginPage(){
        Assert.assertTrue(inboxPage.isInboxDisplayed(), "Login was not successful!");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String pageTitle = (String) jsExecutor.executeScript("return document.title;");
        Assert.assertTrue(pageTitle.contains("Gmail"), "Page title does not contain 'Gmail'.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        logOff();
        driver.quit();
    }

    private void logOff() {
        logOffPage = new LogOffPage(driver);
        logOffPage.waitForLogoutAlert();
        logOffPage.logOff();
        Assert.assertTrue(logOffPage.isLoggedOff(), "User is not logged off.");
    }

    @Test(dataProvider = "validEmails", description = "Create draft message, verify and archive.")
    public void createAndVerifyDraftMessage(String[] validEmails) {
        String email = getRandomEmail(validEmails);
        SoftAssert softAssert = new SoftAssert();

        draftsPage.open();
        if ((draftsPage.isFirstDraftPresent())) {
            draftsPage.discardDrafts();
        }

        inboxPage.openNewMail();
        composeMailPage.createMail(email, SUBJECT, MESSAGE);
        composeMailPage.closeMail();

        softAssert.assertTrue(draftsPage.isFirstDraftPresent(),
                "Draft message not found in 'Drafts' folder.");

        draftsPage.openFirstDraft();
        String actualEmail = composeMailPage.getEmailValue();
        softAssert.assertEquals(actualEmail, email, "Incorrect addressee in draft message.");
        String subject = composeMailPage.getSubject();
        softAssert.assertEquals(subject, SUBJECT, "Incorrect subject in draft message.");
        String message = composeMailPage.getMessage();
        softAssert.assertEquals(message, MESSAGE, "Incorrect body in draft message.");
        composeMailPage.closeMail();
        softAssert.assertAll();
        draftsPage.archiveFirstDraft();
        String archiveMessageText = draftsPage.getArchiveMessageText();
        Assert.assertEquals(archiveMessageText, ARCHIVED_CONFIRMATION,
                "Incorrect archive message.");

    }

    @Test(dataProvider = "validEmails", description = "Create and send mail")
    public void createAndSendMail(String[] validEmails) {
        String email = getRandomEmail(validEmails);

        sentPage.open();
        if ((sentPage.isFirstSentMailPresent())) {
            sentPage.deleteSentMails();
        }

        inboxPage.openNewMail();
        composeMailPage.createMail(email, SUBJECT, MESSAGE);

        composeMailPage.sendMail();
        Assert.assertTrue(sentPage.isFirstSentMailPresent(), "Sent mail not found.");
    }

    @Test(dataProvider = "searchKeywords", description = "Search mail and check URL")
    public void checkURLChangesOnSearch(String keyword) {
        inboxPage.searchMail(keyword);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains(keyword.toLowerCase()));
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(keyword.toLowerCase()),
                "URL does not contain the expected keyword: ");
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
