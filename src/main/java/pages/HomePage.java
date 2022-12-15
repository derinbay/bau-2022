package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Getter
public class HomePage extends PageBase {

    String url = "https://www.trendyol.com/butik/liste/1/kadin";
    By userLoginContainer = By.className("user-login-container");
    By circledSlider = By.className("circled-slider");

    By searchBar = By.cssSelector("[data-testid=suggestion]");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoginPage goToLoginPage() {
        click(userLoginContainer);
        wait.until(visibilityOfElementLocated(By.id("login-register")));

        return new LoginPage(driver, wait);
    }

    public void search(String keyword) {
        sendKeys(searchBar, keyword + Keys.ENTER);
    }
}
