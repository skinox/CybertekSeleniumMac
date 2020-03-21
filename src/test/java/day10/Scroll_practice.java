package day10;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class Scroll_practice{
    private RemoteWebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
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
    public void testing_action() {


//        String script = "window.scrollTo({ left: 0, top: document.body.scrollHeight, behavior: \"smooth\" });";
//        for (int i = 0; i < 15 ; i++) {
//            driver.executeScript(script);
//            BrowserUtils.wait(1);// }
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)",link);
        }

    }