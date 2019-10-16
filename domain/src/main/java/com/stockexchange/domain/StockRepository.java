package com.stockexchange.domain;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class StockRepository {

    private final ImmutableMap<String, Stock> database = new ImmutableMap.Builder<String, Stock>()
            .put("ID", new Stock("ID", "idSoftware"))
            .put("EPC", new Stock("EPC", "EpicGames"))
            .put("BLIZZ", new Stock("BLIZZ", "Blizzard"))
            .build();

    public StockRepository() {
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
