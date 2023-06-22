package com.epam.atmp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private static final String NUMBER_OF_INSTANCES = "4";

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
        logDebug("Switching to frame");
        driver.switchTo().frame(mainFrame);
        driver.switchTo().frame(myFrame);
        return this;
    }

    public GoogleCloudPricingCalculatorPage activateComputeEngine() {
        logAction("Activating Compute Engine");
        waitForElementToBeClickable(computeEngineTab);
        computeEngineTab.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        logAction("Clicking 'Add to Estimate' button");
        addToEstimateButtons.get(0).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage emailEstimate() {
        logAction("Clicking 'Email Estimate' button");
        emailEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterEmail(String email) {
        switchToPreviousTab();
        switchToFrame();
        logAction("Entering email: " + email);
        emailInput.sendKeys(email);
        return this;
    }

    public GoogleCloudPricingCalculatorPage sendEmail() {
        logAction("Clicking 'Send Email' button");
        sendEmailButton.click();
        return this;
    }

    public String getEstimatedCostInCalculator() {
        switchToPreviousTab();
        switchToFrame();
        logDebug("Getting estimated cost from calculator");
        waitForElementToBeVisible(estimatedCostValue);
        String numericValue = estimatedCostValue.getText().replaceAll("[^0-9.]", "");
        return numericValue;
    }
}
