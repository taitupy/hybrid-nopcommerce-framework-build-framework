package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.UserPO;
import pageObjects.user.DashboardPO;
import pageObjects.user.HomePO;

public class Level_06_Page_Generator_01 extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private DashboardPO dashboardPage;
    private UserPO adminPage;
    private String admin, employee, username, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);

        // Maximize browser
        driver.manage().window().maximize();

        // No dc sinh ra va bat dau lam cac action cua pgae do
        homePage = new HomePO(driver);

        // Tao data test
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";
    }

    @Test
    public void User_01_Login(){
        homePage.systemLogin(username, password); // Page A: HomePage

        // The hien truc tiep tren Test Class
        // Sai nguyen tac OOP
        dashboardPage = new DashboardPO(driver); // page B: Dashboard Page

        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());
    }

    @Test
    public void User_02_Admin() {
        // Tu Dashboard page
        dashboardPage = new DashboardPO(driver);
        dashboardPage.clickToAdminPage();

        // Tu Dashboard page -> Admin Page
        adminPage = new UserPO(driver);
        adminPage.adminSearchPage(admin, employee);

        Assert.assertEquals(adminPage.getSearchValue(),"(1) Record Found");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
