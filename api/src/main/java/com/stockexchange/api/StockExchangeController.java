package com.stockexchange.api;

import com.stockexchange.domain.Stock;
import com.stockexchange.domain.StockDTO;
import org.modelmapper.ModelMapper;
import com.stockexchange.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/stocks")
public class StockExchangeController {

    private final StockService service;
    private Stock defaultErrorStock = new Stock("STOCK NOT FOUND", "Computer said no, check stock spelling" +
            " or contact person who typed this message.");
    Logger logger = LoggerFactory.getLogger(StockExchangeController.class);

    @Autowired
    public StockExchangeController(StockService service) {
        this.service = service;
    }

    @GetMapping("/{stockId}")
    public StockDTO getStock(@PathVariable String stockId){
        ModelMapper stockToStockDTO = new ModelMapper();

        try{
            return stockToStockDTO.map(service.getStock(stockId) ,StockDTO.class);
        } catch (NoSuchElementException noSuchElEx) {
            System.err.println("That stock doesn't exist!" + noSuchElEx);
        }
        logger.warn("COMPUTER SAYS NO!");
        return stockToStockDTO.map(defaultErrorStock, StockDTO.class);
    }

    @GetMapping("/hello")
    public String helloExample() {
        logger.trace("I'll update you on every heartbeat 💓");
        logger.debug("I'm taking a (sub)step 🚶");
        logger.info("Business as usual, I processed an action correctly");
        logger.warn("Warning ⚠ I do not trust this situation?!");
        logger.error("Help 🆘 Something is broken!");
        return "<h1>`System.out.println();` is forbidden!</h1><p>Logging for the win!</p>";
    }
}
