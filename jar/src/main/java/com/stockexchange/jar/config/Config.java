package com.stockexchange.jar.config;

import com.stockexchange.domain.StockRepository;
import com.stockexchange.service.StockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = {"com.stockexchange.api", "com.stockexchange.domain"})
public class Config {

    @Bean
    public StockService getStockService(){
        return new StockService(new StockRepository());
    }

    /*@Bean
    public StockRepository getStockRepository(){
        return new StockRepository();
    }*/
}
