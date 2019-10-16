package com.stockexchange.domain;

import java.math.BigDecimal;

public class StockDTO {

    private String id;
    private String name;
    private BigDecimal priceDecimal;
    private Currency priceCurrency;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPriceDecimal() {
        return priceDecimal;
    }

    public Currency getPriceCurrency() {
        return priceCurrency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceDecimal(BigDecimal priceDecimal) {
        this.priceDecimal = priceDecimal;
    }

    public void setPriceCurrency(Currency priceCurrency) {
        this.priceCurrency = priceCurrency;
    }
}
