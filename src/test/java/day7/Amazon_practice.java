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
import utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        searchBox.sendKeys("iphone 11", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement > prices_elements = driver.findElements(By.className("a-price-whole"));
        BrowserUtils.wait(2);
        List<String> prices = new ArrayList<>();
        int i=0;
        for (WebElement price_element:prices_elements
             ) {
            prices.add(price_element.getText());
            prices.set(i,prices.get(i).replace(",",""));
            i++;
        }
        List<Integer> prices_int = new ArrayList<>();
        for (String price:prices
             ) {
            prices_int.add(Integer.parseInt(price));
        }
        Collections.sort(prices_int);
        System.out.println(prices_int);
        driver.quit();

    }

}
