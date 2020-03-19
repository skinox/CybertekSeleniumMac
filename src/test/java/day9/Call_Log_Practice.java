package day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.Calendar;
import java.util.Date;

public class Call_Log_Practice{
    private WebDriver driver;
    private String username = "storemanager85";
    private String password = "UserUser123";
    private String URL = "https://qa2.vytrack.com/user/login";

    @BeforeMethod
    public void setup_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        //driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(password, Keys.ENTER);
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
    public void verify_create_calendar_works() {

        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"));
        builder.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]/a/span")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);
        String name = driver.findElement(By.xpath("//*[@id=\"s2id_oro_calendar_event_form_calendar\"]/a/span[1]")).getText();
        Assert.assertTrue(name.equals(" Pearl Wuckert"));
        Assert.assertTrue(driver.findElement(By.name("oro_calendar_event_form[title]")).getAttribute("value").isEmpty());
        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 6
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); // 17
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR); //169
        int month = cal.get(Calendar.MONTH); // 5
        int year = cal.get(Calendar.YEAR); // 2016
        System.out.println(driver.findElement(By.className("input-small datepicker-input start hasDatepicker")).getAttribute("value"));


    }
}
