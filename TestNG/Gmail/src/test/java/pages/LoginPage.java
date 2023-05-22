package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage {

    private static final String URL = "https://accounts.google.com/InteractiveLogin";

    @FindBy(id = "identifierId")
    private WebElement emailField;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    @FindBy(id = "password")
    private WebElement passwordField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public LoginPage login(String email, String password) {
        emailField.sendKeys(email);
        nextButton.click();
        passwordField.sendKeys(password);
        nextButton.click();
        return this;
    }

}
