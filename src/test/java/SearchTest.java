import DataHelper.ProductPool;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;
import java.util.Locale;

import static DataHelper.ProductPool.TestProduct;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends TestBase {

    @Test
    public void testSearch() {
        //open homepage//
        //in the searchbar i typed iphone//
        //i clicked enter or press search butto//
        //check link//
        //i scrolled down
        //check product names contains iphone. first x number product//
        //nth product, i clicked -> check navigate to another page. product page//
        //check if its in the new tab

        HomePage homePage = new HomePage(driver, wait);
        Product product=TestProduct();

        String productText=homePage.sendKeyToSearchBox(product.getProductName());
        assertTrue(productText.contains(product.getProductName()));
        /*
        String searchText="Iphone";
        WebElement searchElement=driver.findElement(By.className("vQI670rJ"));
        searchElement.sendKeys(searchText);
        WebElement searchButton=driver.findElement(By.className("ft51BU2r"));
        searchButton.click();
        */


        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://www.trendyol.com/sr?q=Iphone&qt=Iphone&st=Iphone&os=1");

        /*
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement overlayElement=driver.findElement(By.className("overlay"));
        overlayElement.click();
         */

        //WebElement productElement=driver.findElements(By.className("p-card-wrppr")).get(5);
        //String productText=productElement.findElement(By.className("prdct-desc-cntnr-name")).getText();
        //Assert.assertTrue(productText.contains(searchText));

        /*
        List<WebElement> elements = driver.findElements(By.className("p-card-wrppr"));
        WebElement productElement=elements.get(0);
         */


    }
}
