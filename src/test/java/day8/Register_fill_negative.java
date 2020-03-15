package day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class Register_fill_negative {
    private WebDriver driver;
    @BeforeMethod
    public void setup_browser1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        //driver.manage().window().maximize();
    }
    @AfterMethod
    public void kill_browser1(){
        if(driver!=null){
            BrowserUtils.wait(2);
            driver.quit();
            driver = null;
        }
    }
    @Test(priority = 2,suiteName = "Test Negative")
    public void filling_forms_negative(){
        driver.findElement(By.name("firstname")).sendKeys("Aidar");

        driver.findElement(By.name("lastname")).sendKeys("Jumaev");

        driver.findElement(By.name("username")).sendKeys("Aidar95");

        driver.findElement(By.name("email")).sendKeys("jumaev9gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456QE");
        driver.findElement(By.name("phone")).sendKeys("909-999-0920");
        driver.findElement(By.name("gender")).click();

        driver.findElement(By.name("birthday")).sendKeys("11/11/1999");

        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByVisibleText("Department of Engineering");
        Select job_title = new Select(driver.findElement(By.name("job_title")));
        job_title.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        boolean clickable = driver.findElement(By.id("wooden_spoon")).isEnabled();
        Assert.assertTrue(false==clickable);
    }
}
