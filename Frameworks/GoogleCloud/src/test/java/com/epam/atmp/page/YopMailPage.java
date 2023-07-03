package com.epam.atmp.page;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopMailPage extends AbstractPage {

    private static final String URL = "https://yopmail.com/";
    private static final Logger LOGGER = LogManager.getLogger(YopMailPage.class);
    @FindBy(xpath = "//a[@title='Generate a random email address']")
    private WebElement randomEmailButton;
    @FindBy(xpath = "//script[contains(text(), 'login=')]")
    private WebElement emailValue;
    @FindBy(xpath = "//span[contains(text(), 'Check Inbox')]")
    private WebElement checkInboxButton;
    @FindBy(xpath = "//div[contains(text(), 'Google Cloud Price Estimate')]")
    private WebElement priceEstimateEmail;
    @FindBy(xpath = "//iframe")
    private WebElement iFrame;
    @FindBy(xpath = "//iframe[@name='ifmail']")
    private WebElement mailIframe;
    @FindBy(xpath = "//h2[contains(., 'Estimated Monthly Cost:')]")
    private WebElement estimatedMonthlyCostValue;

    public YopMailPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        LOGGER.info("Opening YopMail page: " + URL);
        openNewTab();
        open(URL);
    }

    public String getEmailAddress() {
        LOGGER.info("Generating random email address");
        waitForElementToBeClickable(randomEmailButton);
        randomEmailButton.click();
        String generatedEmail = getEmailAttributeValue() + "@yopmail.com";
        return generatedEmail;
    }

    public String getEmailAttributeValue() {
        LOGGER.info("Getting email attribute value");
        waitForElementToBePresent(By.xpath("//script[contains(text(), 'login=')]"));
        String scriptContent = emailValue.getAttribute("innerHTML");
        String emailValue = scriptContent.substring(scriptContent.indexOf("login='") + 7);
        emailValue = emailValue.substring(0, emailValue.indexOf("';"));
        return emailValue;
    }

    public void checkInbox() {
        LOGGER.info("Checking inbox");
        switchToLatestTab();
        scrollToElement(checkInboxButton);
        checkInboxButton.click();
    }

    public void openPriceEstimateEmail() {
        LOGGER.info("Opening price estimate email");
        waitForEmailToBeReceived(10);
    }

    public void waitForEmailToBeReceived(int timeoutInSeconds) {
        LOGGER.info("Waiting for email to be received");
        long endTime = System.currentTimeMillis() + (timeoutInSeconds * 1000L);
        while (System.currentTimeMillis() < endTime) {
            refreshPage();
            if (isEmailReceived()) {
                return;
            }
        }
    }

    public boolean isEmailReceived() {
        LOGGER.info("Checking if email is received");
        try {
            driver.switchTo().frame(iFrame);
            driver.findElement(By.xpath("//div[contains(text(), 'Google Cloud Price Estimate')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public String getEstimatedCostInEmail() {
        LOGGER.info("Getting estimated cost in email");
        driver.switchTo().frame(mailIframe);
        waitForElementToBeVisible(estimatedMonthlyCostValue);
        return StringUtils.getDigits(estimatedMonthlyCostValue.getText());
    }
}
