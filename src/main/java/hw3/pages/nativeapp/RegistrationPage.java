package hw3.pages.nativeapp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The registration page,
 * where user can fill required data
 */

public class RegistrationPage extends AbstractBasePage {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement emailTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement userNameTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement passwordTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement confirmPasswordTextField;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement registerButton;

    public RegistrationPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getEmailTextField() {
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
