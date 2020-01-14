package scenarios.nativeapp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.nativeapp.BudgetActivityPage;
import pages.nativeapp.MainPage;
import pages.nativeapp.RegistrationPage;
import scenarios.AbstractBaseTest;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * This is test of a native application EPAMTestApp
 */
public class MobileNativeTest extends AbstractBaseTest {

    private static final String TITLE = "BudgetActivity";
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private BudgetActivityPage budgetActivityPage;
    private String EMAIL = getProp("email");
    private String USERNAME = getProp("userName");
    private String PASSWORD = getProp("password");

    public MobileNativeTest() throws IOException {

    }

    @Test(groups = "native", description = "Test for native EPAMTestApp application")
    public void NativeAppTest() throws Exception {
        //1. Click register button
        mainPage.clickRegisterButton();
        //2. wait some time until Registration page is opened
        driverWait().until(ExpectedConditions.visibilityOf(registrationPage.getEmailTextField()));
        //3. fill required data and click register button
        registrationPage.fillEmailTextField(EMAIL);
        registrationPage.fillUserNameTextField(USERNAME);
        registrationPage.fillPasswordTextField(PASSWORD);
        registrationPage.confirmPasswordTextField(PASSWORD);
        registrationPage.registerButtonClick();
        //4. wait some time until Main page is opened
        driverWait().until(ExpectedConditions.visibilityOf(mainPage.getLoginEmailTextField()));
        //5. sign in with created user
        mainPage.fillLoginEmailTextField(EMAIL);
        mainPage.fillPasswordTextField(PASSWORD);
        mainPage.clickSighInButton();
        // Checking if the page title matches to expected title
        assertEquals(budgetActivityPage.getPageTitle(), TITLE,
                String.format("Expected %s page title, but got %s",
                        TITLE, budgetActivityPage.getPageTitle()));
    }
}
