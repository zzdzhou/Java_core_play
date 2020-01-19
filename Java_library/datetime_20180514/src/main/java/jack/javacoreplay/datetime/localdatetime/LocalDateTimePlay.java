package jack.javacoreplay.datetime.localdatetime;

import javax.sound.midi.Soundbank;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimePlay {

    public static void main(String[] args) {

        LocalDate localDateNow = LocalDate.now();
        System.out.println(localDateNow); //2018-05-14
        System.out.println(localDateNow.getMonth()); // MAY
        System.out.println(localDateNow.getMonthValue()); // 5
        System.out.println(localDateNow.getYear()); //2018
        System.out.println(localDateNow.getDayOfMonth()); //14
        System.out.println(localDateNow.getDayOfWeek()); //MONDAY
        System.out.println(localDateNow.getDayOfWeek().ordinal()); // 0
        System.out.println(localDateNow.getDayOfYear()); //134

        System.out.println(LocalDate.of(2014, 5, 12)); //2014-05-12
        System.out.println();

        System.out.println(LocalTime.now()); //14:51:43.269
        System.out.println(LocalTime.of(23, 12)); //23:12
        System.out.println(LocalTime.of(12, 30, 11)); //12:30:11

        System.out.println("LocalDateTime.now() = " + LocalDateTime.now()); // output LocalDateTime.now() = 2019-01-14T07:16:12.101
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now())); //2018-05-14T14:51:43.270

        System.out.println("\n// Instant");
        Instant now = Instant.now();
        System.out.println(now); // 2018-05-14T07:38:12.950Z  //UTC 时间
        System.out.println(now.getEpochSecond()); //1526283492 //Unix 时间戳， 单位秒
    }
}
