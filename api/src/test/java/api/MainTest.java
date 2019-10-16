package api;

import domain.Currency;
import domain.Stock;
import domain.StockDTO;
import domain.StockPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void givenAStock_whenUsingDefault_thenStockPriceIsRetrievable() {
        //GIVEN
        Stock randomStock = new Stock("TES", "Tesla");
        //WHEN
        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(12), randomStock.getStockPrice().getPrice());
        Assertions.assertEquals(Currency.GBP, randomStock.getStockPrice().getCurrency());
    }
    @Test
    void givenAStock_whenAddingAStockPrice_thenStockPriceIsRetrievable() {
        //GIVEN
        Stock randomStock = new Stock("TES", "Tesla");
        StockPrice randomStockPrice = new StockPrice(BigDecimal.valueOf(15), Currency.EUR);
        //WHEN
        randomStock.setStockPrice(randomStockPrice);
        //THEN
        Assertions.assertEquals(BigDecimal.valueOf(15), randomStock.getStockPrice().getPrice());
        Assertions.assertEquals(Currency.EUR, randomStock.getStockPrice().getCurrency());
    }

    @Test
    void givenAStock_whenUsingAModelMapper_thenItCanBecomeAStockDataTransferObject() {
        //GIVEN
        Stock defaultStock = new Stock("ID", "idSoftware");
        ModelMapper modelMapper = new ModelMapper();
        //WHEN
        StockDTO stockDTO = modelMapper.map(defaultStock, StockDTO.class);
        //THEN
        assertEquals(defaultStock.getName(), stockDTO.getName());
        assertEquals(defaultStock.getId(), stockDTO.getId());
        assertEquals(defaultStock.getStockPrice().getPrice(), stockDTO.getPriceDecimal());
        assertEquals(defaultStock.getStockPrice().getCurrency(), stockDTO.getPriceCurrency());

    }
}