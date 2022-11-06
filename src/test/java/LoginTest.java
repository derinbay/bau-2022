import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void testLogin() throws InterruptedException {
        /*
        * 1- Set the data or provide the data
        * 2- Actions
        * 3- Assertion
        * */

        //opens the browser
        System.setProperty("webdriver.chrome.driver", "/Users/taylan.derinbay/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translation");
        options.addArguments("disable-automatic-password-saving");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //go to trendyol
        driver.get("https://www.trendyol.com");

        //close gender popup or select a gender
        WebElement closeModalButton = driver.findElement(By.className("modal-close"));
        closeModalButton.click();

        //clicks login button
        WebElement loginElement = driver.findElement(By.className("user-login-container"));
        loginElement.click();

        //checks login page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F");

        //write email and password
        WebElement emailTextBox = driver.findElement(By.id("login-email"));
        emailTextBox.sendKeys("Asddasdaasd@Dasd.com");

        WebElement passwordTextBox = driver.findElement(By.id("login-password-input"));
        passwordTextBox.sendKeys("1234qwe");

        //click login button
        WebElement loginButton = driver.findElement(By.className("submit"));
        loginButton.click();

        //*
        // Waits until ...
        // ImplicitWait
        // ExplicitWait
        // FluentWait
        // **/
        
        //wait until URL changes to https://www.trendyol.com/butik/liste/2/erkek
        Wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/butik/liste/2/erkek"));

        //redirect to homepage --> assertion
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.trendyol.com/butik/liste/2/erkek");

        //check homepage gender
        Assert.assertTrue(currentUrl.contains("erkek"));

        driver.quit();
    }
}
