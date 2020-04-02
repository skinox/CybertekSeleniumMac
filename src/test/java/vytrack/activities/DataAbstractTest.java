package vytrack.activities;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.LoginPage;
import vytrack.AbstractTestBase;

public class DataAbstractTest extends AbstractTestBase {
    @Test
    public void verify_date(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(),calendarEventsPage.getCurrentUserName());



    }
}
