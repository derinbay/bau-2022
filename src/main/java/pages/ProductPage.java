package pages;

import bases.PageBase;
import org.openqa.selenium.By;

public class ProductPage extends PageBase {

    public ProductPage() {
    }

    public String getProductTitle() {
        return getText(By.cssSelector(".pr-new-br span"));
    }
}
