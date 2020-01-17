package hw3.pages.nativeapp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;

/**
 * The registration page,
 * where user can fill required data
 */

public class RegistrationPage extends AbstractBasePage {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField//XCUIElementTypeTextField[@value='user@example.com']")
    private MobileElement emailTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    private MobileElement userNameTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField//XCUIElementTypeSecureTextField[@value='Required']")
    private MobileElement passwordTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField//XCUIElementTypeSecureTextField[@value='Repeat please']")
    private MobileElement confirmPasswordTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']")
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

    public void registerButtonClick() {
        registerButton.click();
    }
}
