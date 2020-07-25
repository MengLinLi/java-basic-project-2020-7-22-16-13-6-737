package com.thoughtworks.basic.reditcard;

import java.math.BigDecimal;

public class Consume {
    private String consumMode;
    private BigDecimal consumAmount;
    private String customType;
    private  String consumTime;
    private BigDecimal initialPoints;

    public BigDecimal getInitialPoints() {
        return initialPoints;
    }

    public void setInitialPoints(BigDecimal initialPoints) {
        this.initialPoints = initialPoints;
    }

    public Consume(String consumMode, BigDecimal consumAmount, String customType, String consumTime) {
        this.consumMode = consumMode;
        this.consumAmount = consumAmount;
        this.customType = customType;
        this.consumTime = consumTime;
        this.initialPoints = new BigDecimal(0);
    }
    public void addBigDecimal(BigDecimal initialPoints) {
        this.initialPoints = this.initialPoints.add(initialPoints);
    }
    public String getConsumMode() {
        return consumMode;
    }

    public void setConsumMode(String consumMode) {
        this.consumMode = consumMode;
    }

    public BigDecimal getConsumAmount() {
        return consumAmount;
    }

    public void setConsumAmount(BigDecimal consumAmount) {
        this.consumAmount = consumAmount;
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public String getConsumTime() {
        return consumTime;
    }

    public void setConsumTime(String consumTime) {
        this.consumTime = consumTime;
    }
}
