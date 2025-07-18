package com.webdriver;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_Wait_Element_Status {

    WebDriver driver;
    WebDriverWait explicitWait; // wait tuong minh


    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void User_01_Visible(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 01- Element co tren UI va co trong cay HTML
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
    }

    @Test
    public void User_02_Invisible(){
        // 02- Ko co UI, nhung van co trong cay HTML

        // 03- Ko co UI, ko co trong cay HTML

    }

    @Test
    public void User_03_Presence(){
        // 01- Element co tren UI va co trong cay HTML

        // 02- Ko co UI, co trong cay HTML

    }

    @Test
    public void User_04_Staleness(){
        // Tai thoi diem nay co Email Confirm
        WebElement confirmEmail = driver.findElement(By.xpath(""));

        driver.findElement(By.xpath("")).click();

        // 04- Khong co UI, va ko con trong HTML
        explicitWait.until(ExpectedConditions.stalenessOf(confirmEmail));

        // or wait invisible thay cho Staleness
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
