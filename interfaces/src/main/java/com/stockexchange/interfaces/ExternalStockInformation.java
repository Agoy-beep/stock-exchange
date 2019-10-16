package com.stockexchange.interfaces;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;

public class ExternalStockInformation {

    public static BigDecimal getPriceForStockInEuro(String stockId){
        return BigDecimal.valueOf(RandomUtils.nextInt(10, 100));
    }
}
