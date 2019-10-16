package com.stockexchange.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class StockRepository {

    private final Map<String, Stock> database ;

    public StockRepository() {
        this.database = new HashMap<String, Stock>();
    }

    public Stock getStockInformation(String stockId){
        assertValidStock(stockId);
        return database.get(stockId);
    }

    private void assertValidStock(String stockId) {
        if(!checkIfStockIsInDatabase(stockId)){
            throw new NoSuchElementException();
        }
    }

    public Map<String, Stock> getDatabase() {
        return database;
    }

    public boolean checkIfStockIsInDatabase(String stockId){
        return database.get(stockId) != null;
    }

}
