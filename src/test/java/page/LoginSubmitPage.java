package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object class for LoginSubmit page
 */
public class LoginSubmitPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='error-for-password']")
    private WebElement passwordValidationMessage;

    @FindBy(xpath = "//div[@id='error-for-username']")
    private WebElement emailValidationMessage;

    @FindBy(xpath = "//form[@class='login__form']")
    private WebElement loginForm;


    /**
     * Constructor for Home Page.
     * @param driver - Webdriver instance from BaseTest
     */
    public LoginSubmitPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method that check if page is loaded
     * @return true/false
     */
    public boolean isPageLoaded() {
        return loginForm.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && driver.getTitle().equals("Войти в LinkedIn");
    }

    public String getPasswordValidationMessageText() {
        return passwordValidationMessage.getText();
    }

    public String getEmailValidationMessageText() {
        return emailValidationMessage.getText();
    }
}
