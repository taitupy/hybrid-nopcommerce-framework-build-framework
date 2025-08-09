package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AdminPageObject;
import pageObjects.DashboardPageObject;
import pageObjects.HomePageObject;

public class Level_06_Page_Generator_02 extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private DashboardPageObject dashboardPage;
    private AdminPageObject adminPage;
    private String admin, employee, username, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);

        // Maximize browser
        driver.manage().window().maximize();

        // C2- Page_Generator chua xu ly dc viec khoi tao Page Object cho nay
        homePage = new HomePageObject(driver);

        // Tao data test
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";
    }

    @Test
    public void User_01_Login(){
        dashboardPage = homePage.systemLogin(username, password); // Page A: HomePage
//        dashboardPage = new DashboardPageObject(driver); // page B: Dashboard Page

        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());
    }

    @Test
    public void User_02_Admin() {
        adminPage = dashboardPage.clickToAdminPage(); // Danf dung tu Dashboard Page

//        adminPage = new AdminPageObject(driver); // Tu Dashboard page -> Admin Page
        adminPage.adminSearchPage(admin, employee);

        Assert.assertEquals(adminPage.getSearchValue(),"(1) Record Found");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
