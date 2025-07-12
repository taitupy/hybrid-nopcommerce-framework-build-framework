package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AdminPageUI;
import pageUIs.HomePageUI;

public class AdminPageObject extends BasePage {
    private WebDriver driver;

    public AdminPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsername(String admin) {
        waitForElementVisible(driver, AdminPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, AdminPageUI.USERNAME_TEXTBOX, admin);
    }

    public void clickToUserRole() {
        waitForElementClickable(driver, AdminPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        clickToElement(driver, AdminPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);

        waitForElementClickable(driver, AdminPageUI.USERNAME_ROLE_ADMIN);
        clickToElement(driver, AdminPageUI.USERNAME_ROLE_ADMIN);
    }

    public void enterToEmployeeName(String employee) {
        waitForElementVisible(driver, AdminPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeyToElement(driver, AdminPageUI.USERNAME_TEXTBOX, employee);
    }

    public void clickToStatus() {
        waitForElementClickable(driver, AdminPageUI.STATUS_DROPDOWN);
        clickToElement(driver, AdminPageUI.STATUS_DROPDOWN);

        waitForElementClickable(driver, AdminPageUI.STATUS_ENABLE);
        clickToElement(driver, AdminPageUI.STATUS_ENABLE);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, AdminPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminPageUI.SEARCH_BUTTON);
    }

    public void adminSearchPage(String admin, String employee){
        waitForElementVisible(driver, AdminPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, AdminPageUI.USERNAME_TEXTBOX, admin);

        waitForElementClickable(driver, AdminPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        clickToElement(driver, AdminPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        waitForElementClickable(driver, AdminPageUI.USERNAME_ROLE_ADMIN);
        clickToElement(driver, AdminPageUI.USERNAME_ROLE_ADMIN);

        waitForElementVisible(driver, AdminPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeyToElement(driver, AdminPageUI.USERNAME_TEXTBOX, employee);

        waitForElementClickable(driver, AdminPageUI.STATUS_DROPDOWN);
        clickToElement(driver, AdminPageUI.STATUS_DROPDOWN);
        waitForElementClickable(driver, AdminPageUI.STATUS_ENABLE);
        clickToElement(driver, AdminPageUI.STATUS_ENABLE);

        waitForElementClickable(driver, AdminPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminPageUI.SEARCH_BUTTON);
    }

    public String getSearchValue() {
        waitForElementVisible(driver, AdminPageUI.ADMIN_SEARCH_SUCCESS_MESSAGE);
        return getElementText(driver, AdminPageUI.ADMIN_SEARCH_SUCCESS_MESSAGE);
    }
}
