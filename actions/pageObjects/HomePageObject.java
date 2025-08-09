package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    // constructor
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    // Hàm khởi tạo (Constructor function)
    // 1- Cùng tên vs tên class
    // 2- Ko co kiểu trả ve(data type)
    // 3- Sẽ đc chạy đầu tiên khi class dc gọi (new HomePageObject)
    // 4- Có tham số hoặc ko tham số
    // 5- Ko tự define hàm khởi tạo thì JVM sẽ mặc định tạo ra 1 hàm khởi tạo rỗng


    public void enterToUsernameTextbox(String username) {
        waitForElementVisible(driver, HomePageUI.USERNAME);
        sendKeyToElement(driver, HomePageUI.USERNAME, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, HomePageUI.PASSWORD);
        sendKeyToElement(driver, HomePageUI.PASSWORD, password);
    }

    public void clickToDashboardPage() {
        waitForElementClickable(driver, HomePageUI.SUBMIT_BUTTON);
        clickToElement(driver, HomePageUI.SUBMIT_BUTTON);
    }

    // Viet 3 ham thanh 1 ham Login system - Cach chua quan ly Page Generator Manager - C1
//    public void systemLogin(String username, String password){
//        waitForElementVisible(driver, HomePageUI.USERNAME);
//        sendKeyToElement(driver, HomePageUI.USERNAME, username);
//
//        waitForElementVisible(driver, HomePageUI.PASSWORD);
//        sendKeyToElement(driver, HomePageUI.PASSWORD, password);
//
//        waitForElementClickable(driver, HomePageUI.SUBMIT_BUTTON);
//        clickToElement(driver, HomePageUI.SUBMIT_BUTTON);
//    }

//    // Viet theo Page Generator Manager -C2
//    public DashboardPageObject systemLogin(String username, String password){
//        waitForElementVisible(driver, HomePageUI.USERNAME);
//        sendKeyToElement(driver, HomePageUI.USERNAME, username);
//
//        waitForElementVisible(driver, HomePageUI.PASSWORD);
//        sendKeyToElement(driver, HomePageUI.PASSWORD, password);
//
//        waitForElementClickable(driver, HomePageUI.SUBMIT_BUTTON);
//        clickToElement(driver, HomePageUI.SUBMIT_BUTTON);
//
//        return new DashboardPageObject(driver);
//    }

    // Viet theo Page Generator Manager -C3
    public DashboardPageObject systemLogin(String username, String password){
        waitForElementVisible(driver, HomePageUI.USERNAME);
        sendKeyToElement(driver, HomePageUI.USERNAME, username);

        waitForElementVisible(driver, HomePageUI.PASSWORD);
        sendKeyToElement(driver, HomePageUI.PASSWORD, password);

        waitForElementClickable(driver, HomePageUI.SUBMIT_BUTTON);
        clickToElement(driver, HomePageUI.SUBMIT_BUTTON);

        return PageGenerator.getDashboardPage(driver); // vi tri 2 cach 3
    }
}
