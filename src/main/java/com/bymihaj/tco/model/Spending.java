package com.bymihaj.tco.model;

import java.math.BigDecimal;
import java.util.Date;

public class Spending {
    
    private Devision parent;
    private String name;
    private Date startDate;
    private SpendingType type;
    private BigDecimal cost;

    public Devision getParent() {
        return parent;
    }

    public void setParent(Devision parent) {
        this.parent = parent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpendingType getType() {
        return type;
    }

    public void setType(SpendingType type) {
        this.type = type;
    }

}
