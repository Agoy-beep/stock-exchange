package com.stockexchange.jar;

import com.stockexchange.api.StockExchangeController;
import com.stockexchange.domain.StockDTO;
import com.stockexchange.jar.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.NoSuchElementException;


public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        StockExchangeController controller = context.getBean(StockExchangeController.class);

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
                System.out.println("Yay!");
            } catch (NoSuchElementException noSuchElEx){
                System.err.println("That stock doesn't exist!");
            }
        }
    }


}
