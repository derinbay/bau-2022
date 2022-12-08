package pages;

import lombok.Getter;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class LoginPage extends PageBase {

    String url = "https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F";

    By errorBoxWrapper = By.id("error-box-wrapper");
    By loginEmailTextBox = By.id("login-email");
    By loginPasswordTextBox = By.id("login-password-input");
    By submitButton = By.className("submit");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomePage login(User user) {
        sendKeys(loginEmailTextBox, user.getEmail());
        sendKeys(loginPasswordTextBox, user.getPassword());
        click(submitButton);

        return new HomePage(driver, wait);
    }
}
