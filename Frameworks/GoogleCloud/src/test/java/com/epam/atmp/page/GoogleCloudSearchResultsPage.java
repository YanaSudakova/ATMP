package com.epam.atmp.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchResultsPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(GoogleCloudSearchResultsPage.class);
    @FindBy(linkText = "Google Cloud Pricing Calculator")
    private WebElement calculatorLink;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage selectCalculatorLink() {
        LOGGER.info("Selecting 'Google Cloud Pricing Calculator' link");
        waitForElementToBeClickable(calculatorLink);
        calculatorLink.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}