package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SentPage extends BasicPage {

    private static final String URL = "https://mail.google.com/mail/u/0/#sent";

    @FindBy(xpath = "//div[@class='Cp']/div/table/tbody/tr")
    private List<WebElement> sentMails;

    @FindBy(xpath = "//span[@role='checkbox']")
    private List<WebElement> selectAllSentCheckboxes;

    @FindBy(xpath = "//div[@aria-label='Delete']")
    private WebElement deleteMailsButton;

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(URL);
    }

    public boolean isFirstSentMailPresent() {
        try {
            wait.until(d -> !sentMails.isEmpty());
            waitForElementToBeClickable(sentMails.get(0));
            return sentMails.get(0).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void deleteSentMails() {
        wait.until(d -> !selectAllSentCheckboxes.isEmpty());
        selectAllSentCheckboxes.get(1).click();
        waitForElementToBeClickable(deleteMailsButton);
        deleteMailsButton.click();
    }
}
