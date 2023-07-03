package com.epam.atmp.test;

import com.epam.atmp.driver.DriverSingleton;
import com.epam.atmp.page.GoogleCloudHomePage;
import com.epam.atmp.page.GoogleCloudPricingCalculatorPage;
import com.epam.atmp.page.GoogleCloudSearchResultsPage;
import com.epam.atmp.page.YopMailPage;
import com.epam.atmp.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected GoogleCloudHomePage homePage;
    protected GoogleCloudSearchResultsPage searchResultsPage;
    protected GoogleCloudPricingCalculatorPage calculatorPage;
    protected YopMailPage yopMailPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
        initializePages();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

    public void initializePages() {
        homePage = new GoogleCloudHomePage(driver);
        searchResultsPage = new GoogleCloudSearchResultsPage(driver);
        calculatorPage = new GoogleCloudPricingCalculatorPage(driver);
        yopMailPage = new YopMailPage(driver);
    }
}
