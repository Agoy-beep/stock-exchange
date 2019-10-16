package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class StockRepository {

    private final Map<String, Stock> database ;

    public StockRepository() {
        this.database = new HashMap<String, Stock>();
    }

    public Stock getStockInformation(String stockId){
        try{
            checkIfStockIsInDatabase(stockId);
            return database.get(stockId);
        } catch (NoSuchElementException noSuchElEx){
            System.err.println("Stock not found in database");
        }
        return null;
    }

    public Map<String, Stock> getDatabase() {
        return database;
    }

    public boolean checkIfStockIsInDatabase(String stockId){
        if(database.get(stockId) != null){
            return true;
        } else{
            throw new NoSuchElementException();
        }

    }

}
