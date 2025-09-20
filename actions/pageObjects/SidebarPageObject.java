package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    WebDriver driver;

    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public PIMPageObject openPimPage() {
        waitForElementClickable(driver, SidebarPageUI.PIM_LINK);
        clickToElement(driver, SidebarPageUI.PIM_LINK);
        return PageGenerator.getPIMPage(driver);
    }

    public TimePageObject openTimePage() {
        waitForElementClickable(driver, SidebarPageUI.TIME_LINK);
        clickToElement(driver, SidebarPageUI.TIME_LINK);
        return PageGenerator.getTimePage(driver);
    }

    public AdminPageObject openAdminPage() {
        waitForElementClickable(driver, SidebarPageUI.ADMIN_LINK);
        clickToElement(driver, SidebarPageUI.ADMIN_LINK);
        return PageGenerator.getAdminPage(driver);
    }
}
