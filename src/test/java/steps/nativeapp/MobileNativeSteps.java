package steps.nativeapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pages.nativeapp.BudgetActivityPage;
import pages.nativeapp.MainPage;
import pages.nativeapp.RegistrationPage;
import setup.DriverSetup;

public class MobileNativeSteps extends DriverSetup {

    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private BudgetActivityPage budgetActivityPage;
    private AppiumDriver driver;

    public MobileNativeSteps(AppiumDriver driver) {
        this.mainPage = new MainPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.budgetActivityPage = new BudgetActivityPage(driver);
        this.driver = driver;
    }

    public void clickRegisterButton() {
        mainPage.clickRegisterButton();
    }

    public WebElement getLoginEmailTextField() {
        return mainPage.getLoginEmailTextField();
    }

    public void fillLoginEmailTextField(String email) {
        mainPage.fillLoginEmailTextField(email);
    }

    public void fillPasswordTextField(String password) {
        mainPage.fillPasswordTextField(password);
    }

    public void clickSighInButton() {
        mainPage.clickSighInButton();
    }

    public WebElement getEmailTextField() {
        return registrationPage.getEmailTextField();
    }

    public void fillEmailTextField(String email) {
        registrationPage.fillEmailTextField(email);
    }

    public void fillUserNameTextField(String userName) {
        registrationPage.fillUserNameTextField(userName);
    }

    public void fillPasswordTextFieldOnPegPage(String password) {
        registrationPage.fillPasswordTextField(password);
    }

    public void confirmPasswordTextField(String password) {
        registrationPage.confirmPasswordTextField(password);
    }

    public void registerButtonClick() {
        registrationPage.registerButtonClick();
    }

    public String getPageTitle() {
        return budgetActivityPage.getPageTitle();
    }
}
