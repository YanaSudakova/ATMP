package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftsPage extends BasicPage {

    private static final String URL = "https://mail.google.com/mail/u/0/#drafts";
    public static final String DRAFTS_HEADER_MESSAGE = "You don't have any saved drafts.\n" +
            "Saving a draft allows you to keep a message you aren't ready to send yet.";
    @FindBy(css = "span.Dj")
    private WebElement draftsCounter;

    @FindBy(xpath = "//div[@class='Cp']/div/table/tbody/tr")
    private List<WebElement> draftMessages;

    @FindBy(css = "td.TC")
    private WebElement draftsHeader;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(URL);
    }

    public void openDraft() {
        waitForElementToBeVisible(draftMessages.get(0));
        draftMessages.get(0).click();
    }

    public boolean isDraftPresent() {
        wait.until(d -> !draftMessages.isEmpty());
        waitForElementToBeClickable(draftMessages.get(0));
        return draftMessages.get(0).isDisplayed();
    }

    public String getDraftsHeaderText() {
        waitForElementToBeVisible(draftsHeader);
        return draftsHeader.getText();
    }
}
