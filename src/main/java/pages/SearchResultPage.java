package pages;

import bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static bases.TestBase.getWait;

public class SearchResultPage extends PageBase {

    public SearchResultPage() {
    }

    public void closeOverlay() {
        click(By.className("overlay"));
    }

    public List<WebElement> getProducts() {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("p-card-wrppr")));
    }

    public List<WebElement> getProducts(By element) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public List<String> productNames() {
        List<WebElement> productNameElements = getProducts(By.className("prdct-desc-cntnr-name"));
        return productNameElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getDataId(WebElement element) {
        return element.getAttribute("data-id");
    }

    public WebElement getProduct(int index) {
        return getProducts().get(index);
    }
}
