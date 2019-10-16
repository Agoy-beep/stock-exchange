package api;

import domain.Currency;
import domain.Stock;
import domain.StockPrice;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Stock randomStock = new Stock("TES", "Tesla");
        StockPrice randomStockPrice = new StockPrice(BigDecimal.valueOf(20), Currency.EUR);
        randomStock.setStockPrice(randomStockPrice);

    }
}
