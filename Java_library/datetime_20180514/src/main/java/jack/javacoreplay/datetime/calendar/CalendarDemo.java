package jack.javacoreplay.datetime.calendar;

import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Theme:
 * <p> {@link java.util.Calendar}
 *
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-11-08
 */
public class CalendarDemo {

    public void basicUsage() {

    }

    /**
     *
     */
    @Test
    public void getInstance() {

        long current = System.currentTimeMillis();  // long UTC 1970-01-01 :0
        Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        cal1.setTimeInMillis(current); //An instant in time can be represented by a millisecond value that is an offset from the Epoch, January 1, 1970 00:00:00.000 GMT (Gregorian).
        System.out.println(cal1.getTime().toString());
        // java.util.Date  represents a specific instant in time, with millisecond precision.

        Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal2.setTimeInMillis(current);
        System.out.println(cal2.getTime());

        Calendar cal3 = Calendar.getInstance();
        cal3.setTimeInMillis(current);
        System.out.println(cal3.getTime());

    }

    @Test
    public void getInstance1() {

        long current = System.currentTimeMillis();
        Calendar cal1 = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        cal1.setTimeInMillis(current);
        System.out.println(cal1.getTime());

    }


    @Test
    public void timezone() {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        Calendar cal = Calendar.getInstance(timeZone);
        long l = System.currentTimeMillis();
        l = 1564456676868l;
        System.out.println(l);
        cal.setTimeInMillis(l);
        cal.getTime();
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.getTimeZone());
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));

    }

    @Test
    public void timezoneBasic() {
        // java.util.TimeZone

        // Typically, you get a TimeZone using getDefault which creates a TimeZone based on the time zone where the program is running.
        System.out.println(TimeZone.getDefault());
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));

        // You can also get a TimeZone using getTimeZone along with a time zone ID.
        System.out.println(TimeZone.getTimeZone("Asia/Shanghai"));

        // You can use the getAvailableIDs method to iterate through all the supported time zone IDs.
        System.out.println("TimeZone.getAvailableIDs() ");
        for (String item : TimeZone.getAvailableIDs()) {
            System.out.println(item);
        }

        //  a custom time zone ID can be specified to produce a TimeZone.
        /*
        The syntax of a custom time zone ID is:
        CustomID:
            GMT Sign Hours : Minutes
            GMT Sign Hours Minutes
            GMT Sign Hours
        Sign:
            one of + -
        Hours:
            Digit
            Digit Digit
        Minutes:
            Digit Digit
        Digit:
            one of 0 1 2 3 4 5 6 7 8 9
        */
        TimeZone.getTimeZone("GMT + 3");

    }

}
