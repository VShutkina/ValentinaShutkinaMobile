package hw3.scenarios.nativeapp;

import hw3.setup.DriverSetup;
import hw3.steps.nativeapp.MobileNativeSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * This is test of a native application EPAMTestApp
 */
@Test(groups = {"native", "ios_native"})
public class MobileNativeTest extends DriverSetup {

    private static final String TITLE = "BudgetActivity";
    private String EMAIL = "test@gmail.com";
    private String USERNAME = "Valentina";
    private String PASSWORD = "Qwerty2235";

    public MobileNativeTest() throws IOException {

    }

    @Test(description = "Test for native EPAMTestApp application")
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
}
