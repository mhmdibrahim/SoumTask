import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver ;
    public CartPage(WebDriver driver)
    {
        this.driver = driver ;
    }
    private  final By headerTitle = By.className("title");
    private  final By cartItem1 = By.xpath("//*[@id=\"item_0_title_link\"]/div");
    private  final By cartItem2 = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private  final By checkout = By.id("checkout");

    public boolean getHeaderTitle()
    {
        return driver.findElement(headerTitle).isDisplayed();
    }
    public String getFirstCartItem ()
    {
        return driver.findElement(cartItem1).getText();

    }

    public String getlastCartItem ()
    {
       return driver.findElement(cartItem2).getText();
    }

    public void goToCheckoutPage()
    {
        driver.findElement(checkout).click();
    }



}
