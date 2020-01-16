package scenarios.nativeapp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.DriverSetup;
import setup.PropertyFile;
import steps.nativeapp.MobileNativeSteps;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * This is test of a native application EPAMTestApp
 */
public class MobileNativeTest extends DriverSetup {

    private static final String TITLE = "BudgetActivity";
    private String EMAIL = "test@gmail.com";
    private String USERNAME = "Valentina";
    private String PASSWORD = "Qwerty2235";

    public MobileNativeTest() throws IOException {

    }

    @BeforeSuite(groups = "native", description = "Prepare driver to run native test(s)")
    void setUpNative() throws Exception {
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @Test(groups = "native", description = "Test for native EPAMTestApp application")
    public void NativeAppTest() throws Exception {
        MobileNativeSteps nativeSteps = new MobileNativeSteps(driver);
        //1. Click register button
        nativeSteps.clickRegisterButton();
        //2. wait some time until Registration page is opened
        driverWait().until(ExpectedConditions.visibilityOf(nativeSteps.getEmailTextField()));
        //3. fill required data and click register button
        // on Registration Page
        nativeSteps.fillEmailTextField(EMAIL);
        nativeSteps.fillUserNameTextField(USERNAME);
        nativeSteps.fillPasswordTextFieldOnPegPage(PASSWORD);
        nativeSteps.confirmPasswordTextField(PASSWORD);
        nativeSteps.registerButtonClick();
        //4. wait some time until Main page is opened
        driverWait().until(ExpectedConditions.visibilityOf(nativeSteps.getLoginEmailTextField()));
        //5. sign in with created user on Main page
        nativeSteps.fillLoginEmailTextField(EMAIL);
        nativeSteps.fillPasswordTextField(PASSWORD);
        nativeSteps.clickSighInButton();
        // Wait for Budget Activity page title presented
        driverWait().until(ExpectedConditions.presenceOfElementLocated(nativeSteps.pageTitleLocator()));
        // Checking if the Budget Activity page title
        // matches to expected title
        String actualTitle = nativeSteps.getPageTitle();
        assertEquals(actualTitle, TITLE,
                String.format("Expected %s page title, but got %s",
                        TITLE, actualTitle));
    }

    @AfterSuite(groups = "native", description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}
