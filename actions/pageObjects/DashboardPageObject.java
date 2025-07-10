package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DashboardPageUI;

public class DashboardPageObject extends BasePage {
    private WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardPageDisplayed() {
        waitForElementVisible(driver, DashboardPageUI.PIM_LINK);
        return isElementDisplayed(driver, DashboardPageUI.PIM_LINK);
    }

    public void clickToAdminPage() {
        waitForElementClickable(driver, DashboardPageUI.ADMIN_LINK);
        clickToElement(driver, DashboardPageUI.ADMIN_LINK);
    }
}
