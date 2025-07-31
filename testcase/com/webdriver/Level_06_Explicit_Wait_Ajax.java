package com.webdriver;

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

public class Level_06_Explicit_Wait_Ajax {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Calendar(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // Wait and Verify element calendar is displayed
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='contentWrapper']"))).isDisplayed());

        // wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .textToBe(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"), "No Selected Dates to display.")));

        // Wait and click to element
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='31']"))).click();

        // wait cho ajax loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.xpath("//div[contains(@id, 'ContentPlaceholder1_RadCalendar1')]/div[@class='raDiv']"))));

        // wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .textToBe(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"), "Thursday, July 31, 2025")));
       }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
