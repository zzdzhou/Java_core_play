package jack.javacoreplay.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class TemporalAndDuration {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2018, 5, 12, 15, 8);
        System.out.println(now); //2018-05-14T15:10:41.510
        System.out.println(localDateTime1); //2018-05-12T15:08
        System.out.println(Duration.between(now, localDateTime1)); //PT-48H-2M-41.51S
        System.out.println(Duration.between(localDateTime1, now)); //PT48H23M56.117S

        LocalDate localDateNow = LocalDate.now();
        LocalDate earthquakeDate = LocalDate.of(2008, 5, 12);
        System.out.println(Period.between(localDateNow, earthquakeDate)); //P-10Y-2D
        System.out.println(Period.between(earthquakeDate, localDateNow)); //P10Y2D

    }
}
