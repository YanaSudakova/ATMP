package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicPage {

    protected WebDriver driver;

    public BasicPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
