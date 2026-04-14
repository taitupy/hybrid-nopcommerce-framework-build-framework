package pageObjects.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.DashboardPageUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("VERIFY MOVE TO DASHBOARD PAGE")
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
    @Step("CLICK TO ADMIN PAGE")
    public UserPO clickToAdminPage() {
        waitForElementClickable(driver, DashboardPageUI.ADMIN_LINK);
        clickToElement(driver, DashboardPageUI.ADMIN_LINK);
        return PageGenerator.getUserPage(driver); // vi tri 2 cach 3
    }
}
