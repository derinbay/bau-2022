import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTest extends TestBase {

    @Test
    public void testSearch() {
        HomePage homePage = new HomePage(driver, wait);
        SearchResultPage searchResultPage = homePage.search("iphone");

        searchResultPage.pageDown();
        searchResultPage.closeOverlay();

        List<String> productNames = searchResultPage.productNames();
        assertThat(productNames, (everyItem(containsStringIgnoringCase("iphone"))));

        //get data id of product
        //click product
        //check new page url includes data-id

        //nth product, i clicked -> check navigate to another page. product page
        //check if it opened the correct product
    }
}
