package com.bymihaj.tco.engine;

import java.math.BigDecimal;

import com.bymihaj.tco.model.Spending;
import com.bymihaj.tco.model.SpendingType;

public class PeriodicalPaymentCalc implements CalculationRule {

    @Override
    public BigDecimal calculate(Spending spending) {
        if(SpendingType.MONTHLY.equals(spending.getType()) || SpendingType.DEPRECIATION.equals(spending.getType())) {
            return spending.getCost();
        } else {
            return BigDecimal.ZERO;
        }
    }

}
