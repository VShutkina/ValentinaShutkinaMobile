package hw3.scenarios.webapp;

import hw3.setup.DriverSetup;
import hw3.steps.webapp.MobileWebSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * This is a web test with searching in Google.com
 */

public class MobileWebTest extends DriverSetup {

    private static final String SEARCH_TEXT = "EPAM";
    private static final String GOOGLE_SEARCH_URL = "/search";

    public MobileWebTest() throws IOException {
    }

    @Test(groups = {"web"}, description = "Test for searching in Google.com")
    public void WebAppTest() throws Exception {
        MobileWebSteps webSteps = new MobileWebSteps(driver);
        // 1. open google.com
        webSteps.openGoogle();
        // 2. wait until site is opened
        driverWait().until(ExpectedConditions.urlContains(SUT));
        // 3. search
        webSteps.fillTextInSearchField(SEARCH_TEXT);
        // 4. wait until Google search page is opened
        driverWait().until(ExpectedConditions.urlContains(SUT.concat(GOOGLE_SEARCH_URL)));
        // 5. check that search results are not empty
        assertTrue(!webSteps.getResults().isEmpty(), "Result is empty!");
    }
}
