package com.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritance extends BasePage{

    private WebDriver driver;

    private String admin, employee, username, password;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        admin = "Admin";
        employee= "";
        username= "Admin";
        password = "admin123";
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void User_01_Register(){
        sendKeyToElement(driver, "//input[@name='username']", username);
        sendKeyToElement(driver, "//input[@name='password']", password);

        waitForElementClickable(driver, "//button[@type='submit']");
        clickToElement(driver, "//button[@type='submit']");

        isElementDisplayed(driver, "//span[text()='PIM']");
    }

    @Test
    public void User_02_Admin() throws InterruptedException {
        waitForElementClickable(driver, "//span[text()='Admin']");
        clickToElement(driver, "//span[text()='Admin']");

        sendKeyToElement(driver, "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']", admin);

        waitForElementClickable(driver, "//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]");
        clickToElement(driver, "//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]");

        waitForElementClickable(driver, "//div[@role='option']//span[text()='Admin']");
        clickToElement(driver, "//div[@role='option']//span[text()='Admin']");

        sendKeyToElement(driver, "//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input", employee);

        waitForElementClickable(driver, "//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
        clickToElement(driver, "//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");

        waitForElementClickable(driver, "//div[@role='option']//span[text()='Enabled']");
        clickToElement(driver, "//div[@role='option']//span[text()='Enabled']");

        waitForElementClickable(driver, "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
        clickToElement(driver, "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

        Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'orangehrm-vertical-padding')]/span"), "(1) Record Found");
        Thread.sleep(2000);
    }

    private int generateRandomInt () {
        return new Random().nextInt(99999);
    }
}
