package com.nopcommerce.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_Repeat_Yourself {

    private WebDriver driver;

    private String admin, employee, username, password;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        admin = "Admin";
        employee= "";
//        emailAddress = "thomasmuller" + generateRandomInt() + "@gmail.com";
        username= "Admin";
        password = "admin123";
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void TC_01_Register(){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='PIM']")).isDisplayed());
    }

    @Test
    public void TC_02_Admin() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")).sendKeys(admin);
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]")).click();
        driver.findElement(By.xpath("//div[@role='option']//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input")).sendKeys(employee);
        driver.findElement(By.xpath("//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")).click();
        driver.findElement(By.xpath("//div[@role='option']//span[text()='Enabled']")).click();
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'orangehrm-vertical-padding')]/span")).getText(),"(1) Record Found");
        Thread.sleep(7000);
    }

//        int generateRandomInt () {
//            return new Random().nextInt(99999);
//        }
//    }
}
