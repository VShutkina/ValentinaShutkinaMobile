package hw3.pages.nativeapp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Main page (Sign in page)
 */
public class MainPage extends AbstractBasePage {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement loginEmailTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement passwordTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signInButton;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerButton;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getLoginEmailTextField() {
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
