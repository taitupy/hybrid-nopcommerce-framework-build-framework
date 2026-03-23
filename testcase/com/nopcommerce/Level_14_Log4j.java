package com.nopcommerce;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.user.*;

public class Level_14_Log4j extends BaseTest {
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
        log.info("User_01_Login - STEP 01 - OPEN HOME PAGE" + username);
        dashboardPage = homePage.systemLogin(username, password); // Page A: HomePage

        log.info("User_01_Login - STEP 02 - VERIFY MOVE TO DASHBOARD PAGE" + username);
        verifyTrue(dashboardPage.isDashboardPageDisplayed());
    }

    @Test
    public void User_02_Admin() {
        log.info("User_01_Login - STEP 03 - OPEN TO ADMIN PAGE");
        adminPage = dashboardPage.clickToAdminPage(); // Dang dung tu Dashboard Page

        log.info("User_01_Login - STEP 04 - CLICK TO ADIMIN SEARCH PAGE");
        adminPage.adminSearchPage(admin, employee);

        log.info("User_01_Login - STEP 05 - VERIFY ADMIN PAGE" + username);
        verifyEquals(adminPage.getSearchValue(),"(49) Record Found");
    }

    @Test
    public void User_03_Dynamic_Locator() {
        // Admin Page -> PIM Page
        log.info("User_01_Login - STEP 06 - OPEN TO ADMIN PAGE");
        pimPage = (PIMPO) adminPage.openSidebarLinkByPageName("PIM");

        // Pim Page -> Time Page
        log.info("User_01_Login - STEP 07 - OPEN TO TIME PAGE");
        timePage = (TimePO) pimPage.openSidebarLinkByPageName("Time");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
