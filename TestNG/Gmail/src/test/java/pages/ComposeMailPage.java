package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposeMailPage extends BasicPage {

    @FindBy(css = "[peoplekit-id='BbVjBd']")
    private WebElement toField;

    @FindBy(xpath = "//span[contains(text(), '@')]")
    private WebElement email;

    @FindBy(css = "input[name='subjectbox']")
    private WebElement subjectField;

    @FindBy(css = "div[aria-label='Message Body']")
    private WebElement messageField;

    @FindBy(xpath = "//img[@aria-label='Save & close']")
    private WebElement closeButton;

    @FindBy(xpath = "//div[text()='Send']")
    private WebElement sendButton;

    public ComposeMailPage(WebDriver driver) {
        super(driver);
    }

    public DraftsPage createMail(String to, String subject, String message) {
        waitForElementToBeVisible(toField);
        toField.sendKeys(to);
        subjectField.sendKeys(subject);
        messageField.sendKeys(message);
        return new DraftsPage(driver);
    }

    public DraftsPage closeMail(){
        closeButton.click();
        return new DraftsPage(driver);
    }

    public DraftsPage sendMail() {
        waitForElementToBeClickable(sendButton);
        sendButton.click();
        return new DraftsPage(driver);
    }

    public String getEmail() {
        waitForElementToBeVisible(email);
        return email.getText();
    }

    public String getSubject() {
        waitForElementToBeVisible(subjectField);
        return subjectField.getAttribute("value");
    }

    public String getMessage() {
        waitForElementToBeVisible(messageField);
        return messageField.getText();
    }
}
