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

public class Level_13_Verify extends BaseTest {
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

        verifyFalse(dashboardPage.isDashboardPageDisplayed());
    }

    @Test
    public void User_02_Admin() {
        adminPage = dashboardPage.clickToAdminPage(); // Dang dung tu Dashboard Page

        adminPage.adminSearchPage(admin, employee);

        verifyEquals(adminPage.getSearchValue(),"(1) Record Found@@");
    }

    @Test
    public void User_03_Dynamic_Locator() {
        // Admin Page -> PIM Page
        pimPage = (PIMPO) adminPage.openSidebarLinkByPageName("PIM");

        // Pim Page -> Time Page
        timePage = (TimePO) pimPage.openSidebarLinkByPageName("Time");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
