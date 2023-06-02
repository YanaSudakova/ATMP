package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftsPage extends BasicPage {

    private static final String URL = "https://mail.google.com/mail/u/0/#drafts";

    @FindBy(css = "span.Dj")
    private WebElement draftsCounter;

    @FindBy(xpath = "//div[@class='Cp']/div/table/tbody/tr")
    private List<WebElement> draftMails;

    @FindBy(xpath = "//span[@role='checkbox']")
    private List<WebElement> selectAllDraftsCheckbox;


    @FindBy(css = "div.T-I.J-J5-Ji.aFh.T-I-ax7.mA")
    private WebElement discardDraftsButton;

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
        wait.until(d -> !draftMails.isEmpty());
        waitForElementToBeClickable(draftMails.get(0));
        return draftMails.get(0).isDisplayed();
    }

    public void discardDrafts() {
        selectAllDraftsCheckbox.get(1).click();
        waitForElementToBeClickable(discardDraftsButton);
        discardDraftsButton.click();
    }
}
