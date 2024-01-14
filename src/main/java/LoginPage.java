import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
        private  WebDriver driver ;
        public LoginPage(WebDriver driver)
        {
            this.driver = driver ;
        }
        protected  final By usernameField = By.id("user-name");
        protected  final By passwordField = By.id("password");
        protected  final By loginbtn = By.id("login-button");

        //Check  Happy Path functionality of login
        public void loginWithValidCredential(String username , String password){
            driver.findElement(usernameField).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginbtn).click();

        };

    }

