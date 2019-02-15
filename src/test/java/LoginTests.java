import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void negativeLoginTest() {

        String expectedURL = "https://www.linkedin.com/";

        System.setProperty("webdriver.chrome.driver","/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        //LinkedIn: Войти или зарегистрироваться
                Assert.assertEquals(driver.getTitle(),"LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");

                LandingPage landingPage = new LandingPage(driver);
                landingPage.Login("a@b.c", "");


        System.out.println(landingPage.isPageLoaded());

        Assert.assertTrue(landingPage.isPageLoaded());

    }

    @Test
    public void positiveLoginTest() {

        String expectedURL = "https://www.linkedin.com/";

        System.setProperty("webdriver.chrome.driver","/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        //LinkedIn: Войти или зарегистрироваться
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");

        LandingPage landingPage = new LandingPage(driver);
        landingPage.Login("nct.test1@gmail.com", "Bukach2019");


        System.out.println(landingPage.isPageLoaded());

        Assert.assertFalse(landingPage.isPageLoaded());

    }

}





















               /* My Scenario
               Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/", "URL is wrong");

               Assert.assertTrue(driver.findElement(By.id("login-submit")).isDisplayed());

                driver.findElement(By.id("login-email")).sendKeys("a@b.c");
                driver.findElement(By.id("login-password")).sendKeys("");
                driver.findElement(By.id("login-submit")).click();

                Assert.assertEquals(driver.getCurrentUrl(),"https://www.linkedin.com/");*/


               /*Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Login page URL is wrong");
               WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
               Assert.assertEquals(signInButton.isDisplayed(), true, "Sign in button is not displayed on Login page");
               Assert.assertTrue(signInButton.isDisplayed(), "Sign in button is not displayed on Login page");

               WebElement userMailField = driver.findElement(By.xpath("//input[@id='login-email']"));
               WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));

               userMailField.sendKeys("a@b.c");
               userPasswordField.sendKeys("");
               signInButton.click();

                Assert.assertEquals(driver.getTitle(),"LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
                Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Login page URL is wrong");
                Assert.assertEquals(signInButton.isDisplayed(), true, "Sign in button is not displayed on Login page");



    @Test
    public void successfulLoginTest() {
        String expectedURL = "https://www.linkedin.com/";
        System.setProperty("webdriver.chrome.driver","/Users/yulia.bukach/Downloads/chromedriver");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        Assert.assertEquals(driver.getTitle(),"LinkedIn: Войти или зарегистрироваться", "Login page title is wrong");
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Login page URL is wrong");

        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertEquals(signInButton.isDisplayed(), true, "Sign in button is not displayed on Login page");
        Assert.assertTrue(signInButton.isDisplayed(), "Sign in button is not displayed on Login page");

        WebElement userMailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));

        userMailField.sendKeys("nct.test1@gmail.com");
        userPasswordField.sendKeys("Bukach2019");
        signInButton.click();

       WebElement profileNavMenuItem = driver.findElement(By.xpath("//Li[@id='profile-nav-item']"));
       Assert.assertTrue(profileNavMenuItem.isDisplayed(), "Home page did not load after login");

       */


