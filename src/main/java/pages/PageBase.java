package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.PAGE_DOWN;

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

    public void click(WebElement webElementToClick) {
        wait.until(ExpectedConditions.elementToBeClickable(webElementToClick))
                .click();
    }

    public void waitForPageLoad(By elementToCheck) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToCheck));
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getText(By elementToGetText) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementToGetText))
                .getText();
    }

    public void pageDown() {
        sendKeys(By.tagName("body"), String.valueOf(PAGE_DOWN));
    }

    public void switchNextTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
