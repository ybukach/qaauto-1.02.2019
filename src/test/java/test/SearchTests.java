package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.util.List;

public class SearchTests extends BaseTest {
    String userEmail = "nct.test1@gmail.com";
    String userPassword = "Bukach2019";
    String searchTerm = "HR";

    /**
     * Verify basic search functionality
     * Scenario:
     * - Open new Browser
     * - Navigate to http://www.linkedin.com
     * - Verify that Landing page is loaded
     * - Login with valid credentials
     * - Verify that Home page is loaded
     * - Search for "HR" search term
     * - Verify that Search page is loaded
     * - Verify that numbers of search results is 10
     * - Verify that each search result contains search term
     */
    @Test
    public void basicSearchTest() {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(), "Search page is not loaded.");

        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page did not load.");

        Assert.assertEquals((searchPage.getSearchResultCount()), 10, "Search results count is wrong");

        List<String> searchResultsList = searchPage.getSearchResultsList();

        for (String searchResult: searchResultsList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "Search Term"+searchTerm+" not fount in:\n" +searchResult);
        }
    }

}
