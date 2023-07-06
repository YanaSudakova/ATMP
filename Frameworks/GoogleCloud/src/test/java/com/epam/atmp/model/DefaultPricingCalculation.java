package com.epam.atmp.model;

import com.epam.atmp.page.AbstractPage;
import com.epam.atmp.service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultPricingCalculation extends AbstractPage implements PricingCalculation {

    private static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.numberOfInstances";
    private static final String TESTDATA_OPERATING_SYSTEM = "testdata.operatingSystem";
    private static final String TESTDATA_PROVISIONING_MODEL = "testdata.provisioningModel";
    private static final String TESTDATA_SERIES = "testdata.series";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.machineType";
    private static final String TESTDATA_DATACENTER_LOCATION = "testdata.datacenterLocation";
    private static final Logger LOGGER = LogManager.getLogger(DefaultPricingCalculation.class);

    @FindBy(css = "input[ng-model='listingCtrl.computeServer.quantity']")
    protected WebElement numberOfInstancesInput;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.os']")
    protected WebElement operatingSystemDropdown;

    @FindBy(xpath = "//md-option[@value='free']")
    protected WebElement freeOption;

    @FindBy(xpath = "//md-option[@value='ubuntu-pro']")
    protected WebElement ubuntuProOption;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.class']")
    protected WebElement provisioningModelDropdown;

    @FindBy(xpath = "//md-option[@value='regular']")
    protected WebElement regularOption;

    @FindBy(xpath = "//md-option[@value='preemptible']")
    protected WebElement preemptibleOption;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.series']")
    protected WebElement seriesDropdown;

    @FindBy(xpath = "//md-option[@value='n1']")
    protected WebElement n1Option;

    @FindBy(xpath = "//md-option[@value='e2']")
    protected WebElement e2Option;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.instance']")
    protected WebElement machineTypeDropdown;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    protected WebElement n1standard8Option;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-2']")
    protected WebElement e2standard2Option;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.location']")
    protected WebElement datacenterLocationDropdown;

    @FindBy(css = "md-option[id='select_option_254']")
    protected WebElement frankfurtOption;

    @FindBy(css = "md-option[id='select_option_230']")
    protected WebElement iowaOption;

    public DefaultPricingCalculation(WebDriver driver) {
        super(driver);
    }

    public void setNumberOfInstances(String numberOfInstances) {
        waitForElementToBeVisible(numberOfInstancesInput);
        numberOfInstancesInput.sendKeys(numberOfInstances);
    }

    public void setOperatingSystem(String option) {
        operatingSystemDropdown.click();
        waitForElementToBeClickable(freeOption);
        if (option.equals("free")) {
            freeOption.click();
        } else if (option.equals("ubuntu-pro")) {
            ubuntuProOption.click();
        }
    }

    public void setProvisioningModel(String option) {
        provisioningModelDropdown.click();
        waitForElementToBeClickable(regularOption);
        if (option.equals("regular")) {
            regularOption.click();
        } else if (option.equals("preemptible")) {
            preemptibleOption.click();
        }
    }

    public void setSeries(String option) {
        seriesDropdown.click();
        waitForElementToBeClickable(n1Option);
        if (option.equals("n1")) {
            n1Option.click();
        } else if (option.equals("e2")) {
            e2Option.click();
        }
    }

    public void setMachineType(String option) {
        machineTypeDropdown.click();
        if (option.equals("n1 standard 80")) {
            waitForElementToBeClickable(n1standard8Option);
            n1standard8Option.click();
        } else if (option.equals("e2 standard 2")) {
            waitForElementToBeClickable(e2standard2Option);
            e2standard2Option.click();
        }
    }

    public void setDatacenterLocation(String option) {
        datacenterLocationDropdown.click();
        waitForElementToBeClickable(frankfurtOption);
        if (option.equals("Frankfurt")) {
            frankfurtOption.click();
        } else if (option.equals("Iowa")) {
            iowaOption.click();
        }
    }

    @Override
    public void calculate() {
        createPricingCalculationWithoutGpu();
    }

    protected void createPricingCalculationWithoutGpu() {
        LOGGER.info("Creating pricing calculation without GPU");
        setNumberOfInstances(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES));
        setOperatingSystem(TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM));
        setProvisioningModel(TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL));
        setSeries(TestDataReader.getTestData(TESTDATA_SERIES));
        setMachineType(TestDataReader.getTestData(TESTDATA_MACHINE_TYPE));
        setDatacenterLocation(TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION));
    }
}