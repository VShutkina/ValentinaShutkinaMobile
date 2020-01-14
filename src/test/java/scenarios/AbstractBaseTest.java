package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.DriverSetup;
import setup.PropertyFile;

/**
 * The base class for all tests
 */
public abstract class AbstractBaseTest extends DriverSetup {

    @BeforeSuite(groups = "web", description = "Prepare driver to run web test(s)")
    void setUpWeb() throws Exception {
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = "native", description = "Prepare driver to run native test(s)")
    void setUpNative() throws Exception {
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}
