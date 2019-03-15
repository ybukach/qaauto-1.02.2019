package page;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * Page Object class for Home page
 */
public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//Li[@id='profile-nav-item']")
    private WebElement profileNavMenuItem;

    @FindBy(xpath = "//form[@id='extended-nav-search']//input")
    private WebElement searchField;

    /**
     * Constructor for Home Page.
     * @param driver - Webdriver instance from BaseTest
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method that check if page is loaded
     * @return true/false
     */
    public boolean isPageLoaded() {
        return profileNavMenuItem.isDisplayed()
                && driver.getCurrentUrl().contains("/feed/")
                && driver.getTitle().contains("LinkedIn");
    }

    /**
     * Method that perform search
     * @param searchTerm search query
     * @return page with search results
     */
    public SearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        return new SearchPage(driver);
    }


}
