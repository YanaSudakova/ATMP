package com.epam.atmp.service;

import com.epam.atmp.model.DefaultPricingCalculation;
import com.epam.atmp.model.GpuPricingCalculation;
import com.epam.atmp.model.PricingCalculation;
import org.openqa.selenium.WebDriver;

public class PricingCalculationDecorator {
    private final PricingCalculation pricingCalculation;

    public PricingCalculationDecorator(WebDriver driver, boolean isGPU) {
        if (isGPU) {
            pricingCalculation = new GpuPricingCalculation(driver);
        } else {
            pricingCalculation = new DefaultPricingCalculation(driver);
        }
        pricingCalculation.calculate();
    }

    public static void calculate(WebDriver driver, boolean isGPU) {
        new PricingCalculationDecorator(driver, isGPU);
    }
}
