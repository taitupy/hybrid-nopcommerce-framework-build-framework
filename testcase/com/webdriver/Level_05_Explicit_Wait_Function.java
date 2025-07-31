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
import java.util.List;
import java.util.regex.Pattern;

public class Level_05_Explicit_Wait_Function {

    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();

        // Cach 1 - mac dinh polling = 0.5s
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Less_Than() throws InterruptedException {
        // wait cho element ko con ton tai trong DOM( truoc do co trong DOM)
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(""))));

        // wait cho element ko co trong UI ( co / ko co trong DOM)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));

        // wait cho element dc hien thi ( co trong DOM va trong UI)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

        // wait cho element dc phep click (button/ radio/link/ checkbox...)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

        // wait cho URL cua page tuyet doi
        explicitWait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/login?"));

        // wait cho URL cua page tuong doi
        explicitWait.until(ExpectedConditions.urlContains("dynamic-loading"));

        // wait cho thoa 2 dk  (AND)
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains(""), ExpectedConditions.titleIs("")));

        // wait cho thoa man 1 trong 2 dk (OR)
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains(""), ExpectedConditions.titleIs("")));

        // wait cho 1 element xuat hien trong DOM
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

       // wait cho 1 element co thuoc tinh chua 1 gia tri nao do
       explicitWait.until(ExpectedConditions.attributeContains(By.xpath(""), "class", "email"));

        // wait cho 1 element co thuoc tinh bang 1 gia tri nao do
        explicitWait.until(ExpectedConditions.attributeToBe(By.xpath(""), "class", "email"));

        // wait cho 1 element co thuoc tinh ko dc rong/ hoac null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.xpath("")), "class"));

        // wait cho element da dc chon thanh cong ( checkbox/ radio/ dropdown Item...)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));

        // wait cho element da dc chon thanh cong
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(""), true));

        // wait cho element chua dc chon thanh cong
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(""), false));

        // wait cho frame/ iframe xuat hien va switch vao
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("")));

        // wait cho 1 doan lenh JS dc thu thi va ko tra ve bat cu ki Exception nao
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return arguments[0].validationMessage"));

        // phu dinh lai dk cua wait
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.javaScriptThrowsNoExceptions("return arguments[0].validationMessage")));

        // wait cho 1 list element ban bn item
        List<WebElement> allNumberSelected = explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(""), 6));
        Assert.assertEquals(allNumberSelected.size(), 6);

        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(""), 5));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath(""), 7));

        // wait cho so luong windws/ tab bang bn
        explicitWait.until(ExpectedConditions.textToBe(By.xpath(""), ""));

        // wait cho 1 doan text bang tuyet doi
        explicitWait.until(ExpectedConditions.textToBe(By.xpath(""), ""));
        explicitWait.until(ExpectedConditions.textMatches(By.xpath(""), Pattern.compile("a*b")));

        // wait cho 1 element hay bi refresh/ change/ update lai
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.numberOfWindowsToBe(3)));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
