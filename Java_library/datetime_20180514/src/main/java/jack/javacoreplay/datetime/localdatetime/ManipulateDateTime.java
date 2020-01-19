package jack.javacoreplay.datetime.localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class ManipulateDateTime {

    public static void main(String[] args) {

        // with, withAttribute, plus, plusAttriute, minus, minusAttribute
        LocalDate localDateNow = LocalDate.now();
        System.out.println(localDateNow); //2018-05-14
        System.out.println(localDateNow.withYear(2014)); //2014-05-14
        System.out.println(localDateNow.withMonth(3)); //2018-03-14
        System.out.println(localDateNow.withDayOfMonth(23)); //2018-05-23

        System.out.println(localDateNow); //2018-05-14
        System.out.println();

        // one case
        LocalDate localDate1 = LocalDate.of(2018, 4, 6); //localDate1: 2018-04-06
        localDate1.with(ChronoField.MONTH_OF_YEAR, 9); //localDate1: 2018-04-06
        localDate1 = localDate1.plusYears(2).minusDays(10); //localDate1: 2020-03-27
        localDate1.withYear(2011); //localDate1: 2020-03-27
        System.out.println(localDate1);
        System.out.println();

        // TemporalAdjuster
        LocalDate localDate2 = LocalDate.now();
        System.out.println(localDate2);
        System.out.println(localDate2.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));
    }
}
