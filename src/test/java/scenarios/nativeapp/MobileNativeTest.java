package scenarios.nativeapp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import scenarios.AbstractBaseTest;
import steps.nativeapp.MobileNativeSteps;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * This is test of a native application EPAMTestApp
 */
public class MobileNativeTest extends AbstractBaseTest {

    private static final String TITLE = "BudgetActivity";
    private String EMAIL = getProp("email");
    private String USERNAME = getProp("userName");
    private String PASSWORD = getProp("password");

    public MobileNativeTest() throws IOException {

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
        // Checking if the Budget Activity page title
        // matches to expected title
        assertEquals(nativeSteps.getPageTitle(), TITLE,
                String.format("Expected %s page title, but got %s",
                        TITLE, nativeSteps.getPageTitle()));
    }
}
