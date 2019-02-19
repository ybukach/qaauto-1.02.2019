
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void negativeLoginTestWrongEmailEmptyPassword() {

        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded());

        landingPage.Login("a@b.c", "");

        Assert.assertTrue(landingPage.isPageLoaded(), "landing page is not loaded");

    }

    @Test


    public void positiveLoginTest() {
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

        LoginToLinkedinPage loginToLinkedinPage = new LoginToLinkedinPage(driver);

        Assert.assertTrue(loginToLinkedinPage.isLoginToLinkedinPageLoaded(), "Credentials validation is wrong");
    }

    @Test
    public void negativeLoginTestCorrectEmailWrongPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("nct.test1@gmail.com", "111");

        LoginToLinkedinPage loginToLinkedinPage = new LoginToLinkedinPage(driver);

        Assert.assertTrue(loginToLinkedinPage.isLoginToLinkedinPageLoaded(), "Credentials validation is wrong");
    }

    @Test
    public void negativeLoginTestCleansingCorrectEmailCleansingWrongPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("      nct.test1@gmail.com     ", "     Bukach2019111     ");

        LoginToLinkedinPage loginToLinkedinPage = new LoginToLinkedinPage(driver);

        Assert.assertTrue(loginToLinkedinPage.isLoginToLinkedinPageLoaded(), "Credentials validation is wrong");

    }

    @Test
    public void negativeLoginTestDifferentCaseInCorrectEmailDifferentCaseInCorrectPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.Login("Nct.test1@Gmail.Com", "BukacH2019");

        LoginToLinkedinPage loginToLinkedinPage = new LoginToLinkedinPage(driver);

        Assert.assertTrue(loginToLinkedinPage.isLoginToLinkedinPageLoaded(), "Credentials validation is wrong");
    }


}
