package com.epam.atmp.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        logInfo("Opening Google Cloud home page: " + URL);
        open(URL);
    }

    public GoogleCloudSearchResultsPage searchForTerm(String term) {
        logAction("Waiting for search input to be clickable");
        waitForElementToBeClickable(searchInput);
        logAction("Performing search with term: " + term);
        searchInput.sendKeys(term);
        searchInput.submit();
        logInfo("Returning Google Cloud search results page");
        return new GoogleCloudSearchResultsPage(driver);
    }
}
