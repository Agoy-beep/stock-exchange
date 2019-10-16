package api;

import domain.StockDTO;
import org.modelmapper.ModelMapper;
import service.StockService;

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
