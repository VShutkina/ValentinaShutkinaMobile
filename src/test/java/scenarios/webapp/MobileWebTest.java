package scenarios.webapp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import scenarios.AbstractBaseTest;
import steps.webapp.MobileWebSteps;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * This is a web test with searching in Google.com
 */

public class MobileWebTest extends AbstractBaseTest {

    private static final String SEARCH_TEXT = "EPAM";

    public MobileWebTest() throws IOException {
    }

    @Test(groups = "web", description = "Test for searching in Google.com")
    public void WebAppTest() throws Exception {
        MobileWebSteps webSteps = new MobileWebSteps(driver);
        // 1. open google.com
        webSteps.openGoogle();
        // 2. wait until site is opened
        driverWait().until(ExpectedConditions.urlContains(SUT));
        // 3. search
        webSteps.fillTextInSearchField(SEARCH_TEXT);
        assertTrue(!webSteps.getResults().isEmpty(), "Result is empty!");
    }
}
