import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    WebDriver driver;
    public OverviewPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private  final By overview = By.className("title");
    private  final By item1 = By.xpath("//a[@id=\"item_4_title_link\"]");

    private  final By item2 = By.xpath("//a[@id=\"item_0_title_link\"]");
    private  final By itemPrice1 = By.xpath("//div[text() =\"29.99\"]");
    private  final By itemprice2 = By.xpath("//div[text() =\"9.99\"]");
    private  final By totalPrice = By.xpath("//div[@class =\"summary_info_label summary_total_label\"]");
    private  final By finish = By.id("finish");


    public String getHeaderTitle()
    {
        return driver.findElement(overview).getText();
    }
    public String overviewFirstItem()
    {
        return driver.findElement(item1).getText();
    }
    public String overviewSecondItem()
    {
        return driver.findElement(item2).getText();
    }

    public String FirstitemPrice()
    {
        return driver.findElement(itemPrice1).getText();
    }

    public String SeconditemPrice()
    {
        return driver.findElement(itemprice2).getText();
    }

    public String totalPrice()
    {
        return driver.findElement(totalPrice).getText();
    }

    public void  submitOrder()
    {
        driver.findElement(finish).click();
    }
}
