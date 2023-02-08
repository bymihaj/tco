package com.bymihaj.tco.engine;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bymihaj.tco.model.Spending;
import com.bymihaj.tco.model.SpendingType;

@Component
public class TCOCalc implements CalculationRule {

    @Autowired
    private ReportDurationService reportDuratinoService;
    
    @Override
    public BigDecimal calculate(Spending spending) {
        if(SpendingType.BUY.equals(spending.getType()) || SpendingType.ONE_TIME.equals(spending.getType())) {
            return spending.getCost();
        } else {
            BigDecimal reportedMonth = reportDuratinoService.getReportedMonth(spending.getStartDate());
            return spending.getCost().multiply(reportedMonth);
        }
    }

}
