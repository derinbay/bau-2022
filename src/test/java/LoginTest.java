import DataHelper.UserPool;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static DataHelper.UserPool.failUser;
import static DataHelper.UserPool.validUser;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {

    /*
     * 1- Set the data or provide the data
     * 2- Actions
     * 3- Assertion
     * */
    @Test
    public void testLogin() {
        User user = validUser();
        HomePage homePage = new HomePage(driver, wait);
        LoginPage loginPage = homePage.goToLoginPage();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F");

        homePage = loginPage.login(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("circled-slider")));

        currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.trendyol.com/butik/liste/1/kadin");
    }

    @Test
    public void testFailedLogin() {
        User user = failUser();
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToLoginPage();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(user);

        String warningText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-box-wrapper"))).getText();
        assertEquals(warningText, "E-posta adresiniz ve/veya şifreniz hatalı.");
    }
}
