import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver ;
    public ProductsPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private  final By headerTitle = By.className("title");
    private  final By addToCartBackPack = By.id("add-to-cart-sauce-labs-backpack");
    private  final By addToCartBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private  final By cartItemsCount = By.className("shopping_cart_badge");
    private  final By cartBtn = By.className("shopping_cart_link");

    public Boolean  getProductHeaderTitle()
    {
      return  driver.findElement(headerTitle).isDisplayed();
    }

    public void addToCartBackPack()
    {
        driver.findElement(addToCartBackPack).click();
    }

    public void addToCartBikeLight()
    {
        driver.findElement(addToCartBikeLight).click();
    }
    public String getCartItemsCount()
    {
        return  driver.findElement(cartItemsCount).getText();
    }

    public void goToCartPage()
    {
        driver.findElement(cartBtn).click();
    }
}
