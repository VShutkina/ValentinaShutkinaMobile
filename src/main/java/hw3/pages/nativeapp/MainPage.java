package hw3.pages.nativeapp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * The Main page (Sign in page)
 */
public class MainPage extends AbstractBasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private MobileElement loginEmailTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private MobileElement passwordTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign In']")
    private MobileElement signInButton;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']")
    private MobileElement registerButton;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getLoginEmailTextField() {
        return loginEmailTextField;
    }

    public void fillLoginEmailTextField(String email) {
        loginEmailTextField.sendKeys(email);
    }

    public void fillPasswordTextField(String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickSighInButton() {
        signInButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
