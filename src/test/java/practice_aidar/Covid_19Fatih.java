package practice_aidar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class Covid_19Fatih {
    private RemoteWebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
        //Browser doesn't run UI, saves up to 2 times of your time
        driver.get("https://www.arcgis.com/apps/opsdashboard/index.html#/bda7594740fd40299423467b48e9ecf6");
        BrowserUtils.wait(3);
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
    public void number_of_cases(){
        WebElement result= driver.findElement(By.xpath("(//div[contains(@class,'flex-fix allow-shrink indicator-c')])[1]/child::*/child::*[2]/child::*/child::*"));
        System.out.println(result.getText());
    }
}
