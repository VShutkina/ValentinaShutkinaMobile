package hw3.pages.nativeapp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

/**
 * The Budget Activity page
 */
public class BudgetActivityPage extends AbstractBasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/action_bar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Budget']")
    private MobileElement pageTitle;

    public BudgetActivityPage(AppiumDriver driver) {
        super(driver);
    }

    public By pageTitleLocator() {
        return By.id("platkovsky.alexey.epamtestapp:id/action_bar");
    }

    public String getPageTitle() {
        return pageTitle.findElement(By.className("android.widget.TextView")).getText();
    }
}
