package hw3.pages.nativeapp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * The registration page,
 * where user can fill required data
 */

public class RegistrationPage extends AbstractBasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private MobileElement emailTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    private MobileElement userNameTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private MobileElement passwordTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    private MobileElement confirmPasswordTextField;

    @AndroidFindBy(xpath = "//*[@text='I read agreaments and agree wit it']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
    private MobileElement confirmAgreements;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    private MobileElement registerButton;

    public RegistrationPage(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getEmailTextField() {
        return emailTextField;
    }

    public void fillEmailTextField(String email) {
        emailTextField.sendKeys(email);
    }

    public void fillUserNameTextField(String userName) {
        userNameTextField.sendKeys(userName);
    }

    public void fillPasswordTextField(String password) {
        passwordTextField.sendKeys(password);
    }

    public void confirmPasswordTextField(String password) {
        confirmPasswordTextField.sendKeys(password);
    }

    public void clickConfirmAgreements() {
        confirmAgreements.click();
    }

    //There is a problem on tested iPhone XS
    public void registerButtonClick(String platform) {
        switch (platform) {
            case "Android":
                registerButton.click();
                break;
            case "iOS":
                registerButton.click();
                registerButton.click();
                break;
        }
    }
}
