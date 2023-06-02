package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
