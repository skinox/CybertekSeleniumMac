package soft_skill_class_project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import vytrack.AbstractTestBase;
import vytrack.fleet.VehiclePages;

public class UserStory13_1 extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    VehiclePages vehiclePages = new VehiclePages();
    @Test
    public void verify_vehicle_model_page(){
        test = report.createTest("Verify Vehicle Model Page");
        loginPage.login();
        BrowserUtils.wait(2);
        vehiclePages.navigateTo("Fleet","Vehicles Model");
        BrowserUtils.wait(2);
        String expected = "All Vehicles Model";
        String actual = Driver.getDriver().findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actual,expected);
        test.pass("Test case# 13.1 was verified");
    }

}
