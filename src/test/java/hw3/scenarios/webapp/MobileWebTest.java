package hw3.scenarios.webapp;

import hw3.setup.DriverSetup;
import hw3.setup.PropertyFile;
import hw3.steps.webapp.MobileWebSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
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

    @BeforeSuite(groups = "web", description = "Prepare driver to run web test(s)")
    void setUpWeb() throws Exception {
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
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
        // 4. wait until Google search page is opened
        driverWait().until(ExpectedConditions.urlContains(SUT.concat(GOOGLE_SEARCH_URL)));
        // 5. check that search results are not empty
        assertTrue(!webSteps.getResults().isEmpty(), "Result is empty!");
    }

    @AfterSuite(groups = "web", description = "Close driver on test completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}
