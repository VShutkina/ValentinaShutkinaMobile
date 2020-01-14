package pages.webapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractBasePage;

import java.util.List;

/**
 * The Search Result page
 */
public class SearchResultPage extends AbstractBasePage {

    @FindBy(xpath = ".//*[@id='rso']/div[@class='srg']/div")
    List<WebElement> results;

    protected SearchResultPage(AppiumDriver driver) {
        super(driver);
    }

    public List<WebElement> getResults() {
        return results;
    }
}
