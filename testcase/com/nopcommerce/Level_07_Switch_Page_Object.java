package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.user.*;

public class Level_07_Switch_Page_Object extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private DashboardPO dashboardPage;
    private UserPO adminPage;
    private PIMPO pimPage;
    private TimePO timePage;
    private String admin, employee, username, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        driver.manage().window().maximize();

        // C3- Page_Generator - Vi tri 1
        homePage = PageGenerator.getUserHomePage(driver);

        // Tao data test
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";
    }

    @Test
    public void User_01_Login(){
        dashboardPage = homePage.systemLogin(username, password); // Page A: HomePage

        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());
    }

    @Test
    public void User_02_Admin() {
        adminPage = dashboardPage.clickToAdminPage(); // Dang dung tu Dashboard Page

        adminPage.adminSearchPage(admin, employee);

        Assert.assertEquals(adminPage.getSearchValue(),"(1) Record Found");
    }

    @Test
    public void User_03_Switch_Page() {
        // Admin Page -> PIM Page
        pimPage = adminPage.openPimPage(driver);
        // Add new Pim Page
        //...

        // Pim Page -> Time Page
        timePage = pimPage.openTimePage(driver);
        // Add new Time Page
        //...

        // Time page -> Admin page
        adminPage = timePage.openAdminPage(driver);
        // Add new Admin Page
        //...

        // Admin page -> Time page
        timePage = adminPage.openTimePage(driver);
        // Add new Time Page
        //...
        pimPage = timePage.openPimPage(driver);
        adminPage = pimPage.openAdminPage(driver);

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
