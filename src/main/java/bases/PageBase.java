package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static bases.TestBase.getDriver;
import static bases.TestBase.getWait;
import static org.openqa.selenium.Keys.PAGE_DOWN;

public class PageBase {

    public PageBase() {
    }

    public void sendKeys(WebElement elementToSendKeys, String input) {
        elementToSendKeys.sendKeys(input);
    }

    public void sendKeys(By elementToSendKeys, String input) {
        getWait().until(ExpectedConditions.elementToBeClickable(elementToSendKeys))
                .sendKeys(input);
    }

    public void click(By elementToClick) {
        getWait().until(ExpectedConditions.elementToBeClickable(elementToClick))
                .click();
    }

    public void click(WebElement webElementToClick) {
        getWait().until(ExpectedConditions.elementToBeClickable(webElementToClick))
                .click();
    }

    public void waitForPageLoad(By elementToCheck) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(elementToCheck));
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getText(By elementToGetText) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(elementToGetText))
                .getText();
    }

    public void pageDown() {
        sendKeys(By.tagName("body"), String.valueOf(PAGE_DOWN));
    }

    public void switchNextTab() {
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }
}
