package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AdminPageObject;
import pageObjects.DashboardPageObject;
import pageObjects.HomePageObject;

import java.time.Duration;

public class Level_03_Page_Object_Parttern extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private DashboardPageObject dashboardPage;
    private AdminPageObject adminPage;
    private String admin, employee, username, password;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();

        // Mo url len -> qa Home Page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // No dc sinh ra va bat dau lam cac action cua pgae do
        homePage = new HomePageObject(driver);

        // Tao data test
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";
    }

    @Test
    public void User_01_Login(){
        homePage.systemLogin(username, password);
        // Action 4 - Verify page Dashboard
        dashboardPage = new DashboardPageObject(driver);

        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());
    }

    @Test
    public void User_02_Admin() {
        // Tu Dashboard page
        dashboardPage = new DashboardPageObject(driver);
        dashboardPage.clickToAdminPage();

        // Tu Dashboard page -> Admin Page
        adminPage = new AdminPageObject(driver);
        adminPage.adminSearchPage(admin, employee);

        Assert.assertEquals(adminPage.getSearchValue(),"(1) Record Found");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
