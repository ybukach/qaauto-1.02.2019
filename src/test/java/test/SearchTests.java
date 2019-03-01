package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.util.List;

public class SearchTests extends BaseTest {
    String userEmail = "nct.test1@gmail.com";
    String userPassword = "Bukach2019";
    String searchTerm = "Наталья";

    @Test
    public void basicSearchTest()
    {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(), "Search page is not loaded.");

       SearchPage searchPage = homePage.search(searchTerm);
       Assert.assertTrue(searchPage.isPageLoaded(), "Search page did not load.");

        List<WebElement> resultsList = driver.findElements(By.xpath("//*[@class='search-result__wrapper']"));
        int sizeOfList = resultsList.size();
        System.out.println("Size of List: "+ sizeOfList);

        for (WebElement element : resultsList) {
            //System.out.println(element.getText());
          Assert.assertTrue(element.getText().contains(searchTerm),
          "Введенное в поиске значение не совпадает с результатом поиска");

        };






    }

}
