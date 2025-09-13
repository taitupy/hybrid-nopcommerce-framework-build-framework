package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.PIMPageUI;

public class PIMPageObject extends BasePage {
    private WebDriver driver;

    public PIMPageObject(WebDriver driver) {
        this.driver = driver;
    }

}