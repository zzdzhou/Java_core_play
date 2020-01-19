package jack.javacoreplay.datetime.localdatetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintAndParse {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS Z");
        String timeStr = "2020-01-19 14:55:00.832 +0800";
        System.out.println(LocalDateTime.parse(timeStr, dateTimeFormatter));
    }
}
