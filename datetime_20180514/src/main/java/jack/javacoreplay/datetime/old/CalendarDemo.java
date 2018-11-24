package jack.javacoreplay.datetime.old;

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

    /**
     *
     */
    @Test
    public void getInstance() {

        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());

        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        System.out.println(Calendar.getInstance(timeZone).getTime());
    }

}
