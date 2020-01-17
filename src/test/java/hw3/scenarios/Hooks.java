package hw3.scenarios;

import hw3.setup.DriverSetup;
import hw3.setup.PropertyFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Class run before and after test suites
 */
public class Hooks extends DriverSetup {

    @BeforeSuite(groups = {"native"}, description = "Prepare driver to run native test(s)")
    void setUpNative() throws Exception {
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @BeforeSuite(groups = {"ios"}, description = "Prepare driver to run native test(s)")
    void setUpIosNative() throws Exception {
        setPropertyFile(PropertyFile.IOS);
        prepareDriver();
    }

    @BeforeSuite(groups = {"web"}, description = "Prepare driver to run web test(s)")
    void setUpWeb() throws Exception {
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @AfterSuite(groups = {"web", "ios", "native"}, description = "Close driver on test completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}
