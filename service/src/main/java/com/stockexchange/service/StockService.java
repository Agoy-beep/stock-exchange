package com.stockexchange.service;

import com.stockexchange.domain.Currency;
import com.stockexchange.domain.Stock;
import com.stockexchange.domain.StockPrice;
import com.stockexchange.domain.StockRepository;
import com.stockexchange.interfaces.ExternalStockInformation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StockService {

    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public Stock getStock(String stockId){
        Stock stockToEnrich = repository.getStockInformation(stockId);
        BigDecimal retrievedPrice = ExternalStockInformation.getPriceForStockInEuro(stockId);
        stockToEnrich.setStockPrice(new StockPrice(retrievedPrice, Currency.EUR));
        return stockToEnrich;
    }
}
