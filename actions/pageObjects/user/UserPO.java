package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserPageUI;

public class UserPO extends SidebarPO {
    private WebDriver driver;

    public UserPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToUsername(String admin) {
        waitForElementVisible(driver, UserPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, UserPageUI.USERNAME_TEXTBOX, admin);
    }

    public void clickToUserRole() {
        waitForElementClickable(driver, UserPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        clickToElement(driver, UserPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);

        waitForElementClickable(driver, UserPageUI.USERNAME_ROLE_ADMIN);
        clickToElement(driver, UserPageUI.USERNAME_ROLE_ADMIN);
    }

    public void enterToEmployeeName(String employee) {
        waitForElementVisible(driver, UserPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeyToElement(driver, UserPageUI.USERNAME_TEXTBOX, employee);
    }

    public void clickToStatus() {
        waitForElementClickable(driver, UserPageUI.STATUS_DROPDOWN);
        clickToElement(driver, UserPageUI.STATUS_DROPDOWN);

        waitForElementClickable(driver, UserPageUI.STATUS_ENABLE);
        clickToElement(driver, UserPageUI.STATUS_ENABLE);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, UserPageUI.SEARCH_BUTTON);
        clickToElement(driver, UserPageUI.SEARCH_BUTTON);
    }

    public void adminSearchPage(String admin, String employee){
        waitForElementVisible(driver, UserPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, UserPageUI.USERNAME_TEXTBOX, admin);

        waitForElementClickable(driver, UserPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        clickToElement(driver, UserPageUI.USERNAME_ROLE_ADMIN_DROPDOWN);
        waitForElementClickable(driver, UserPageUI.USERNAME_ROLE_ADMIN);
        clickToElement(driver, UserPageUI.USERNAME_ROLE_ADMIN);

        waitForElementVisible(driver, UserPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeyToElement(driver, UserPageUI.USERNAME_TEXTBOX, employee);

        waitForElementClickable(driver, UserPageUI.STATUS_DROPDOWN);
        clickToElement(driver, UserPageUI.STATUS_DROPDOWN);
        waitForElementClickable(driver, UserPageUI.STATUS_ENABLE);
        clickToElement(driver, UserPageUI.STATUS_ENABLE);

        waitForElementClickable(driver, UserPageUI.SEARCH_BUTTON);
        clickToElement(driver, UserPageUI.SEARCH_BUTTON);
    }

    public String getSearchValue() {
        waitForElementVisible(driver, UserPageUI.ADMIN_SEARCH_SUCCESS_MESSAGE);
        return getElementText(driver, UserPageUI.ADMIN_SEARCH_SUCCESS_MESSAGE);
    }


}
