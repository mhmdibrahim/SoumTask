import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteOrderPage {
    WebDriver driver ;
    public CompleteOrderPage (WebDriver driver)
    {
        this.driver = driver ;
    }

    protected final By checkoutComplete = By.className("title");
    protected final By completeHeader = By.className("complete-header");

    public String getCheckoutComplete()
    {
      return   driver.findElement(checkoutComplete).getText();
    }

    public String getCompleteHeader()
    {
       return driver.findElement(completeHeader).getText();
    }

}
