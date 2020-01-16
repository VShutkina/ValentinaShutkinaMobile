package hw3.steps.webapp;

import hw3.pages.webapp.SearchPage;
import hw3.pages.webapp.SearchResultPage;
import hw3.setup.DriverSetup;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

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
        searchPage.fillTextInSearchField(text + '\n');
    }

    public List<WebElement> getResults() {
        return searchResultPage.getResults();
    }
}
