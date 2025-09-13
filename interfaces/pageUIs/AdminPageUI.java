package pageUIs;

public class AdminPageUI {
    public static final String USERNAME_TEXTBOX = "//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']";
    public static final String USERNAME_ROLE_ADMIN_DROPDOWN = "//div[contains(@class, 'oxd-select-text') and contains(text(), '-- Select --')]";
    public static final String USERNAME_ROLE_ADMIN = "//div[@role='option']//span[text()='Admin']";
    public static final String EMPLOYEE_NAME_TEXTBOX = "//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input";
    public static final String STATUS_DROPDOWN = "//label[@class='oxd-label' and text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String STATUS_ENABLE = "//div[@role='option']//span[text()='Enabled']";
    public static final String SEARCH_BUTTON = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    public static final String ADMIN_SEARCH_SUCCESS_MESSAGE = "//div[contains(@class, 'orangehrm-vertical-padding')]/span";

}
