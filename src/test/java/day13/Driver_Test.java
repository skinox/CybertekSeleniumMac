package day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class Driver_Test {
    @Test
    public void googleTest(){
        Driver.getDriver().get("https://www.google.ru/");
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Google"));
        BrowserUtils.wait(2);
        Driver.closeDriver();

    }
}
