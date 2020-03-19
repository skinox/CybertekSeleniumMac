package practice_aidar;

import java.util.Calendar;
import java.util.Date;

public class Day_and_Date {
    public static void main(String[] args) {
        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 6
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); // 17
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR); //169
        int month = cal.get(Calendar.MONTH); // 5
        int year = cal.get(Calendar.YEAR); // 2016
        System.out.println(month);
    }
}
