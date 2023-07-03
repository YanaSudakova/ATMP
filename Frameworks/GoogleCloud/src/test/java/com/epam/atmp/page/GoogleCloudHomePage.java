package com.epam.atmp.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String URL = "https://cloud.google.com/";
    private static final Logger LOGGER = LogManager.getLogger(GoogleCloudHomePage.class);
    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        LOGGER.info("Opening Google Cloud home page: " + URL);
        open(URL);
    }

    public GoogleCloudSearchResultsPage searchForTerm(String term) {
        LOGGER.info("Waiting for search input to be clickable");
        waitForElementToBeClickable(searchInput);
        LOGGER.info("Performing search with term: " + term);
        searchInput.sendKeys(term);
        searchInput.submit();
        LOGGER.info("Returning Google Cloud search results page");
        return new GoogleCloudSearchResultsPage(driver);
    }
}
