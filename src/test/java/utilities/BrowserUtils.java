package utilities;
import org.openqa.selenium.WebElement;

import java.util.*;
public class BrowserUtils {
    public static void wait(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            textValues.add(element.getText());
        }
        return textValues;
    }
}
