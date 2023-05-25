package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentMailPage extends BasicPage {
    private static final String URL = "https://mail.google.com/mail/u/0/#sent";

    @FindBy(xpath = "//div[@class='Cp']/div/table/tbody/tr[1]")
    private WebElement sentMail;

    public SentMailPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(URL);
    }

    public boolean isSentMailPresent() {
        waitForElementToBeClickable(sentMail);
        return sentMail.isDisplayed();
    }
}
