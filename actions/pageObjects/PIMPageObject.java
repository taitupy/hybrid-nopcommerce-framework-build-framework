package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.PIMPageUI;

public class PIMPageObject extends SidebarPageObject {
    private WebDriver driver;

    public PIMPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}