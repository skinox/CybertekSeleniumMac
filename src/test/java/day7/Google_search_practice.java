package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Google_search_practice {
        private WebDriver driver;

        @Test
        public void googleSearchTest(){
            driver.get("http://google.ru");
            driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
            List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
            for (WebElement searchItem: searchItems
                 ) {
                String var = searchItem.getText();
                if(!var.isEmpty()){
                    System.out.println(var);
                    Assert.assertTrue(var.toLowerCase().contains("java"));
                }

            }
        }
        @BeforeMethod
        public void setupDriver(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

