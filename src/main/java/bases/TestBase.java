package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    @BeforeMethod
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translation");
        options.addArguments("disable-automatic-password-saving");
        driver.set(new ChromeDriver(options));
        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(20)));
        getDriver().get("https://www.trendyol.com");
        closeModal();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    private void closeModal() {
        getDriver().findElement(By.className("modal-close")).click();
    }
}
