package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LandingPage;

/**
 * This base test will be used in the beginning of other tests
 */
public class BaseTest  {
    WebDriver driver;
    LandingPage landingPage;


    /**
     * This method will be run before test
     */
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/Users/yulia.bukach/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        landingPage = new LandingPage(driver);
        //loginSubmitPage = new page.LoginSubmitPage(driver);
    }

    /**
     * This method will be run at the end of test
     */
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
