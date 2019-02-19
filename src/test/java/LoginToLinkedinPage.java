
import org.openqa.selenium.WebDriver;

public class LoginToLinkedinPage {
    private WebDriver driver;


    public LoginToLinkedinPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isLoginToLinkedinPageLoaded() {
        return driver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && driver.getTitle().contains("Войти в LinkedIn");
    }

}
