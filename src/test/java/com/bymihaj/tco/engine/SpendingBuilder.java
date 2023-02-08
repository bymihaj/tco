package com.bymihaj.tco.engine;

import java.math.BigDecimal;
import java.util.Date;

import com.bymihaj.tco.model.Devision;
import com.bymihaj.tco.model.Spending;
import com.bymihaj.tco.model.SpendingType;

public class SpendingBuilder {

    private Devision parent;
    private String name;
    private Date startDate;
    private SpendingType type;
    private BigDecimal cost;

    public SpendingBuilder parent(Devision parent) {
        this.parent = parent;
        return this;
    }

    public SpendingBuilder name(String name) {
        this.name = name;
        return this;
    }

    public SpendingBuilder date(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public SpendingBuilder type(SpendingType type) {
        this.type = type;
        return this;
    }

    public SpendingBuilder cost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public Spending build() {
        Spending spending = new Spending();
        spending.setParent(parent);
        spending.setName(name);
        spending.setStartDate(startDate);
        spending.setType(type);
        spending.setCost(cost);
        return spending;
    }
    
    public SpendingBuilder one(BigDecimal cost) {
        return type(SpendingType.ONE_TIME).cost(cost);
    }
    
    public SpendingBuilder buy(BigDecimal buy) {
        return type(SpendingType.BUY).cost(buy);
    }
    
    public SpendingBuilder month(BigDecimal month) {
        return type(SpendingType.MONTHLY).cost(month);
    }
    
    public SpendingBuilder depr(BigDecimal cost) {
        return type(SpendingType.DEPRECIATION).cost(cost);
    }
}

