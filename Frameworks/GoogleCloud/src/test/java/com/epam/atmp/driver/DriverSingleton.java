package com.epam.atmp.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {

    private static final String DEFAULT_BROWSER = "chrome";
    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", DEFAULT_BROWSER).toLowerCase();
            if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                setCommonOptions(firefoxOptions);
                driver = new FirefoxDriver(firefoxOptions);
            } else {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                setCommonOptions(chromeOptions);
                driver = new ChromeDriver(chromeOptions);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static void setCommonOptions(Object options) {
        if (options instanceof ChromeOptions chromeOptions) {
            chromeOptions.addArguments("--remote-allow-origins=*");
        }
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
