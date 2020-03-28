package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage {

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement submit;


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /**
     * Method to login, version #1
     * Login as a specific user
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        submit.click();
    }
    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        BrowserUtils.wait(1);
        password.sendKeys(ConfigurationReader.getProperty("password"));
        submit.click();
    }
}

