package com.epam.atmp.page;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(GoogleCloudPricingCalculatorPage.class);

    @FindBy(xpath = "//iframe")
    private WebElement mainFrame;

    @FindBy(xpath = "//*[@id='myFrame']")
    private WebElement myFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineTab;

    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')]")
    private List<WebElement> addToEstimateButtons;

    @FindBy(xpath = "//button[@title='Email Estimate']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmailButton;

    @FindBy(css = "h2.md-flex.ng-binding.ng-scope")
    private WebElement estimatedCostValue;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage switchToFrame() {
        LOGGER.debug("Switching to frame");
        driver.switchTo().frame(mainFrame);
        driver.switchTo().frame(myFrame);
        return this;
    }

    public GoogleCloudPricingCalculatorPage activateComputeEngine() {
        LOGGER.info("Activating Compute Engine");
        waitForElementToBeClickable(computeEngineTab);
        computeEngineTab.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        LOGGER.info("Clicking 'Add to Estimate' button");
        addToEstimateButtons.get(0).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage emailEstimate() {
        LOGGER.info("Clicking 'Email Estimate' button");
        emailEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterEmail(String email) {
        switchToPreviousTab();
        switchToFrame();
        LOGGER.info("Entering email: " + email);
        emailInput.sendKeys(email);
        return this;
    }

    public GoogleCloudPricingCalculatorPage sendEmail() {
        LOGGER.info("Clicking 'Send Email' button");
        sendEmailButton.click();
        return this;
    }

    public String getEstimatedCostInCalculator() {
        switchToPreviousTab();
        switchToFrame();
        LOGGER.debug("Getting estimated cost from calculator");
        waitForElementToBeVisible(estimatedCostValue);
        return StringUtils.getDigits(estimatedCostValue.getText());
    }
}