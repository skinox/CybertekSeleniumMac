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


public class Wait_Time_Practice{
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
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
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/div/button"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitBtn.click();
        String welcome = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4")).getText().equals(welcome));
    }
}