package com.stockexchange.api;

import com.stockexchange.domain.*;
import com.stockexchange.service.StockService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Stock randomStock = new Stock("ID", "idSoftware");
        StockRepository repository = new StockRepository();
        repository.getDatabase().put("ID", randomStock);
        StockService stockService = new StockService(repository);
        StockExchangeController controller = new StockExchangeController(stockService);
        StockDTO randomStockDTO = controller.getStock("ID");

        System.out.println(randomStockDTO.getName());



    }
}
