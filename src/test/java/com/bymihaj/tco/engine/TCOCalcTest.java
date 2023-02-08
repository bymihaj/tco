package com.bymihaj.tco.engine;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bymihaj.tco.model.Spending;

@SpringBootTest
public class TCOCalcTest {

    @Mock
    private ReportDurationService reportDurationService;
    
    @InjectMocks
    private TCOCalc calc;
    
    @Test
    public void buy() {
        BigDecimal cost = new BigDecimal(4);
        Spending spending = new SpendingBuilder().buy(cost).build();
        assertTrue(calc.calculate(spending).equals(cost));
    }
    
    @Test
    public void oneTime() {
        BigDecimal cost = new BigDecimal(12);
        Spending spending = new SpendingBuilder().one(cost).build();
        assertTrue(calc.calculate(spending).equals(cost));
    }
    
    @Test
    public void monthly() {
        BigDecimal cost = new BigDecimal(5);
        BigDecimal duration = new BigDecimal(3);
        Spending spending = new SpendingBuilder().month(cost).build();
        when(reportDurationService.getReportedMonth(any())).thenReturn(duration);
        assertTrue(calc.calculate(spending).equals(cost.multiply(duration)));
    }
    
    @Test
    public void depreciation() {
        BigDecimal cost = new BigDecimal(8);
        BigDecimal duration = new BigDecimal(12);
        Spending spending = new SpendingBuilder().depr(cost).build();
        when(reportDurationService.getReportedMonth(any())).thenReturn(duration);
        assertTrue(calc.calculate(spending).equals(cost.multiply(duration)));
    }
    
}
