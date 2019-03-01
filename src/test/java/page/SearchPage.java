package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultsTotal;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return searchResultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("/search/results")
                && driver.getTitle().contains("| Поиск | LinkedIn");
    }


    public void getSearchResultsList() {
        List<WebElement> resultsList = driver.findElements(By.xpath("//h3[contains(@class, 'search-result__title')]"));
        int sizeOfList = resultsList.size();
        System.out.println("Size of List: "+ sizeOfList);

        for (WebElement element : resultsList) {
            System.out.println(element.getText());
        }
    }
}
