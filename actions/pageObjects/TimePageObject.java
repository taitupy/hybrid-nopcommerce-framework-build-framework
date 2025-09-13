package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.TimePageUI;

public class TimePageObject extends BasePage {
    private WebDriver driver;

    public TimePageObject(WebDriver driver) {
        this.driver = driver;
    }

}