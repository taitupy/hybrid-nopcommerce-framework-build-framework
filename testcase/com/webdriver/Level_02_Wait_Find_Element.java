package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Level_02_Wait_Find_Element {

    WebDriver driver;
    WebDriverWait explicitWait; // wait tuong minh


    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    }

    @Test
    public void TC_01_FindElement(){
        // TH 01 - Tim duy nhat 1 element
        // Tra ve dung element do
        // Ko can cho het time cua implicit
        driver.findElement(By.xpath("//input[@id=123abc]"));

        // TH 02 - Tim thay nhieu hon 1 element
        // chi thao tac vs element dau tien
        // luu y: khi lay locator nen check truoc
        driver.findElement(By.xpath("//input[@id=123abc]"));

        // TH 03 - Ko tim thay element nao
        // moi dau find element, sau 0.5s tim lai
        // sau 13s thi danh fail testcase
        // show loi: No such element
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@id=123abc]"));
    }

    @Test
    public void TC_02_FindElements(){
        // TH 01 - Tim duy nhat 1 element
        // Tra ve dung 1 cai
        List<WebElement> elememnt = null;
        elememnt = driver.findElements(By.xpath("//input[@id=123abc]"));
        System.out.println("Total = "+ elememnt.size());

        // TH 02 - Tim thay nhieu hon 1 element
        // Tra ve toan bo cac element matching
        elememnt = driver.findElements(By.xpath("//input[type='text']"));
        System.out.println("Total = "+ elememnt.size());

        // TH 03 - Ko tim thay element nao
        // Tim lai het 13s ko thay element nao het, thi:
        // Tra ve List element = 0
        // KO DANH FAIL TESTCASE
        elememnt = driver.findElements(By.xpath("//input[type='text']"));
        System.out.println("Total = "+ elememnt.size());
        Assert.assertEquals(elememnt.size(), 0);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
