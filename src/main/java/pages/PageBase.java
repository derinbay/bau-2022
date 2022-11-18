package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    WebDriver driver;
    WebDriverWait wait;

    public PageBase(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void sendKeys(WebElement elementToSendKeys, String input) {
        elementToSendKeys.sendKeys(input);
    }

    public void sendKeys(By elementToSendKeys, String input) {
        wait.until(ExpectedConditions.elementToBeClickable(elementToSendKeys))
                .sendKeys(input);
    }

    public void click(By elementToClick) {
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick))
                .click();
    }
}
