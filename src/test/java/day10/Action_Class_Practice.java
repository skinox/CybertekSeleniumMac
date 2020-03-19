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

public class Action_Class_Practice {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/hovers");
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
        WebElement profile_1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        WebElement profile_2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        WebElement profile_3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        hover_over.moveToElement(profile_1).
                pause(1000).   //pause( #msec ) same as Thread.sleep
                moveToElement(profile_2).
                pause(1000).
                moveToElement(profile_3).
                build().
                perform();

    }

}
