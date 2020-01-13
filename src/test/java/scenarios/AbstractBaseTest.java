package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.DriverSetup;

public abstract class AbstractBaseTest extends DriverSetup {

    @BeforeSuite(groups = {"web"})
    void setUpWeb() throws Exception {
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = {"native"})
    void setUpNative() throws Exception {
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @AfterSuite(description = "Close driver")
    public void tearDown() throws Exception {
        driver().quit();
    }
}
