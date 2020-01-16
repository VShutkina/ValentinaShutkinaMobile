package hw3.setup;

import hw3.utils.TestProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    protected static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    protected static String PLATFORM;
    protected static String DRIVER;
    // protected static String DEVICE;
    protected static String UDID;
    protected static String APP_PACKAGE;
    protected static String APP_ACTIVITY;

    /**
     * This method prepares driver and sets capabilities
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browser;

        // properties initialization
        AUT = getProp("aut");
        SUT = getProp("sut") == null ? null : "https://" + getProp("sut");
        PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        UDID = getProp("udid");
        APP_ACTIVITY = getProp("appActivity");
        APP_PACKAGE = getProp("appPackage");


        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                browser = "Chrome";
                break;
            case "iOS":
                browser = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);

        // Setup type of application (native or web)
        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability("appPackage", APP_PACKAGE);
            capabilities.setCapability("appActivity", APP_ACTIVITY);
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
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
