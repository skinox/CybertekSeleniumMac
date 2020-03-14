package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.List;

public class Amazon_practice {
    private WebDriver driver;
    @BeforeMethod
    public void SetupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void TestIfContains(){
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys("java");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
        BrowserUtils.wait(2);
        List<WebElement> titles = driver.findElements(By.xpath("//h2"));
        for (WebElement title :
                titles) {
            if(title.getText().equals("Need help?")){
                continue;
            }
            boolean check_ignore_case = title.getText().contains("java") || title.getText().contains("Java")||title.getText().contains("JAVA");
            System.out.println(check_ignore_case);
            if(check_ignore_case==false){
                System.out.println(title.getText());
            }
            //Assert.assertTrue(title.getText().contains("java") || title.getText().contains("Java"));
        }
        driver.quit();

    }

}
