package day10;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Drag_and_Drop{
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
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
        Actions action = new Actions(driver);
        WebElement item_to_be_dropped = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        action.dragAndDrop(item_to_be_dropped,target).perform();
        BrowserUtils.wait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "alert('Helooo!!!!!!!!!!!!!!!!!!!!!')";
        js.executeScript(script);


    }

}