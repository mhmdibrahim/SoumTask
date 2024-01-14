import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginWithLockedOutPage {
    WebDriver driver;
    public LoginWithLockedOutPage(WebDriver driver)
    {
        this.driver = driver ;
    }
    protected  final By usernameField = By.id("user-name");
    protected  final By passwordField = By.id("password");
    protected  final By loginbtn = By.id("login-button");
    protected  final By error = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    //check login functionality  with lockedout Customer
    public void loginWithLockedOutUser(String username , String password)
    {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginbtn).click();
    }

    public String  getlockedOutErrorMsg ()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       return   driver.findElement(error).getText();
    }
}
