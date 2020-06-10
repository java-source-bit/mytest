package cn.yizhangwo.test;


import org.junit.Test;

import java.time.*;
import java.util.Date;
import java.util.stream.Stream;

public class LocalDateTimeTest {
    @Test
    public void fun05(){
        LocalDateTime.now();
    }
    @Test
    public void fun04(){
        LocalDateTime now = LocalDateTime.now();
        long epochSecond = Instant.now().getEpochSecond();
        long toEpochMilli = Instant.now().toEpochMilli();
        Instant instant = now.toInstant(ZoneOffset.of("+8"));
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(instant.toEpochMilli() / 1000, 0, ZoneOffset.ofHours(8));

    }
    @Test
    public void fun03(){
        int dayOfYear = LocalDate.now().getDayOfYear();
        System.out.println(dayOfYear);
        LocalDate localDate = LocalDate.now().plusMonths(1);
        LocalDate localDate1 = LocalDate.now().withDayOfMonth(1);
        LocalDate localDate2 = LocalDate.now().withYear(2);
        //
        boolean before = localDate.isBefore(localDate1);

        Period of = Period.of(2012, 2, 28);

    }
    @Test
    public void fun02(){
        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2001, 5, 5);
        Stream<LocalDate> localDateStream = of.datesUntil(now);
        localDateStream.limit(10).forEach(System.out::println);
        System.out.println(now);
    }

    @Test
    public void fun01(){
        long epochSecond = Instant.now().getEpochSecond();
        long l = System.currentTimeMillis();
        System.out.println(epochSecond+"   "+l);
        System.out.println(new Date(epochSecond));
        System.out.println(Instant.now());
    }
}
