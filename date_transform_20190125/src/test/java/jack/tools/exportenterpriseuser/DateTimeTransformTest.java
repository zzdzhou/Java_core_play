package jack.tools.exportenterpriseuser;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static jack.tools.exportenterpriseuser.DateTimeTransform.*;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-25
 */
public class DateTimeTransformTest {

    @Test
    public void transformTest() {
        String date = "Thu Jul 26 2018 05:50:27 GMT+0000 (UTC)";
        String dest = transform(date, SERVER_DATE_FORMAT, DEST_DATE_FORMAT);
        System.out.println(dest);
    }

    @Test
    public void testDemo1() {
        String format = LocalDateTime.now().format(SERVER_DATE_FORMAT);
        System.out.println(format);
    }

}
