package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LandingPage;
import page.LoginSubmitPage;

public class LoginTests extends BaseTest {


    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"nct.test1@gmail.com", "Bukach2019"},
                // {"NCT.test1@gmail.com", "Bukach2019"},
                // {"  nct.test1@gmail.com", "Bukach2019"},
        };
    }
    @Test(dataProvider = "validData")
    public void successfulLoginTestReturnedToHomePage(String userEmail, String userPassword) {

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

       HomePage homePage = landingPage.login(userEmail, userPassword);

       Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

    }

    @DataProvider
    public Object[][] invalidData1() {
        return new Object[][]{
                {"a@b.c", ""},
                {"", "123"},
        };
    }
    @Test(dataProvider = "invalidData1")
    public void negativeLoginTestReturnedToLandingPage(String userEmail, String userPassword) {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.login(userEmail, userPassword);

        Assert.assertTrue(landingPage.isPageLoaded(), "landing page is not loaded");

    }

    @DataProvider
    public Object[][] invalidData2() {
        return new Object[][]{
                {"nct.test1@gmail.com", "123", "", "Это неверный пароль. Повторите попытку или измените пароль."},
                {"a@b.c", "Bukach2019", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""},
                // {"      nct.test1@gmail.com     ", "     Bukach2019111     ", "", "Это неверный пароль. Повторите попытку или измените пароль."},
                //{"Nct.test1@Gmail.Com", "BukacH2019", "Это неверный пароль. Повторите попытку или измените пароль."},
        };
    }

    @Test(dataProvider = "invalidData2")
    public void negativeLoginTestReturnedToLoginSubmitPage(String userEmail, String userPassword,
                                                           String emailValidationMessage, String passwordValidationMessage) {

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        LoginSubmitPage loginSubmitPage = landingPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");
        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(),
                passwordValidationMessage,
                "Wrong validation message for password field.");
        Assert.assertEquals(loginSubmitPage.getEmailValidationMessageText(),
                emailValidationMessage,
                "Wrong validation message for email field.");

    }

}
