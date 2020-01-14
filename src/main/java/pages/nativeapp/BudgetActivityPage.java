package pages.nativeapp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractBasePage;

/**
 * The Budget Activity page
 */
public class BudgetActivityPage extends AbstractBasePage {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/action_bar")
    private WebElement pageTitle;

    protected BudgetActivityPage(AppiumDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.findElement(By.className("android.widget.TextView")).getText();
    }
}
