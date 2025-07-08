package com.nopcommerce;

import commons.BasePage;
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
import java.util.Random;

public class Level_03_Page_Object_Parttern extends BasePage{

    private WebDriver driver;
    private String admin, employee, username, password;
    private HomePageObject homePage;
    private DashboardPageObject dashboardPage;
    private AdminPageObject adminPage;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();

        // Mo url len -> qa Home Page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";

        // No dc sinh ra va bat dau lam cac action cua pgae do
        homePage = new HomePageObject();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void User_01_Register(){
        // Action 1 - HomePage
        homePage.enterToUsenameTextbox(username);

        // Action 2 - HomePage
        homePage.enterToPasswordTextbox(password);

        // Action 3 - HomePage qa Dashboard
        homePage.clickToDashboardPage();

        // Action 4 - Verify page Dashboard
        dashboardPage = new DashboardPageObject();
        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());

//        sendKeyToElement(driver, "//input[@name='username']", username);
//        sendKeyToElement(driver, "//input[@name='password']", password);
//
//        waitForElementClickable(driver, "//button[@type='submit']");
//        clickToElement(driver, "//button[@type='submit']");
//
//        isElementDisplayed(driver, "//span[text()='PIM']");
    }

    @Test
    public void User_02_Admin() {
        // Tu Dashboard page
        dashboardPage = new DashboardPageObject();
        dashboardPage.clickToAdminPage();

        adminPage = new AdminPageObject();
        adminPage.enterToUsername(admin);

        adminPage.clickToUserRole();

        adminPage.enterToEmployeename(employee);

        adminPage.clickToStatus();

        adminPage.clickToSearchButton();

        Assert.assertEquals(adminPage.getSearchValue(),"(1) Record Found");

//        waitForElementClickable(driver, "//span[text()='Admin']");
//        clickToElement(driver, "//span[text()='Admin']");
//
//        sendKeyToElement(driver, "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']", admin);
//
//        waitForElementClickable(driver, "//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]");
//        clickToElement(driver, "//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]");
//
//        waitForElementClickable(driver, "//div[@role='option']//span[text()='Admin']");
//        clickToElement(driver, "//div[@role='option']//span[text()='Admin']");
//
//        sendKeyToElement(driver, "//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input", employee);
//
//        waitForElementClickable(driver, "//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
//        clickToElement(driver, "//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
//
//        waitForElementClickable(driver, "//div[@role='option']//span[text()='Enabled']");
//        clickToElement(driver, "//div[@role='option']//span[text()='Enabled']");
//
//        waitForElementClickable(driver, "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
//        clickToElement(driver, "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
//
//        Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'orangehrm-vertical-padding')]/span"), "(1) Record Found");
    }

    private int generateRandomInt () {
        return new Random().nextInt(99999);
    }
}
