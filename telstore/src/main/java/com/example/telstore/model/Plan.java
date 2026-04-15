package com.example.telstore.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String planType;
    private BigDecimal monthlyPrice;
    private String dataLimit;
    private String callsIncluded;
    private String smsIncluded;
    private String description;

    public Plan() {
    }

    public Plan(Long id, String name, String planType, BigDecimal monthlyPrice,
                String dataLimit, String callsIncluded, String smsIncluded, String description) {
        this.id = id;
        this.name = name;
        this.planType = planType;
        this.monthlyPrice = monthlyPrice;
        this.dataLimit = dataLimit;
        this.callsIncluded = callsIncluded;
        this.smsIncluded = smsIncluded;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public BigDecimal getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(BigDecimal monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public String getDataLimit() {
        return dataLimit;
    }

    public void setDataLimit(String dataLimit) {
        this.dataLimit = dataLimit;
    }

    public String getCallsIncluded() {
        return callsIncluded;
    }

    public void setCallsIncluded(String callsIncluded) {
        this.callsIncluded = callsIncluded;
    }

    public String getSmsIncluded() {
        return smsIncluded;
    }

    public void setSmsIncluded(String smsIncluded) {
        this.smsIncluded = smsIncluded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}