package org.varishat.insurance.core;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeService {

    public long getDiffOfDays(Date dateFrom, Date dateTo) {
        long diff = dateTo.getTime() - dateFrom.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
