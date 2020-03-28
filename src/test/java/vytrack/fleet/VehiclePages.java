package vytrack.fleet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPageBase;

public class VehiclePages extends AbstractPageBase {
    @FindBy(css = ".main-group")
    private WebElement createCar;


}
