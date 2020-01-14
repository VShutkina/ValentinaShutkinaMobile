package pages.webapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractBasePage;

/**
 * The Search page
 */
public class SearchPage extends AbstractBasePage {

    @FindBy(name = "q")
    private WebElement searchField;

    protected SearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void fillTextInSearchField(String text) {
        searchField.sendKeys(text);
    }
}
