package com.webdriver;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_08_Fluent_Wait {
    WebDriver driver;

    // <T>: data type
    FluentWait<WebDriver> driverFluentWait;
//    FluentWait<WebElement> elementFluentWait;
//    FluentWait<String> stringFluentWait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01_Element_Found() {
        driver.get("https://automationfc.github.io/dynamic-loading/");

        findElement(By.xpath("//div[@id='start']/button"));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    // viet 1 ham de tim element vs timeout/polling tu set
    // dk cua ham la findElement: kieu tra ve cua ham apply
    // findElement thi co driver: tham so cua ham apply
    public WebElement findElement(By by){
        driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofMillis(100))
                        .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }

    // Kiem tra 1 element hien thi
    // isDisplayed = boolean
    public boolean isElementDisplayed(By by) {
        driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

    // Co 1 element tu ben ngoai ko phai tim
    public boolean isElementDisplayed(WebElement element) {
        FluentWait<WebElement> driverFluentWait = new FluentWait<>(element);

        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.isDisplayed();
            }
        });
    }

    // Lay ra text element
    // getText = String
    public String getTextElement(By by) {
        driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(by).getText();
            }
        });
    }
}
