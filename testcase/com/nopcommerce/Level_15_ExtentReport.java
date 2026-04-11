package com.nopcommerce;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.user.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class Level_15_ExtentReport extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private DashboardPO dashboardPage;
    private UserPO adminPage;
    private PIMPO pimPage;
    private TimePO timePage;
    private String admin, employee, username, password;
    String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        driver.manage().window().maximize();

        // C3- Page_Generator - Vi tri 1
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;

        // Tao data test
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";
    }

    @Test
    public void User_01_Login(Method method){
        ExtentManager.startTest(method.getName() + " - "+ this.browserName.toUpperCase(),"User_01_Login - STEP 01 - OPEN HOME PAGE");
//        log.info("User_01_Login - STEP 01 - OPEN HOME PAGE" + username);
        dashboardPage = homePage.systemLogin(username, password); // Page A: HomePage

        ExtentManager.getTest().log(Status.INFO, "Register - Step 01: NavigatSTEP 02 - VERIFY MOVE TO DASHBOARD PAGE");
//        log.info("User_01_Login - STEP 02 - VERIFY MOVE TO DASHBOARD PAGE" + username);
        verifyTrue(dashboardPage.isDashboardPageDisplayed());
    }

    @Test
    public void User_02_Admin(Method method) {
        ExtentManager.startTest(method.getName() + " - "+ this.browserName.toUpperCase(), "Login to system successfully");
//        log.info("User_01_Login - STEP 03 - OPEN TO ADMIN PAGE");
        adminPage = dashboardPage.clickToAdminPage(); // Dang dung tu Dashboard Page

        ExtentManager.getTest().log(Status.INFO, "User_01_Login - STEP 04 - CLICK TO ADIMIN SEARCH PAGE");
//        log.info("User_01_Login - STEP 04 - CLICK TO ADIMIN SEARCH PAGE");
        adminPage.adminSearchPage(admin, employee);

        ExtentManager.getTest().log(Status.INFO, "User_01_Login - STEP 05 - VERIFY ADMIN PAGE");
//        log.info("User_01_Login - STEP 05 - VERIFY ADMIN PAGE" + username);
        verifyEquals(adminPage.getSearchValue(),"(49) Record Found");
    }

    @Test
    public void User_03_Dynamic_Locator(Method method) {
        // Admin Page -> PIM Page
        ExtentManager.startTest(method.getName() + " - "+ this.browserName.toUpperCase(), "User_01_Login - STEP 06 - OPEN TO ADMIN PAGE");
//        log.info("User_01_Login - STEP 06 - OPEN TO ADMIN PAGE");
        pimPage = (PIMPO) adminPage.openSidebarLinkByPageName("PIM");

        // Pim Page -> Time
        ExtentManager.getTest().log(Status.INFO, "User_01_Login - STEP 07 - OPEN TO TIME PAGE");
//        log.info("User_01_Login - STEP 07 - OPEN TO TIME PAGE");
        timePage = (TimePO) pimPage.openSidebarLinkByPageName("Time");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
