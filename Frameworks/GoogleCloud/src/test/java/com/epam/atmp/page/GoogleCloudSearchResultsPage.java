package com.epam.atmp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchResultsPage extends AbstractPage {

    private static final String LINK = "Google Cloud Pricing Calculator";

    @FindBy(linkText = "Google Cloud Pricing Calculator")
    private WebElement calculatorLink;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage selectCalculatorLink() {
        logAction("Selecting 'Google Cloud Pricing Calculator' link");
        waitForElementToBeClickable(calculatorLink);
        calculatorLink.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}