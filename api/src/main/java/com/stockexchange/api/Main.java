package com.stockexchange.api;

import com.stockexchange.domain.*;
import com.stockexchange.service.StockService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Stock randomStock = new Stock("ID", "idSoftware");
        StockRepository repository = new StockRepository();
        StockService stockService = new StockService(repository);
        StockExchangeController controller = new StockExchangeController(stockService);
        StockDTO randomStockDTO = controller.getStock("ID");
        //StockDTO randomStockDTO2 = controller.getStock("APP");

        System.out.println(randomStockDTO.getName());
        System.out.println(randomStockDTO.getPriceDecimal());

    }
}
