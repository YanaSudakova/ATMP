package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage {

    private static final String URL = "http://mail.google.com";

    @FindBy(id = "identifierId")
    private WebElement emailField;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        navigateTo(URL);
        return this;
    }

    public InboxPage login(String email, String password) {
        waitForElementToBeVisible(emailField);
        emailField.sendKeys(email);
        nextButton.click();
        waitForElementToBeVisible(passwordField);
        passwordField.sendKeys(password);
        waitForElementToBeClickable(nextButton);
        nextButton.click();
        return new InboxPage(driver);
    }
}

