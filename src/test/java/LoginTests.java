
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

    @Test(dataProvider = "validData")
    public void positiveLoginTestCorrectEmailCorrectPassword(String userEmail, String userPassword) {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");


    }

    @Test
    public void negativeLoginTestWrongEmailEmptyPasswordReturnedToLanding() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded());

        landingPage.Login("a@b.c", "");

        Assert.assertTrue(landingPage.isPageLoaded(), "landing page is not loaded");

    }

    @Test
    public void negativeLoginTestEmptyEmailWrongPassword() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("", "123");

        Assert.assertTrue(landingPage.isPageLoaded(), "landing page is not loaded");

    }

    @Test
    public void negativeLoginTestWrongEmailCorrectPassword() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("a@b.c", "Bukach2019");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");
    }

    @Test
    public void negativeLoginTestCorrectEmailWrongPassword() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("nct.test1@gmail.com", "111");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");
    }

    @Test
    public void negativeLoginTestCleansingCorrectEmailCleansingWrongPassword() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("      nct.test1@gmail.com     ", "     Bukach2019111     ");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");

    }

    @Test
    public void negativeLoginTestDifferentCaseInCorrectEmailDifferentCaseInCorrectPassword() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("Nct.test1@Gmail.Com", "BukacH2019");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");
    }

    @Test
    public void negativeLoginTestReturnedToLoginSubmitPage() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded());

        landingPage.Login("nct.test1@gmail.com", "111");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);

        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(),
                "Это неверный пароль. Повторите попытку или измените пароль.",
                "Wrong validation message for password field.");

    }


    }
