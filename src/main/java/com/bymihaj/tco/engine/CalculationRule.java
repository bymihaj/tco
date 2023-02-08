package com.bymihaj.tco.engine;

import java.math.BigDecimal;

import com.bymihaj.tco.model.Spending;

public interface CalculationRule {

    BigDecimal calculate(Spending spending);
}
