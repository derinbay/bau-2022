package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HomePage extends PageBase {

    By userLoginContainer = By.className("user-login-container");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoginPage goToLoginPage() {
        click(userLoginContainer);
        wait.until(visibilityOfElementLocated(By.id("login-register")));

        return new LoginPage(driver, wait);
    }
}
