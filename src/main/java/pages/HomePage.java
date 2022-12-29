package pages;

import bases.PageBase;
import lombok.Getter;
import org.openqa.selenium.By;

import static bases.TestBase.getWait;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Getter
public class HomePage extends PageBase {

    String url = "https://www.trendyol.com/butik/liste/1/kadin";
    By userLoginContainer = By.className("user-login-container");
    By circledSlider = By.className("circled-slider");

    By searchBar = By.cssSelector("[data-testid=suggestion]");

    public HomePage() {
    }

    public LoginPage goToLoginPage() {
        click(userLoginContainer);
        getWait().until(visibilityOfElementLocated(By.id("login-register")));

        return new LoginPage();
    }

    public SearchResultPage search(String keyword) {
        sendKeys(searchBar, keyword + ENTER);
        return new SearchResultPage();
    }
}
