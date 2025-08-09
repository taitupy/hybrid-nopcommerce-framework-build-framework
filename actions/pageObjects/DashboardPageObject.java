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

    //  Cach chua quan ly Page Generator Manager - C1
//    public void clickToAdminPage() {
//        waitForElementClickable(driver, DashboardPageUI.ADMIN_LINK);
//        clickToElement(driver, DashboardPageUI.ADMIN_LINK);
//    }

    // Viet theo Page Generator Manager -C2
//    public AdminPageObject clickToAdminPage() {
//        waitForElementClickable(driver, DashboardPageUI.ADMIN_LINK);
//        clickToElement(driver, DashboardPageUI.ADMIN_LINK);
//        return new AdminPageObject(driver);
//    }

    // Viet theo Page Generator Manager -C3
    public AdminPageObject clickToAdminPage() {
        waitForElementClickable(driver, DashboardPageUI.ADMIN_LINK);
        clickToElement(driver, DashboardPageUI.ADMIN_LINK);
        return PageGenerator.getAdminPage(driver); // vi tri 2 cach 3
    }
}
