package day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.List;


public class Update_ZipCode{
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        BrowserUtils.wait(1);

    }

    @AfterMethod
    public void kill_browser() {
        if (driver != null) {
            BrowserUtils.wait(2);
            driver.quit();
            driver = null;

        }
    }

    @Test
    public void test_orders() {
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test",Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        BrowserUtils.wait(1);
        String initial_zip = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[text()='21233']")).getText();
        Assert.assertTrue("21233".equals(initial_zip));
        driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[11]")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("11104");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        BrowserUtils.wait(2);
        String edited_zip = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[text()='11104']")).getText();
        Assert.assertTrue("11104".equals(edited_zip));


    }
}