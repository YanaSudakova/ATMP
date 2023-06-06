package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LogOffPage extends BasicPage {

    @FindBy(css = "a[href*='accounts.google.com/SignOutOptions']")
    private WebElement accountIcon;

    @FindBy(css = "iframe[name='account']")
    private WebElement iFrame;

    @FindBy(xpath = "//div[@class='SedFmc' and text()='Sign out']")
    private WebElement signOutButton;

    @FindBy(css = "span[jsslot='']")
    private WebElement chooseAccountElement;

    public LogOffPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logOff() {
        accountIcon.click();
        driver.switchTo().frame(iFrame);
        waitForElementToBeClickable(signOutButton);
        signOutButton.click();
        return new LoginPage(driver);
    }

    public boolean isLoggedOff() {
        waitForElementToBeVisible(chooseAccountElement);
        return chooseAccountElement.isDisplayed();
    }

    public void waitForLogoutAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (TimeoutException e) {
        }
    }
}
