package vytrack.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import vytrack.AbstractTestBase;

public class NewLoginAbstractTest extends AbstractTestBase {
@Test
    public void verifyPageTitle(){
    //test is coming from -->> ExtentTest object
    //we must add below line to every test at the beginning
    //test = report.createTest("Enter your test name");
    test = report.createTest("Verify Page Title");
    LoginPage loginPage = new LoginPage();
    loginPage.login();
    test.info("Login in as a Store Manager"); // log some steps
    Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboards"); //Comparing it with wrong title
    //if assertion passed, it will set test status in report to passed
    test.pass("Page title Dashboard was verified");


}

}
