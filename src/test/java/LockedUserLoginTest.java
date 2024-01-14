import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JSONClass;

import java.time.Duration;

public class LockedUserLoginTest extends BaseTest{


    private final String lockedoutData = "src/test/java/resources/lockedOutUser_Data.json";

    @Test
    public void loginWithLockedOutUser()
    {
        LoginWithLockedOutPage loginWithLockedOutPage = new LoginWithLockedOutPage(driver);
        loginWithLockedOutPage.loginWithLockedOutUser(
                JSONClass.readJson(lockedoutData , "username") ,
                JSONClass.readJson(lockedoutData,"password"));

        Assert.assertEquals(loginWithLockedOutPage.getlockedOutErrorMsg() ,
               JSONClass.readJson(lockedoutData ,"errormsg"), "U are not lockedOut user");

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        };
    }


}
