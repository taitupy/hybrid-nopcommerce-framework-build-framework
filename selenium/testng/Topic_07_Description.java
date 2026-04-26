package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_07_Description {
    // Ten testcase = ham/function/method cua Java
    // Theo convention cua tung ngon ngu

    // Chu thich/dien giai/ note

    @Test(description = "JIRA#1368 - User can create new product and verify created success")
    public void TC_ShouldbeCreate(){
        System.out.println("Run TC 01");
    }

    @Test
    public void TC_ShouldbeDelete(){
        System.out.println("Run TC 02");
    }

    @Test
    public void TC_ShouldbeUpdate(){
        System.out.println("Run TC 03");
    }
}
