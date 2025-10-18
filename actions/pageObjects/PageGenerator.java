package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.user.*;

public class PageGenerator {
    public static HomePO getUserHomePage(WebDriver driver){
        return new HomePO(driver);
    }

    public static DashboardPO getUserDashboardPage(WebDriver driver){
        return new DashboardPO(driver);
    }

    public static UserPO getUserPage(WebDriver driver){
        return new UserPO(driver);
    }

    public static PIMPO getPIMPage(WebDriver driver){
        return new PIMPO(driver);
    }

    public static TimePO getTimePage(WebDriver driver){
        return new TimePO(driver);
    }

    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPO(driver);
    }
}
