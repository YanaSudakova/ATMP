package com.epam.atmp.service;

import com.epam.atmp.model.PricingCalculation;
import com.epam.atmp.page.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PricingCalculationCreator extends AbstractPage {

    private static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.numberOfInstances";
    private static final String TESTDATA_OPERATING_SYSTEM = "testdata.operatingSystem";
    private static final String TESTDATA_PROVISIONING_MODEL = "testdata.provisioningModel";
    private static final String TESTDATA_SERIES = "testdata.series";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.machineType";
    private static final String TESTDATA_GPU_TYPE = "testdata.gpuType";
    private static final String TESTDATA_NUMBER_OF_GPUS = "testdata.numberOfGpus";
    private static final String TESTDATA_LOCAL_SSD = "testdata.localSSD";
    private static final String TESTDATA_DATACENTER_LOCATION = "testdata.datacenterLocation";
    private static final String TESTDATA_COMMITTED_USAGE = "testdata.committedUsage";
    private final PricingCalculation pricingCalculation;

    public PricingCalculationCreator(WebDriver driver) {
        super(driver);
        this.pricingCalculation = new PricingCalculation(driver);
    }

    public void createPricingCalculationWithGPU() {
        logAction("Creating pricing calculation with GPU");
        pricingCalculation.setNumberOfInstances(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES));
        pricingCalculation.setOperatingSystem(TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM));
        pricingCalculation.setProvisioningModel(TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL));
        pricingCalculation.setSeries(TestDataReader.getTestData(TESTDATA_SERIES));
        pricingCalculation.setMachineType(TestDataReader.getTestData(TESTDATA_MACHINE_TYPE));
        pricingCalculation.setGpuType(TestDataReader.getTestData(TESTDATA_GPU_TYPE));
        pricingCalculation.setNumberOfGpus(TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS));
        pricingCalculation.setLocalSSD(TestDataReader.getTestData(TESTDATA_LOCAL_SSD));
        pricingCalculation.setDatacenterLocation(TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION));
        pricingCalculation.setCommittedUsage(TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }

    public void createPricingCalculationWithoutGpu() {
        logAction("Creating pricing calculation without GPU");
        pricingCalculation.setNumberOfInstances(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES));
        pricingCalculation.setOperatingSystem(TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM));
        pricingCalculation.setProvisioningModel(TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL));
        pricingCalculation.setSeries(TestDataReader.getTestData(TESTDATA_SERIES));
        pricingCalculation.setMachineType(TestDataReader.getTestData(TESTDATA_MACHINE_TYPE));
        pricingCalculation.setDatacenterLocation(TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION));
    }
}
