package com.stockexchange.cli;

import com.stockexchange.api.StockExchangeController;
import com.stockexchange.domain.Stock;
import com.stockexchange.domain.StockDTO;
import com.stockexchange.domain.StockRepository;
import com.stockexchange.service.StockService;

import java.util.NoSuchElementException;

public class MyCLI {
    public static void main(String[] args) {
        StockRepository repository = new StockRepository();
        StockService stockService = new StockService(repository);
        StockExchangeController controller = new StockExchangeController(stockService);

        if(args.length == 0){
            System.out.println("The point of the exercise is that you look for stock, dufus.");
        }
        else if(args.length > 1){
            System.out.println("Can only look for one stock at a time");
        }
        else{
            try{
                StockDTO searchedForStock = controller.getStock(args[0]);
                System.out.println(searchedForStock.toString());
            } catch (NoSuchElementException noSuchElEx){
                System.err.println("That stock doesn't exist!");
            }
        }
    }
}
