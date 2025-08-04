package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_07_Explicit_Wait_Mix {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Less_Than() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        // Dieu kien Wait - element visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(), "Hello World!");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
