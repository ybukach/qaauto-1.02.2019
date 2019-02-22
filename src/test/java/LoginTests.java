
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;

    @BeforeMethod
    public void  beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"nct.test1@gmail.com", "Bukach2019"},
                {"NCT.test1@gmail.com", "Bukach2019"},
                {"  nct.test1@gmail.com", "Bukach2019"},
        };
    }

    @DataProvider
    public Object[][] invalidData1() {
        return new Object[][]{
                {"a@b.c", ""},
                {"", "123"},
        };
    }



    @Test(dataProvider = "validData")
    public void positiveLoginTestReturnedToHomePage(String userEmail, String userPassword) {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

    }

    @Test(dataProvider = "invalidData1")
    public void negativeLoginTestReturnedToLandingPage(String userEmail, String userPassword) {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login(userEmail, userPassword);

        Assert.assertTrue(landingPage.isPageLoaded(), "landing page is not loaded");

    }

    @DataProvider
    public Object[][] invalidData2() {
        return new Object[][]{
                {"nct.test1@gmail.com", "123",  "", "Это неверный пароль. Повторите попытку или измените пароль."},
                //{"a@b.c", "Bukach2019", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку."},
                // {"      nct.test1@gmail.com     ", "     Bukach2019111     ", "Это неверный пароль. Повторите попытку или измените пароль."},
                //{"Nct.test1@Gmail.Com", "BukacH2019", "Это неверный пароль. Повторите попытку или измените пароль."},
        };
    }

    @Test(dataProvider = "invalidData2")
    public void negativeLoginTestReturnedToLoginSubmitPage(String userEmail, String userPassword,
                                                           String emailValidationMessage, String passwordValidationMessage ) {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login(userEmail, userPassword);

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");
        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(),
                passwordValidationMessage,
                "Wrong validation message for password field.");
        Assert.assertEquals(loginSubmitPage.getEmailValidationMessageText(),
                emailValidationMessage,
                "Wrong validation message for email field.");

    }




    }
