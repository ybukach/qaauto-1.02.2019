import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.setProperty("webdriver.chrome.driver","/Users/yulia.bukach/Downloads/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchField =driver.findElement(By.name("q"));

        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='srg']/div"));
        System.out.println("Search results count: " + searchResultElements.size());
        System.out.println("\n");


            for (int i = 0; i < searchResultElements.size(); i++) {
               WebElement element =searchResultElements.get(i);
               String strg=element.getText();
                if (strg.contains("Selenium")) {
                    System.out.printf(i + "\"searchTerm found!!!\"\n");
                    System.out.println(strg);} else  System.out.printf("\"searchTerm NOT found :(\" \n"); System.out.println(strg);
                    System.out.println("\n");

            }


        }

    }


/*getText().equalsIgnoreCase("auto"))*/