package com.pavan.dto;

import java.sql.Timestamp;

public class ExcelDataDto {

    private int companyId;
    private int exchangeId;
    private double price;
    private Timestamp timestamp;

    public ExcelDataDto() {
        super();
    }

    public ExcelDataDto(int companyId, int exchangeId, double price, Timestamp timestamp) {
        this.companyId = companyId;
        this.exchangeId = exchangeId;
        this.price = price;
        this.timestamp = timestamp;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
