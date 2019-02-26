package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

public class SearchTests extends BaseTest {
    String userEmail = "nct.test1@gmail.com";
    String userPassword = "Bukach2019";
    String searchTerm = "HR";

    @Test
    public void basicSearchTest()
    {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(), "Search page is not loaded.");

       SearchPage searchPage = homePage.search(searchTerm);
       Assert.assertTrue(searchPage.isPageLoaded(), "Search page did not load.");


    }

}
