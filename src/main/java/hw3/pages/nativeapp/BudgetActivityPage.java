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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@label='Budget']")
    private MobileElement pageTitle;

    public BudgetActivityPage(AppiumDriver driver) {
        super(driver);
    }

    public By pageTitleLocator(String platform) {
        By titleLocator;
        switch (platform) {
            case "Android":
                titleLocator = By.id("platkovsky.alexey.epamtestapp:id/action_bar");
                break;
            case "iOS":
                titleLocator = By.xpath("//XCUIElementTypeNavigationBar[@name='Budget']");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + platform);
        }
        return titleLocator;
    }

    public String getPageTitle(String platform) {
        String title;
        switch (platform) {
            case "Android":
                title = pageTitle.findElement(By.className("android.widget.TextView")).getText();
                break;
            case "iOS":
                title = pageTitle.getText();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + platform);
        }
        return title;
    }
}
