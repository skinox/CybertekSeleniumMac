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


public class Wait_Practice2{
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
        BrowserUtils.wait(2);
        List<WebElement> checked_boxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        boolean isChecked = true;
        for (WebElement box : checked_boxes) {
            if(box.isSelected()==false){
                isChecked = false;
                break;
            }
        }
        Assert.assertTrue(isChecked==true);

    }
}