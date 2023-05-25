package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends BasicPage {
    private static final String URL = "https://mail.google.com/mail/u/0/#drafts";
    private static final String DRAFTS_HEADER_MESSAGE = "You don't have any saved drafts.\n" +
            "Saving a draft allows you to keep a message you aren't ready to send yet.";
    @FindBy(css = "span.Dj")
    private WebElement draftsCounter;

    @FindBy(xpath = "//div[@class='Cp']/div/table/tbody/tr[1]")
    private WebElement draftMessage;

    @FindBy(css = "td.TC")
    private WebElement draftsHeader;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(URL);
    }

    public void openDraft() {
        waitForElementToBeVisible(draftMessage);
        draftMessage.click();
    }

    public boolean isDraftPresent() {
        waitForElementToBeClickable(draftMessage);
        return draftMessage.isDisplayed();
    }

    public String getDraftsHeaderText() {
        waitForElementToBeVisible(draftsHeader);
        return draftsHeader.getText();
    }

    public String getDraftsHeaderMessage() {
        return DRAFTS_HEADER_MESSAGE;
    }
}
