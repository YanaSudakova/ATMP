package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasicPage {

    @FindBy(xpath = "//a[text()='Inbox']")
    private WebElement inbox;

    @FindBy(xpath = "//div[text()='Compose']")
    private WebElement composeButton;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public ComposeMailPage openNewMail() {
        waitForElementToBeClickable(composeButton);
        composeButton.click();
        return new ComposeMailPage(driver);
    }

    public boolean isInboxDisplayed() {
        waitForElementToBeVisible(inbox);
        return inbox.isDisplayed();
    }

}
