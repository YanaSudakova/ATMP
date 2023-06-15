package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftsPage extends BasicPage {

    private static final String URL = "https://mail.google.com/mail/u/0/#drafts";

    @FindBy(css = "span.Dj")
    private WebElement draftsCounter;

    @FindBy(xpath = "//div[@class='Cp']/div/table/tbody/tr")
    private List<WebElement> draftMails;

    @FindBy(xpath = "//span[@role='checkbox']")
    private List<WebElement> selectAllDraftsCheckboxes;

    @FindBy(css = "div.T-I.J-J5-Ji.aFh.T-I-ax7.mA")
    private WebElement discardDraftsButton;

    @FindBy(xpath = "//div[@class='J-N-JX aDE aDD']")
    private WebElement archiveOption;

    @FindBy(css = "span.bAq")
    private WebElement archivedMessage;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(URL);
    }

    public void openFirstDraft() {
        waitForElementToBeVisible(draftMails.get(0));
        draftMails.get(0).click();
    }

    public boolean isFirstDraftPresent() {
        try {
            wait.until(d -> !draftMails.isEmpty());
            waitForElementToBeClickable(draftMails.get(0));
            return draftMails.get(0).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void discardDrafts() {
        selectAllDraftsCheckboxes.get(1).click();
        waitForElementToBeClickable(discardDraftsButton);
        discardDraftsButton.click();
    }

    public void archiveFirstDraft() {
        Actions actions = new Actions(driver);
        waitForElementToBeVisible(draftMails.get(0));
        actions.contextClick(draftMails.get(0)).perform();
        archiveOption.click();
    }

    public String getArchiveMessageText() {
        return archivedMessage.getText();
    }
}
