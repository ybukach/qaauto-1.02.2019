import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public LandingPage() {

    }


    private WebDriver driver;
    private WebElement signInButton;
    private WebElement userMailField;
    private WebElement userPasswordField;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        userMailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
    }


    public void Login(String userEmail, String userPassword) {
        userMailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }


    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Войти или зарегистрироваться");

            }


}
