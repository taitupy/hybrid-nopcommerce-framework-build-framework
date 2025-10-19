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

    /* Only use for Level_08_Page_Navigation */
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

    public SidebarPO openSidebarLinkByPageName(String pageName) {
        waitForElementClickable(driver, SidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, SidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);

        switch (pageName){
            case "PIM":
                return PageGenerator.getPIMPage(driver);
            case "Time":
                return PageGenerator.getTimePage(driver);
            case "Admin":
                return PageGenerator.getUserPage(driver);
            default:
                throw new RuntimeException("Page name is not valid!!!s");
        }
    }

    public void openSidebarLinkByPageNames(String pageName) {
        waitForElementClickable(driver, SidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, SidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
    }

}
