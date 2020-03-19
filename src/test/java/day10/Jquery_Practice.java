package day10;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class Jquery_Practice {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        BrowserUtils.wait(2);
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
    public void testing_action(){
        Actions hover_over = new Actions(driver);
        WebElement enable = driver.findElement(By.id("ui-id-3"));
        WebElement download = driver.findElement(By.id("ui-id-4"));
        WebElement pdf_select = driver.findElement(By.id("ui-id-5"));
        hover_over.moveToElement(enable).
                pause(1000).   //pause( #msec ) same as Thread.sleep
                moveToElement(download).
                pause(1000).
                moveToElement(pdf_select).
                click().
                build().
                perform();

    }

}