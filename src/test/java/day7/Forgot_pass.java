package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class Forgot_pass {
    private WebDriver driver;
    @BeforeMethod
    public void Setup_Driver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void forgot_pass(){
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/input")).sendKeys("jumaev9@gmail.com", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h4")).getText().equals("Your e-mail's been sent!"));
        BrowserUtils.wait(2);
    }
}
