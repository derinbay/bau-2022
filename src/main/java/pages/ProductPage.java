package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends PageBase {

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getProductTitle() {
        return getText(By.cssSelector(".pr-new-br span"));
    }
}
