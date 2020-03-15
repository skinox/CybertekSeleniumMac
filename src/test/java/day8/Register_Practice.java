package day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class Register_Practice {
    private WebDriver driver;
    @BeforeMethod
    public void setup_browser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
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
    @Test(priority = 1,suiteName = "Test Positive")
    public void filling_forms(){
        driver.findElement(By.name("firstname")).sendKeys("Aidar");

        driver.findElement(By.name("lastname")).sendKeys("Jumaev");

        driver.findElement(By.name("username")).sendKeys("Aidar95");

        driver.findElement(By.name("email")).sendKeys("jumaev9@gmail.com");
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

        String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/p")).getText();
        Assert.assertTrue(actual.equals("You've successfully completed registration!"));
    }

}
