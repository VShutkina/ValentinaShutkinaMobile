package hw3.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * The base class for all pages
 */
public abstract class AbstractBasePage {

    protected AppiumDriver driver;

    protected AbstractBasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
