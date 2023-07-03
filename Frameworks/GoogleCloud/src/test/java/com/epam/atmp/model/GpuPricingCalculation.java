package com.epam.atmp.model;

import com.epam.atmp.service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GpuPricingCalculation extends DefaultPricingCalculation implements PricingCalculation {
    private static final String TESTDATA_GPU_TYPE = "testdata.gpuType";
    private static final String TESTDATA_NUMBER_OF_GPUS = "testdata.numberOfGpus";
    private static final String TESTDATA_LOCAL_SSD = "testdata.localSSD";
    private static final String TESTDATA_COMMITTED_USAGE = "testdata.committedUsage";
    private static final Logger LOGGER = LogManager.getLogger(GpuPricingCalculation.class);
    @FindBy(css = "md-checkbox[ng-model='listingCtrl.computeServer.addGPUs']")
    protected WebElement addGPUsCheckbox;
    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.gpuType']")
    protected WebElement gpuTypeDropdown;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    protected WebElement nvidiaTeslaV100Option;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_P4']")
    protected WebElement nvidiaTeslaP4Option;
    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.gpuCount']")
    protected WebElement numberOfGpusDropdown;
    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='1']]")
    protected WebElement oneOption;
    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='2']]")
    protected WebElement twoOption;
    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.ssd']")
    protected WebElement localSSDDropdown;
    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='2x375 GB']]")
    protected WebElement local2x375Option;
    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='3x375 GB']]")
    protected WebElement local3x375Option;
    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.cud']")
    protected WebElement committedUsageDropdown;
    @FindBy(css = "md-option[id='select_option_134']")
    protected WebElement oneYearOption;
    @FindBy(css = "md-option[id='select_option_135']")
    protected WebElement threeYearsOption;

    public GpuPricingCalculation(WebDriver driver) {
        super(driver);
    }

    @Override
    public void calculate() {
        createPricingCalculationWithoutGpu();
        LOGGER.info("Creating pricing calculation with GPU");
        setGpuType(TestDataReader.getTestData(TESTDATA_GPU_TYPE));
        setNumberOfGpus(TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS));
        setLocalSSD(TestDataReader.getTestData(TESTDATA_LOCAL_SSD));
        setCommittedUsage(TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }

    public void setGpuType(String option) {
        addGPUsCheckbox.click();
        waitForElementToBeVisible(gpuTypeDropdown);
        gpuTypeDropdown.click();
        waitForElementToBeClickable(nvidiaTeslaV100Option);
        if (option.equals("nvidia tesla V100")) {
            nvidiaTeslaV100Option.click();
        } else if (option.equals("nvidia tesla P4")) {
            nvidiaTeslaP4Option.click();
        }
    }

    public void setNumberOfGpus(String option) {
        numberOfGpusDropdown.click();
        waitForElementToBeClickable(oneOption);
        if (option.equals("one")) {
            oneOption.click();
        } else if (option.equals("two")) {
            twoOption.click();
        }
    }

    public void setLocalSSD(String option) {
        localSSDDropdown.click();
        waitForElementToBeClickable(local2x375Option);
        if (option.equals("2x375")) {
            local2x375Option.click();
        } else if (option.equals("3x375")) {
            local3x375Option.click();
        }
    }

    public void setCommittedUsage(String option) {
        committedUsageDropdown.click();
        waitForElementToBeClickable(oneYearOption);
        if (option.equals("one year")) {
            oneYearOption.click();
        } else if (option.equals("3 years")) {
            threeYearsOption.click();
        }
    }
}
