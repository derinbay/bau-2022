package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Getter
public class HomePage extends PageBase {

    String url = "https://www.trendyol.com/butik/liste/1/kadin";
    By userLoginContainer = By.className("user-login-container");
    By circledSlider = By.className("circled-slider");


    //Search Test
    By searchBox=By.className("vQI670rJ");
    By searchButton=By.className("ft51BU2r");
    By overlayElement=By.className("overlay");

    By productCardElement= By.className("p-card-wrppr");

    By productCardName=By.className("prdct-desc-cntnr-name");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoginPage goToLoginPage() {
        click(userLoginContainer);
        wait.until(visibilityOfElementLocated(By.id("login-register")));

        return new LoginPage(driver, wait);
    }

    public String sendKeyToSearchBox(String _text){
        sendKeys(searchBox,_text);
        click(searchButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        click(overlayElement);

        String productText =getElements(productCardElement).get(0).findElement(productCardName).getText();

        click(getElements(productCardElement).get(7));
        return productText;

    }

}
