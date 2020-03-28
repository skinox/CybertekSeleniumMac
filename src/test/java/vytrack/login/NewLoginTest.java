package vytrack.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import vytrack.TestBase;

public class NewLoginTest extends TestBase {
@Test
    public void verifyPageTitle(){
    LoginPage loginPage = new LoginPage();
    loginPage.login("aidar19","123123");
    BrowserUtils.wait(2);
    Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//div[.='Invalid user name or password.']")).getText(),("Invalid user name or password."));

}

}
