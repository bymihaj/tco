package com.bymihaj.tco.engine;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.bymihaj.tco.model.Spending;

public class OneTimePaymentCalcTest {

    private OneTimePaymentCalc calc = new OneTimePaymentCalc();
    
    @Test
    public void oneTimePayment() {
        BigDecimal cost = new BigDecimal(8);
        Spending spending = new SpendingBuilder().one(cost).build();
        assertTrue(calc.calculate(spending).equals(cost));
    }
    
    @Test
    public void buy() {
        BigDecimal buy = new BigDecimal(300);
        Spending spending = new SpendingBuilder().buy(buy).build();
        assertTrue(calc.calculate(spending).equals(buy));
    }
    
    @Test
    public void monthly() {
        BigDecimal cost = new BigDecimal(5);
        Spending spending = new SpendingBuilder().month(cost).build();
        assertTrue(calc.calculate(spending).equals(BigDecimal.ZERO));
    }
    
    @Test
    public void depreciation() {
        BigDecimal cost = new BigDecimal(15);
        Spending spending = new SpendingBuilder().depr(cost).build();
        assertTrue(calc.calculate(spending).equals(BigDecimal.ZERO));
    }
}
