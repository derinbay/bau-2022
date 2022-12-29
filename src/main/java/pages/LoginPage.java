package pages;

import bases.PageBase;
import lombok.Getter;
import models.User;
import org.openqa.selenium.By;

@Getter
public class LoginPage extends PageBase {

    String url = "https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F";

    By errorBoxWrapper = By.id("error-box-wrapper");
    By loginEmailTextBox = By.id("login-email");
    By loginPasswordTextBox = By.id("login-password-input");
    By submitButton = By.className("submit");

    public LoginPage() {
    }

    public HomePage login(User user) {
        sendKeys(loginEmailTextBox, user.getEmail());
        sendKeys(loginPasswordTextBox, user.getPassword());
        click(submitButton);

        return new HomePage();
    }
}
