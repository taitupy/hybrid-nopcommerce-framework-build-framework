package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

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
}
