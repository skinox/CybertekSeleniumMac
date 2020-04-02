package vytrack.fleet;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import vytrack.AbstractTestBase;

public class NewVehiclePageTests extends AbstractTestBase {
    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        VehiclePages vehiclePages = new VehiclePages();
        loginPage.login();
        vehiclePages.navigateTo("Fleet","Vehicles");
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        BrowserUtils.wait(2);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
