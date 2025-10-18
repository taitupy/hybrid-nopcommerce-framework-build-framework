package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.user.*;

public class Level_09_Switch_Site_Url extends BaseTest {
    private WebDriver driver;
    private HomePO userHomePage;
    private DashboardPO userDashboardPage;
    private UserPO userPage;
    private PIMPO userPimPage;
    private TimePO userTimePage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private String admin, employee, username, password;
    private String emailAdmin, passwordAdmin;

    private  String userUrlValue, adminUrlValue;

    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl){
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;

        driver = getBrowserDriver(browserName, userUrlValue);
        driver.manage().window().maximize();

        // C3- Page_Generator - Vi tri 1
        userHomePage = PageGenerator.getUserHomePage(driver);

        // Tao data test
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";

        // Admin role
        emailAdmin = "admin@gmail.com";
        passwordAdmin = "Admin12345";
    }

    @Test
    public void Role_01_User_Site_To_Admin_Site(){
        userDashboardPage = userHomePage.systemLogin(username, password); // Page A: HomePage
        Assert.assertTrue(userDashboardPage.isDashboardPageDisplayed());

        // Step de order 1 cai gi do
        userPage = userDashboardPage.clickToAdminPage(); // Dang dung tu Dashboard Page
        userPage.adminSearchPage(admin, employee);
        Assert.assertEquals(userPage.getSearchValue(),"(1) Record Found");

        // Qua trang Admin de approve order vua r o page user
        userPage.openPageUrl(driver, adminUrlValue);

        // Chua Login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminLoginPage.clickToAccountLink();
        adminLoginPage.clickToLoginLink();
        adminLoginPage.enterToEmailTextbox(emailAdmin);
        adminLoginPage.enterToPasswordTextbox(passwordAdmin);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        adminDashboardPage.openPageUrl(driver, userUrlValue);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
