package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Skip {
    WebDriver driver;

    @Test
    public void TC_ShouldbeCreate(){
        System.out.println("Run TC 01");
    }

    @Test
    public void TC_ShouldbeDelete(){
        System.out.println("Run TC 02");
    }

    @Test(enabled = false)
    public void TC_ShouldbeUpdate(){
        System.out.println("Run TC 03");
    }
}
