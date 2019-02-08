import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWork1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/yulia.bukach/Downloads/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");

        /*WebElement element= ((ChromeDriver) driver).findElementById("q");*/

        /*WebElement element = ((ChromeDriver) driver).findElementByXPath("//*[@id=\"q\"]");*/

        WebElement element=((ChromeDriver) driver).findElementByName("q");
        element.sendKeys("Selenium");
        element.sendKeys(Keys.RETURN);
        /*List <WebElement> urls =driver.findElements(By.tagName("h3"));
        WebElement elementlink=((ChromeDriver) driver).findElementByTagName("h3");
        elementlink.click();*/
    }
}
