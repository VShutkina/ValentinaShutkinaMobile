package setup;

import constant.MobileConstant;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class DriverSetup {

    protected AppiumDriver driver;
    protected DesiredCapabilities capabilities;

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileConstant.DEVICE);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileConstant.PLATFORM);

        // Setup type of application (native or web)
        if (MobileConstant.AUT != null && MobileConstant.SUT == null) {
            //web
            File app = new File(MobileConstant.AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            driver = new AppiumDriver(new URL(MobileConstant.DRIVER), capabilities);
        } else if (MobileConstant.SUT != null && MobileConstant.AUT == null) {
            //native
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileConstant.BROWSER);
            driver = new AppiumDriver(new URL(MobileConstant.DRIVER), capabilities);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

    }
}
