package day13;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ConfigurationReaderTest {
    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        System.out.println(browser);
        String url = ConfigurationReader.getProperty("qa1");
        System.out.println(url);
    }

}
