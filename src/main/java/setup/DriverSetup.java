package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestProperties;

import java.io.File;
import java.net.URL;

/**
 * This class sets all necessary capabilities, driver and wait
 */
public class DriverSetup extends TestProperties {

    protected static AppiumDriver driver = null;
    protected static WebDriverWait wait;
    protected DesiredCapabilities capabilities;

    // Properties to be read
    protected String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    protected String PLATFORM;
    protected String BROWSER;
    protected String DRIVER;
    protected String DEVICE;

    /**
     * This method prepares driver and sets capabilities
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        // properties initialization
        AUT = getProp("aut");
        SUT = getProp("sut") == null ? null : "https://" + getProp("sut");
        BROWSER = getProp("browser");
        PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE = getProp("device");

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);

        // Setup type of application (native or web)
        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER);
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        if (driver == null) {
            driver = new AppiumDriver(new URL(DRIVER), capabilities);
        }

    }

    /**
     * Get a driver
     *
     * @return
     * @throws Exception
     */
    protected AppiumDriver driver() throws Exception {
        if (driver == null) {
            prepareDriver();
        }
        return driver;
    }

    /**
     * Get a wait
     *
     * @return
     * @throws Exception
     */
    protected WebDriverWait driverWait() throws Exception {
        if (wait == null) {
            wait = new WebDriverWait(driver(), 10);
        }
        return wait;
    }

}
