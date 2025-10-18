package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.SidebarPageUI;

public class SidebarPO extends BasePage {
    WebDriver driver;

    public SidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public PIMPO openPimPage() {
        waitForElementClickable(driver, SidebarPageUI.PIM_LINK);
        clickToElement(driver, SidebarPageUI.PIM_LINK);
        return PageGenerator.getPIMPage(driver);
    }

    public TimePO openTimePage() {
        waitForElementClickable(driver, SidebarPageUI.TIME_LINK);
        clickToElement(driver, SidebarPageUI.TIME_LINK);
        return PageGenerator.getTimePage(driver);
    }

    public UserPO openAdminPage() {
        waitForElementClickable(driver, SidebarPageUI.ADMIN_LINK);
        clickToElement(driver, SidebarPageUI.ADMIN_LINK);
        return PageGenerator.getUserPage(driver);
    }
}
