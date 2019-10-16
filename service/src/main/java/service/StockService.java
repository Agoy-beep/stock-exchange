package service;

import domain.Currency;
import domain.Stock;
import domain.StockPrice;
import domain.StockRepository;
import interfaces.ExternalStockInformation;

import java.math.BigDecimal;

public class StockService {

    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public Stock getStock(String stockId){

        Stock stockToEnrich = repository.getStockInformation(stockId);

        BigDecimal retrievedPrice = ExternalStockInformation.getPriceForStockInEuro(stockId);

        assert stockToEnrich != null;
        stockToEnrich.setStockPrice(new StockPrice(retrievedPrice, Currency.EUR));
        return stockToEnrich;
    }
}
