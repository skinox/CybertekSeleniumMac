package practice_aidar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class Aigerim{
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://perevozka-kg.com/");
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
    public void table_test_compare() {
      String st1 = driver.findElement(By.xpath("//*[@id=\"posts\"]/div/article/div[2]/div/p")).getText();
        System.out.println(st1);
    }
}