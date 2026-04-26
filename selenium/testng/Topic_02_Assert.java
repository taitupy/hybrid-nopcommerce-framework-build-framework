package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Assert {
    WebDriver driver;

    @Test
    public void assertion(){
        // Assure true: kiem tra 1 dk mong doi no se tra ve la DUNG
        // Cac ham tra ve true/false
        // Selenium: isDisplayed/ isEnabled/ isSelected/ isMultiple
        // User Defined
        Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-login")).isDisplayed());

        // AsserFalse: kiem tra 1 dk mong doi no se tra ve la SAI
        //Mong doi login button la disabled

        Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());

        // AssertEqual: kiem tra 1 dk mong doi(expected) bang voi dk thuc te (actual)
        // getText/getAtrribute/getCss/getTitle/getUrl...
        Assert.assertEquals(driver.findElement(By.cssSelector("lablef[for='newsletter']")).getText(), "Dang ky nhan ban tin");
        Assert.assertEquals(driver.findElement(By.cssSelector("lablef[for='newsletter']")).getAttribute("placeholder"), "Nhap dia chi email");
        Assert.assertEquals(driver.findElement(By.cssSelector("lablef[for='newsletter']")).getSize(), "424");
    }


}
