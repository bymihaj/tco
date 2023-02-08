package com.bymihaj.tco.engine;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ReportDurationService {

    public BigDecimal getReportedMonth(Date date) {
        long count = ChronoUnit.MONTHS.between(date.toInstant(), new Date().toInstant());
        return new BigDecimal(count);
    }
}
