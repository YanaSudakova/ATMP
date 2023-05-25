package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOffPage extends BasicPage {

    @FindBy(css = "a.gb_d.gb_3a.gb_v")
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

    public void logOff() {
        accountIcon.click();
        driver.switchTo().frame(iFrame);
        waitForElementToBeClickable(signOutButton);
        signOutButton.click();
    }

    public boolean isLoggedOff() {
        waitForElementToBeVisible(chooseAccountElement);
        return chooseAccountElement.isDisplayed();
    }
}
