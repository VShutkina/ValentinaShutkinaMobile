package steps.webapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pages.webapp.SearchPage;
import pages.webapp.SearchResultPage;
import setup.DriverSetup;

import java.util.List;

public class MobileWebSteps extends DriverSetup {

    private SearchPage searchPage;
    private SearchResultPage searchResultPage;
    private AppiumDriver driver;

    public MobileWebSteps(AppiumDriver driver) {
        this.driver = driver;
        this.searchPage = new SearchPage(driver);
        this.searchResultPage = new SearchResultPage(driver);
    }

    public void openGoogle() {
        driver.get(SUT);
    }

    public void fillTextInSearchField(String text) {
        searchPage.fillTextInSearchField(text);
    }

    public List<WebElement> getResults() {
        return searchResultPage.getResults();
    }
}
