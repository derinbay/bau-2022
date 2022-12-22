import models.User;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static DataHelper.UserPool.*;
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
        System.out.println("The thread ID for"+ Thread.currentThread().getStackTrace()[1].getMethodName() + "thread is "+ Thread.currentThread().getId());
        User user = validUser();
        HomePage homePage = new HomePage(driver, wait);
        LoginPage loginPage = homePage.goToLoginPage();

        String currentUrl = loginPage.getCurrentUrl();
        assertEquals(currentUrl, loginPage.getUrl());

        homePage = loginPage.login(user);
        homePage.waitForPageLoad(homePage.getCircledSlider());

        currentUrl = homePage.getCurrentUrl();
        assertEquals(currentUrl, homePage.getUrl());
    }

    @Test
    public void testFailedLogin() {
        System.out.println("The thread ID for"+ Thread.currentThread().getStackTrace()[1].getMethodName() + "thread is "+ Thread.currentThread().getId());
        User user = failUser();
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(user);

        String warningText = loginPage.getText(loginPage.getErrorBoxWrapper());
        assertEquals(warningText, "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test
    public void testEmptyPassword() {
        System.out.println("The thread ID for"+ Thread.currentThread().getStackTrace()[1].getMethodName() + "thread is "+ Thread.currentThread().getId());
        User user = failUserWithoutPassword();
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(user);

        String warningText = loginPage.getText(loginPage.getErrorBoxWrapper());
        assertEquals(warningText, "Lütfen şifrenizi giriniz.");
    }
}
