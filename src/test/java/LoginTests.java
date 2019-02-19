
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void negativeLoginTestWrongEmailEmptyPasswordReturnedToLanding() {

        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded());

        landingPage.Login("a@b.c", "");

        Assert.assertTrue(landingPage.isPageLoaded(), "landing page is not loaded");

    }

    @Test


    public void positiveLoginTestCorrectEmailCorrectPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("nct.test1@gmail.com", "Bukach2019");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

    }

    @Test
    public void negativeLoginTestEmptyEmailWrongPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("", "123");

        Assert.assertTrue(landingPage.isPageLoaded(), "landing page is not loaded");

    }

    @Test
    public void negativeLoginTestWrongEmailCorrectPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("a@b.c", "Bukach2019");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");
    }

    @Test
    public void negativeLoginTestCorrectEmailWrongPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("nct.test1@gmail.com", "111");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");
    }

    @Test
    public void negativeLoginTestCleansingCorrectEmailCleansingWrongPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("      nct.test1@gmail.com     ", "     Bukach2019111     ");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");

    }

    @Test
    public void negativeLoginTestDifferentCaseInCorrectEmailDifferentCaseInCorrectPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("Nct.test1@Gmail.Com", "BukacH2019");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "loginSubmitPage page is not loaded.");
    }

    @Test
    public void negativeLoginTestReturnedToLoginSubmitPage() {

        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded());

        landingPage.Login("nct.test1@gmail.com", "111");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);

        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(),
                "Это неверный пароль. Повторите попытку или измените пароль.",
                "Wrong validation message for password field.");

    }


    }
