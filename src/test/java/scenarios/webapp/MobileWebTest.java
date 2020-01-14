package scenarios.webapp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.webapp.SearchPage;
import pages.webapp.SearchResultPage;
import scenarios.AbstractBaseTest;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * This is a web test with searching in Google.com
 */

public class MobileWebTest extends AbstractBaseTest {

    private static final String SEARCH_TEXT = "EPAM";
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;

    public MobileWebTest() throws IOException {
    }

    @Test(groups = "web", description = "Test for searching in Google.com")
    public void WebAppTest() throws Exception {
        // 1. open google.com
        driver().get(SUT);
        // 2. wait until site is opened
        driverWait().until(ExpectedConditions.urlContains(SUT));
        // 3. search
        searchPage.fillTextInSearchField(SEARCH_TEXT);
        assertTrue(!searchResultPage.getResults().isEmpty(), "Result is empty!");
    }
}
