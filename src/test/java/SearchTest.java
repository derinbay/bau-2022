import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchTest extends TestBase {

    @Test
    public void testSearch() {
        //open homepage
        HomePage homePage = new HomePage(driver, wait);

        //in the searchbar i typed iphone
        //i clicked enter or press search button
        homePage.search("iphone");

        //check link
        System.out.println("dasda");

        //i scrolled down
        //check product names contains iphone. first x number product
        //nth product, i clicked -> check navigate to another page. product page
        //check if its in the new tab
    }
}
