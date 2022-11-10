import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/taylan.derinbay/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translation");
        options.addArguments("disable-automatic-password-saving");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.trendyol.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
