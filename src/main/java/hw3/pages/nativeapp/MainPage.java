package hw3.pages.nativeapp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;

/**
 * The Main page (Sign in page)
 */
public class MainPage extends AbstractBasePage {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField//XCUIElementTypeTextField")
    private MobileElement loginEmailTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField//XCUIElementTypeSecureTextField")
    private MobileElement passwordTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign In']")
    private MobileElement signInButton;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
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
