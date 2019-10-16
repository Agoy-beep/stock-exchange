package domain;

import java.math.BigDecimal;

public class StockPrice {
    private final BigDecimal price;
    private final Currency currency;

    public StockPrice(BigDecimal price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }


}
