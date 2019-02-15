import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public LandingPage() {

    }


    WebDriver driver;
    WebElement signInButton;
    WebElement userMailField;
    WebElement userPasswordField;
    WebElement profileNavMenuItem;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        userMailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        //profileNavMenuItem = driver.findElement(By.xpath("//Li[@id='profile-nav-item']"));


    }


    public void Login(String userEmail, String userPassword) {
        userMailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }


    public boolean isPageLoaded() {
        boolean booleanFlag= true;
        if (signInButton.isDisplayed())
        {booleanFlag= true;}
        else
        {booleanFlag = false;}
        return booleanFlag;

            }





    /*static void sum(int x, int y){

        int z = x + y;
        System.out.println(z);
    }*/

}
