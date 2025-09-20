package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.TimePageUI;

public class TimePageObject extends SidebarPageObject {
    private WebDriver driver;

    public TimePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}