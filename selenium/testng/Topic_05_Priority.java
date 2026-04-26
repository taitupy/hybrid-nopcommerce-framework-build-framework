package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Priority {
    WebDriver driver;

    @Test(priority = 1)
    public void TC_ShouldbeCreate(){
        System.out.println("Run TC 01");
    }

    @Test(priority = 3)
    public void TC_ShouldbeDelete(){
        System.out.println("Run TC 02");
    }

    @Test(priority = 2)
    public void TC_ShouldbeUpdate(){
        System.out.println("Run TC 03");
    }
}
