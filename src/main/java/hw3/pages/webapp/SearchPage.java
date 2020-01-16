package hw3.pages.webapp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Search page
 */
public class SearchPage extends AbstractBasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void fillTextInSearchField(String text) {
        searchField.sendKeys(text);
    }
}
