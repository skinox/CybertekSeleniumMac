package vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class Practice {
    private WebDriver driver;
    private String username = "storemanager85";
    private String password = "UserUser123";
    private String URL = "https://qa2.vytrack.com/user/login";
    @BeforeMethod
    public void setup_browser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        //driver.manage().window().maximize();
    }
    @AfterMethod
    public void kill_browser(){
        if(driver!=null){
            BrowserUtils.wait(2);
            driver.quit();
            driver = null;
        }
    }
    @Test(priority = 1)
    public void testing_login_wrong_credits(){
        driver.findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys("aidar");
        driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys("aidar", Keys.ENTER);
        String verify_text = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div")).getText();
        Assert.assertTrue(verify_text.equals("Invalid user name or password."));
        System.out.println("Success");
    }
    @Test(priority = 2)
    public void testing_correct_login(){
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(password, Keys.ENTER);
        String verify_text = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div/div/div[1]/div/h1")).getText();
        Assert.assertTrue(verify_text.equals("Dashboard"));
        System.out.println("Success 2");

    }
}
