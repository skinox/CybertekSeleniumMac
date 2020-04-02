package vytrack.activities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import vytrack.AbstractTestBase;

public class DateAndTimeAbstractTest extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Test
    public void date_check(){

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        BrowserUtils.wait(2);


        String startTime = Driver.getDriver().findElement(By.cssSelector(".start[placeholder='time']")).getAttribute("value");
        String endTime = Driver.getDriver().findElement(By.cssSelector(".end[placeholder='time']")).getAttribute("value");

        String format = "hh:mm "; //format 5:15 AM for example
        System.out.println(startTime+" "+endTime);
        int diff = Integer.parseInt(endTime.charAt(0)+"")-Integer.parseInt(startTime.charAt(0)+"");
        Assert.assertEquals(diff,1);
    }
}
