package org.varishat.insurance.core;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateTimeServiceTest {

    private final DateTimeService timeService = new DateTimeService();

    private final Calendar calender = Calendar.getInstance();

    @Test
    public void ShouldBeDiffEqualsTwo() {
        calender.set(2026, Calendar.SEPTEMBER, 1);
        Date dateFrom = calender.getTime();
        calender.set(2026, Calendar.SEPTEMBER, 3);
        Date dateTo = calender.getTime();
        long diffOfDays = timeService.getDiffOfDays(dateFrom, dateTo);
        assertEquals(2, (diffOfDays));
    }

    @Test
    public void ShouldBeDiffEqualsMinusTwo() {
        calender.set(2026, Calendar.SEPTEMBER, 3);
        Date dateFrom = calender.getTime();
        calender.set(2026, Calendar.SEPTEMBER, 1);
        Date dateTo = calender.getTime();
        long diffOfDays = timeService.getDiffOfDays(dateFrom, dateTo);
        assertEquals(-2, (diffOfDays));
    }

    @Test
    public void ShouldBeDiffEqualsZero() {
        calender.set(2026, Calendar.SEPTEMBER, 3);
        Date dateFrom = calender.getTime();
        calender.set(2026, Calendar.SEPTEMBER, 3);
        Date dateTo = calender.getTime();
        long diffOfDays = timeService.getDiffOfDays(dateFrom, dateTo);
        assertEquals(0, (diffOfDays));
    }
}
