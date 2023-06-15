package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasicPage {

    @FindBy(xpath = "//a[text()='Inbox']")
    private WebElement inbox;

    @FindBy(xpath = "//div[text()='Compose']")
    private WebElement composeButton;

    @FindBy(xpath = "//input[@aria-label='Search mail']")
    private WebElement searchField;

    @FindBy(css = "svg.Xy")
    private WebElement settingsOption;

    @FindBy(xpath = "//span[@class='ST']")
    private WebElement conversationViewOption;

    @FindBy(xpath = "//button[@name='save']")
    private WebElement reloadButton;

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

    public void searchMail(String keyword) {
        Actions actions = new Actions(driver);
        actions.click(searchField);
        actions.sendKeys(keyword);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
    }

    public void scrollIntoElement() {
        waitForElementToBeClickable(settingsOption);
        settingsOption.click();
        waitForElementToBeVisible(conversationViewOption);
        executeJavaScript("arguments[0].scrollIntoView();", conversationViewOption);
        conversationViewOption.click();
        waitForElementToBeClickable(reloadButton);
        reloadButton.click();
    }
}
