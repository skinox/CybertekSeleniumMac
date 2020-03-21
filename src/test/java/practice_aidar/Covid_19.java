package practice_aidar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import javax.sound.midi.Soundbank;

public class Covid_19 {
    private RemoteWebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        driver = new ChromeDriver();
        //Browser doesn't run UI, saves up to 2 times of your time
        driver.get("https://www.arcgis.com/apps/opsdashboard/index.html#/bda7594740fd40299423467b48e9ecf6");
        BrowserUtils.wait(4);
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
        String world_wide= (String) driver.executeScript("return document.querySelector(\"#ember1332 > svg > g.responsive-text-label > svg\").textContent;");
        System.out.println("Worldwide number of cases: "+world_wide);
        BrowserUtils.wait(2);
        String usa_number = (String) driver.executeScript("return document.querySelector(\"#ember236 > div > div > h5 > span:nth-child(1) > strong\").textContent;");
        System.out.println("USA number of cases: "+usa_number);
        world_wide = world_wide.replaceAll(",","");
        double world = Double.valueOf(world_wide.trim());
        usa_number = usa_number.replaceAll(",","");
        double usa = Double.valueOf(usa_number.trim());
        double usa_over_world = (usa/world)*100;
        usa_over_world = Math.round(usa_over_world * 100.0) / 100.0;
        System.out.println("USA percentage of cases is "+usa_over_world+"% over the world.");
    }
}

