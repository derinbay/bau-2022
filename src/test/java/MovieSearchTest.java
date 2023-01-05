import bases.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MovieSearchTest extends TestBase {

    @Test
    public void testSearch() {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.search("iphone");

        searchResultPage.pageDown();
        searchResultPage.closeOverlay();

        List<String> productNames = searchResultPage.productNames();
        assertThat(productNames, (everyItem(containsStringIgnoringCase("iphone"))));

        WebElement firstProduct = searchResultPage.getProduct(0);
        String firstProductId = searchResultPage.getDataId(firstProduct);
        searchResultPage.click(firstProduct);
        searchResultPage.switchNextTab();

        ProductPage productPage = new ProductPage();
        String pageProductTitle = productPage.getProductTitle();

        assertThat(pageProductTitle, is(equalTo(productNames.get(0))));
        assertThat(productPage.getCurrentUrl(), containsString(firstProductId));
    }

    //run all tests in parallel
    //keyword to check: testng
}
