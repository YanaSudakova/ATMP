package com.epam.atmp.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudSearchTest extends CommonConditions {

    private static final String SEARCH_TERM = "Google Cloud Platform Pricing Calculator";

    @Test(description = "Smoke test: Search for a calculator and perform estimate without GPU calculation.")
    public void performSmokeTest() {
        performPriceEstimate(false);
    }

    @Test(description = "Regression test: Search for a calculator and perform estimate with GPU calculation.")
    public void performRegressionTest() {
        performPriceEstimate(true);
    }

    private void performPriceEstimate(boolean withGpu) {
        homePage.open();
        homePage.searchForTerm(SEARCH_TERM);
        searchResultsPage.selectCalculatorLink();
        calculatorPage.switchToFrame();
        calculatorPage.activateComputeEngine();

        if (withGpu) {
            pricingCalculationCreator.createPricingCalculationWithGPU();
        } else {
            pricingCalculationCreator.createPricingCalculationWithoutGpu();
        }

        calculatorPage.addToEstimate();
        calculatorPage.emailEstimate();
        yopMailPage.open();
        calculatorPage.enterEmail(yopMailPage.getEmailAddress());
        calculatorPage.sendEmail();
        yopMailPage.checkInbox();
        yopMailPage.openPriceEstimateEmail();
        Assert.assertEquals(yopMailPage.getEstimatedCostInEmail(), calculatorPage.getEstimatedCostInCalculator(),
                "Prices are not equal!");
    }
}