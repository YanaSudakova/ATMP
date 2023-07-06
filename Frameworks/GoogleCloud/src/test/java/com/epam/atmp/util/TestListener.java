package com.epam.atmp.util;

import com.epam.atmp.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext context) {
        LOGGER.info("Test Suite started: " + context.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("Test Suite finished: " + context.getSuite().getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test started: " + getTestMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test passed: " + getTestMethodName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test failed: " + getTestMethodName(result) + ". Screenshot is saved at /target/screenshots/.");
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.warn("Test skipped: " + getTestMethodName(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        LOGGER.error("Test failed due to timeout: " + getTestMethodName(result));
    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File("./target/screenshots/" + getCurrentTimeAsString()
                    + ".png"));
        } catch (IOException e) {
            LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}