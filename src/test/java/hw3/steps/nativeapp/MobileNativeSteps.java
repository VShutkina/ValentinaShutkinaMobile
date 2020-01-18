package hw3.steps.nativeapp;

import hw3.pages.nativeapp.BudgetActivityPage;
import hw3.pages.nativeapp.MainPage;
import hw3.pages.nativeapp.RegistrationPage;
import hw3.setup.DriverSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class MobileNativeSteps extends DriverSetup {

    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private BudgetActivityPage budgetActivityPage;

    public MobileNativeSteps(AppiumDriver<MobileElement> driver) {
        this.mainPage = new MainPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.budgetActivityPage = new BudgetActivityPage(driver);
        this.driver = driver;
    }

    public void clickRegisterButton() {
        mainPage.clickRegisterButton();
    }

    public MobileElement getLoginEmailTextField() {
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

    public MobileElement getEmailTextField() {
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

    public void registerButtonClick(String platform) {
        registrationPage.registerButtonClick(platform);
    }

    public String getPageTitle(String platform) {
        return budgetActivityPage.getPageTitle(platform);
    }

    public By pageTitleLocator(String platform) {
        return budgetActivityPage.pageTitleLocator(platform);
    }

    public void clickConfirmAgreements() {
        registrationPage.clickConfirmAgreements();
    }
}
