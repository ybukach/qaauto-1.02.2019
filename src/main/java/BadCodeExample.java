import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.setProperty("webdriver.chrome.driver","/Users/yulia.bukach/Downloads/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchField =driver.findElement(By.name("q"));
        String searchTerm = "Selenuim";

        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='srg']/div"));
        System.out.println("Search results count: " + searchResultElements.size());

        //For each WeElement in SerachREsultElements print text

        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText ();
            System.out.println(searchResultElementText);
            if (searchResultElementText.toLowerCase().contains(searchTerm)) {
                System.out.println("searchTerm found");
            } else {
                System.out.println("searchTerm not found");
            }

        }
            }
    }

