import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver ;

    public CheckoutPage (WebDriver driver)
    {
        this.driver = driver ;
    }
    private final By headerTitle = By.className("title");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueBtn = By.id("continue");


    public String getHeaderTitle()
    {
        return  driver.findElement(headerTitle).getText();
    }
    public void completeData(String firstname ,String lastname , String zipCode)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(firstNameField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(continueBtn).click();
    }
}
