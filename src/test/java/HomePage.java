import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    WebElement profileNavMenuItem;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        profileNavMenuItem = driver.findElement(By.xpath("//Li[@id='profile-nav-item']"));
    }


    public boolean isPageLoaded() {
        return profileNavMenuItem.isDisplayed()
                && driver.getCurrentUrl().contains("/feed/")
                && driver.getTitle().contains("LinkedIn");
    }
}