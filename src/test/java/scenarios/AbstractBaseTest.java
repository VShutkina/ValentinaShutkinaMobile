package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.DriverSetup;
import utils.TestProperties;

/**
 * The base class for all tests
 */
public abstract class AbstractBaseTest extends DriverSetup {

    private static TestProperties properties = new TestProperties();

    @BeforeSuite(groups = {"web"}, description = "Prepare driver to run web test(s)")
    void setUpWeb() throws Exception {
        AUT = properties.getProperty("aut");
        SUT = null;
        prepareDriver();
    }

    @BeforeSuite(groups = {"native"}, description = "Prepare driver to run native test(s)")
    void setUpNative() throws Exception {
        SUT = properties.getProperty("sut");
        AUT = null;
        prepareDriver();
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}
