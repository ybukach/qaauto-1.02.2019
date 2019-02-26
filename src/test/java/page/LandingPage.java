package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

    public LandingPage() {

    }


    private WebDriver driver;

    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userMailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public <T> T login(String userEmail, String userPassword) {
        userMailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        if (driver.getCurrentUrl().contains("/feed/")) {
            return (T) new HomePage(driver);
        }
        if (driver.getCurrentUrl().contains("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")) {
            return (T) new LoginSubmitPage(driver);
        } else {
            return (T) new LandingPage(driver);
        }
    }


    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Войти или зарегистрироваться");

    }



}
