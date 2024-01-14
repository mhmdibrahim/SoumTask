import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JSONClass;

public class ByOrderTest extends BaseTest{
    private final String loginData = "src/test/java/resources/Standard_User.json";
    private final String chechOutData = "src/test/java/resources/Checkout_Data.json";
    private final String cartitems = "src/test/java/resources/Cart_items.json";
    private final String overviewData = "src/test/java/resources/Overview_Data.json";
    private final String completeOrderData = "src/test/java/resources/CompleteOrderData.json";


    @Test
    // Check E2E scenario for buy order with valid credential customer (standard user)
    public void buyOrder()
    {
        //Check Login Page
        new LoginPage(driver).loginWithValidCredential(
                JSONClass.readJson(loginData,"username"),
                JSONClass.readJson(loginData,"password"));

        ProductsPage ProductsPage = new ProductsPage(driver);
        //Assert the system route to Products Page
        Assert.assertTrue(ProductsPage.getProductHeaderTitle() , "You Are Not in a Products Page");

        //Add first item to Cart
        ProductsPage.addToCartBackPack();

        //Add second item to Cart
        ProductsPage.addToCartBikeLight();

        // Assert that the total Count items is  2
        Assert.assertEquals(ProductsPage.getCartItemsCount() , "2" ,"the Expected Number is  2 but it is "+ProductsPage.getCartItemsCount());

        // Go to CartPage
        ProductsPage.goToCartPage();

        CartPage cartPage = new CartPage(driver);

        //Assert that system route to cart page
        Assert.assertTrue(cartPage.getHeaderTitle() , "You Are Not in a Cart Page");

        // Assert Cart Contents
        Assert.assertEquals(cartPage.getFirstCartItem(), JSONClass.readJson(cartitems , "cartItem1"));
        Assert.assertEquals(cartPage.getlastCartItem(), JSONClass.readJson(cartitems , "cartItem2"));

        // route customer to checkout page
        cartPage.goToCheckoutPage();

        CheckoutPage checkout = new CheckoutPage(driver);
        //Assert system route to checkout page
        Assert.assertEquals(checkout.getHeaderTitle() , "Checkout: Your Information" , "Your are not in a checkout page");

        checkout.completeData(
                JSONClass.readJson(chechOutData , "firstname"),
                JSONClass.readJson(chechOutData , "lastname"),
                JSONClass.readJson(chechOutData , "zipcode"));

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        };
        //Assert system route Customer to Overview page
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertEquals(overviewPage.getHeaderTitle() , "Checkout: Overview" , "You are not in Overview Page");

        //Assert Overview Data
        Assert.assertEquals(overviewPage.overviewFirstItem() ,JSONClass.readJson(overviewData,"item1") , "invalid item");
        Assert.assertEquals(overviewPage.overviewSecondItem() ,JSONClass.readJson(overviewData,"item2") , "invalid item");
        Assert.assertEquals(overviewPage.FirstitemPrice() ,JSONClass.readJson(overviewData,"itemprice1") , "invalid price");
        Assert.assertEquals(overviewPage.SeconditemPrice() ,JSONClass.readJson(overviewData,"itemprice2") , "invalid price");
        Assert.assertEquals(overviewPage.totalPrice() ,JSONClass.readJson(overviewData,"total") , "invalid price");

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        };

        //Submit Order & Scroll Down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(40,3000)", "");

        overviewPage.submitOrder();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        };

        // Assert system route to checkout complete Page (order Complete Page)
        CompleteOrderPage completeOrderPage = new CompleteOrderPage(driver);
        Assert.assertEquals(completeOrderPage.getCompleteHeader() ,
                JSONClass.readJson(completeOrderData,"complete-header"),"You are not in a complete order page");
        Assert.assertEquals(completeOrderPage.getCheckoutComplete() ,
                JSONClass.readJson(completeOrderData,"header_title"),"You are not in a complete order page");
    }



}
