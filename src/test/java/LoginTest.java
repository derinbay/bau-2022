import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        /*
         * 1- Set the data or provide the data
         * 2- Actions
         * 3- Assertion
         * */
        goToLoginPage();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F");

        login("Asddasdaasd@Dasd.com", "1234qwe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("circled-slider")));

        currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.trendyol.com/butik/liste/1/kadin");
        assertTrue(currentUrl.contains("kadin"));
    }

    @Test
    public void testFailedLogin() {
        goToLoginPage();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F");

        login("Asddasdaasd@Dasd.com", "1234qwedasg");

        String warningText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-box-wrapper"))).getText();
        assertEquals(warningText, "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    private void goToLoginPage() {
        driver.findElement(By.className("modal-close")).click();
        driver.findElement(By.className("user-login-container")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-register")));
    }

    private void login(String email, String password) {
        driver.findElement(By.id("login-email")).sendKeys(email);
        driver.findElement(By.id("login-password-input")).sendKeys(password);
        driver.findElement(By.className("submit")).click();
    }

    //Page object model
    //HomePage, LoginPage, SearchPage
}
