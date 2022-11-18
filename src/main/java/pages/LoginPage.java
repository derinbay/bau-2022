package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase {

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
