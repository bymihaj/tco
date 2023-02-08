package com.bymihaj.tco.engine;

import java.math.BigDecimal;

import com.bymihaj.tco.model.Spending;
import com.bymihaj.tco.model.SpendingType;

public class OneTimePaymentCalc implements CalculationRule {

    @Override
    public BigDecimal calculate(Spending spending) {
        if(SpendingType.BUY.equals(spending.getType()) || SpendingType.ONE_TIME.equals(spending.getType())) {
            return spending.getCost();
        } else {
            return BigDecimal.ZERO;
        }
    }

}
