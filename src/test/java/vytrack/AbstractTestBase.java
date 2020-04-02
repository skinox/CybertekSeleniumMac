package vytrack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.IOException;

public abstract class AbstractTestBase {
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    public void setupTest(){
        report = new ExtentReports();
        String reportPath = System.getProperty("user.dir")+"/test-output/report.html";
        //is a HTML report itself
        htmlReporter= new ExtentHtmlReporter(reportPath);
        //add if to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VyTrack Test Automation Results");
    }
    @AfterTest
    public void tearDownTest(){
        report.flush(); //to release a report
    }

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
//        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }


    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //iTestResult class describes the result of the test.
        //if test failed, takes a screenshot
        if(iTestResult.getStatus()==ITestResult.FAILURE){
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName()); //attach test name that failed
            BrowserUtils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath,"Failed");//attach screenshot
            test.fail(iTestResult.getThrowable());//attach console output

        }
        Driver.closeDriver();
    }
}