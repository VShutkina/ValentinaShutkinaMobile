package hw3.scenarios;

import hw3.setup.DriverSetup;
import hw3.setup.PropertyFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Class run before and after test suites
 */
public class Hooks extends DriverSetup {

    @BeforeSuite(groups = {"native"}
            , description = "Prepare driver to run android native test(s)")
    void setUpNative() throws Exception {
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @BeforeSuite(groups = {"ios_native"}
            , description = "Prepare driver to run ios native test(s)")
    void setUpIosNative() throws Exception {
        setPropertyFile(PropertyFile.IOS_NATIVE);
        prepareDriver();
    }

    @BeforeSuite(groups = {"ios_web"}
            , description = "Prepare driver to run ios web test(s)")
    void setUpIosWEb() throws Exception {
        setPropertyFile(PropertyFile.IOS_WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = {"web"}
            , description = "Prepare driver to run android web test(s)")
    void setUpWeb() throws Exception {
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @AfterSuite(groups = {"web", "ios_web", "ios_native", "native"}
            , description = "Close driver on test completion", alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
