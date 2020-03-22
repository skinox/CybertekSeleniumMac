package day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compare_class {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/tables");
        BrowserUtils.wait(1);
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
    public void table_test_compare() {
        List<WebElement> first_names1 = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody//td[2]"));
        List<String> first_names = new ArrayList<>();
        for (WebElement first_name_w :
                first_names1) {
            first_names.add(first_name_w.getText());
        }
        List<String> first_names_actual = new ArrayList<>(first_names);
        Collections.sort(first_names);
        System.out.println(first_names);
        System.out.println(first_names_actual);
        Assert.assertTrue(first_names_actual.equals(first_names));
    }
}