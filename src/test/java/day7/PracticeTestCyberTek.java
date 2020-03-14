package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class PracticeTestCyberTek {
    private WebDriver driver;
    @Test
    public void loginTest(){
    driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input")).sendKeys("tomsmith");
    driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input")).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(1);
    driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]")).click();
    String actual  = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4")).getText();
    String expected = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertTrue(expected.equals(actual));
        BrowserUtils.wait(4);
        driver.quit();

    }
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

    }
}
