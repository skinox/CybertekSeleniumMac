package vytrack;

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

public class Verify_Page_Number {
    private WebDriver driver;
    private String username = "storemanager85";
    private String password = "UserUser123";
    private String URL = "https://qa2.vytrack.com/user/login";
    private By page_locator = By.cssSelector("input[type= \"number\"]");

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
    public void verify_page_number(){

        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        builder.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        BrowserUtils.wait(2);
        String page_number = driver.findElement(page_locator).getAttribute("value");
        int page = Integer.parseInt(page_number);
        Assert.assertTrue(1 == page);
        System.out.println("Successfully got page number");
    }

}
