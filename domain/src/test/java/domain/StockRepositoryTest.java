package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StockRepositoryTest {

    @org.junit.jupiter.api.Test

    void getStockInformation() {
        //GIVEN
        StockRepository stockRepository = new StockRepository();
        stockRepository.getDatabase().put("ID", new Stock("ID", "idSoftware"));
        //WHEN
        Stock searchedForStock = stockRepository.getStockInformation("ID");
        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(12), searchedForStock.getStockPrice().getPrice());
    }

    @Test
    void givenAStockRepository_whenAskedForStockNotInTheDatabase_thenThrowAnException() {
        //GIVEN
        StockRepository stockRepository = new StockRepository();
        stockRepository.getDatabase().put("ID", new Stock("ID", "idSoftware"));
        //THEN
        assertThrows(NoSuchElementException.class, () -> stockRepository.getStockInformation("APP"));
    }
}