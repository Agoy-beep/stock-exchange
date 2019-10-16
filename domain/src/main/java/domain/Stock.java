package domain;

import java.math.BigDecimal;

public class Stock {

    private final String id;
    private final String name;
    private StockPrice stockPrice;

    public Stock(String id, String name) {
        this.id = id;
        this.name = name;
        this.stockPrice = new StockPrice(BigDecimal.valueOf(12), Currency.GBP);
    }

    public void setStockPrice(StockPrice stockPrice) {
        this.stockPrice = stockPrice;
    }

    public StockPrice getStockPrice() {
        return stockPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
