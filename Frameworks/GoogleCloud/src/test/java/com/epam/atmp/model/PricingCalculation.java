package com.epam.atmp.model;

import com.epam.atmp.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculation extends AbstractPage {

    @FindBy(css = "input[ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesInput;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement freeOption;

    @FindBy(xpath = "//md-option[@value='ubuntu-pro']")
    private WebElement ubuntuProOption;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.class']")
    private WebElement provisioningModelDropdown;

    @FindBy(xpath = "//md-option[@value='regular']")
    private WebElement regularOption;

    @FindBy(xpath = "//md-option[@value='preemptible']")
    private WebElement preemptibleOption;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.series']")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement n1Option;

    @FindBy(xpath = "//md-option[@value='e2']")
    private WebElement e2Option;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement n1standard8Option;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-2']")
    private WebElement e2standard2Option;

    @FindBy(css = "md-checkbox[ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement nvidiaTeslaV100Option;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_P4']")
    private WebElement nvidiaTeslaP4Option;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGpusDropdown;

    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='1']]")
    private WebElement oneOption;

    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='2']]")
    private WebElement twoOption;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='2x375 GB']]")
    private WebElement local2x375Option;

    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='3x375 GB']]")
    private WebElement local3x375Option;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdown;

    @FindBy(css = "md-option[id='select_option_254']")
    private WebElement frankfurtOption;

    @FindBy(css = "md-option[id='select_option_229']")
    private WebElement iowaOption;

    @FindBy(css = "md-select[ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageDropdown;

    @FindBy(css = "md-option[id='select_option_134']")
    private WebElement oneYearOption;

    @FindBy(css = "md-option[id='select_option_135']")
    private WebElement threeYearsOption;

    public PricingCalculation(WebDriver driver) {
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

    public void setDatacenterLocation(String option) {
        datacenterLocationDropdown.click();
        waitForElementToBeClickable(frankfurtOption);
        if (option.equals("Frankfurt")) {
            frankfurtOption.click();
        } else if (option.equals("Iowa")) {
            iowaOption.click();
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

