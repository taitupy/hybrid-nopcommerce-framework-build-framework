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

public class Level_02_BasePage_I_Init {

    private WebDriver driver;

    BasePage basePage; //declare

    private String admin, employee, username, password;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        basePage = new BasePage();

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
        basePage.sendKeyToElement(driver, "//input[@name='username']", username);
        basePage.sendKeyToElement(driver, "//input[@name='password']", password);

        basePage.waitForElementClickable(driver, "//button[@type='submit']");
        basePage.clickToElement(driver, "//button[@type='submit']");

//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

        basePage.isElementDisplayed(driver, "//span[text()='PIM']");
//        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='PIM']")).isDisplayed());
    }

    @Test
    public void User_02_Admin() throws InterruptedException {
        basePage.waitForElementClickable(driver, "//span[text()='Admin']");
        basePage.clickToElement(driver, "//span[text()='Admin']");
//        driver.findElement(By.xpath("//span[text()='Admin']")).click();

        basePage.sendKeyToElement(driver, "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']", admin);
//        driver.findElement(By.xpath("//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")).sendKeys(admin);

        basePage.waitForElementClickable(driver, "//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]");
        basePage.clickToElement(driver, "//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]");
//        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]")).click();

        basePage.waitForElementClickable(driver, "//div[@role='option']//span[text()='Admin']");
        basePage.clickToElement(driver, "//div[@role='option']//span[text()='Admin']");
//        driver.findElement(By.xpath("//div[@role='option']//span[text()='Admin']")).click();

        basePage.sendKeyToElement(driver, "//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input", employee);
//        driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input")).sendKeys(employee);

        basePage.waitForElementClickable(driver, "//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
        basePage.clickToElement(driver, "//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
//        driver.findElement(By.xpath("//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")).click();

        basePage.waitForElementClickable(driver, "//div[@role='option']//span[text()='Enabled']");
        basePage.clickToElement(driver, "//div[@role='option']//span[text()='Enabled']");
//        driver.findElement(By.xpath("//div[@role='option']//span[text()='Enabled']")).click();

        basePage.waitForElementClickable(driver, "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
        basePage.clickToElement(driver, "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
//        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();

        Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class, 'orangehrm-vertical-padding')]/span"), "(1) Record Found");
//        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'orangehrm-vertical-padding')]/span")).getText(),"(1) Record Found");
        Thread.sleep(7000);
    }

    private int generateRandomInt () {
        return new Random().nextInt(99999);
    }
}
