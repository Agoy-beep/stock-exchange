package com.stockexchange.api;

import com.stockexchange.domain.StockDTO;
import org.modelmapper.ModelMapper;
import com.stockexchange.service.StockService;

public class StockExchangeController {

    private final StockService service;

    public StockExchangeController(StockService service) {
        this.service = service;
    }

    public StockDTO getStock(String stockId){
        ModelMapper stockToStockDTO = new ModelMapper();

        return stockToStockDTO.map(service.getStock(stockId) ,StockDTO.class);

    }
}
