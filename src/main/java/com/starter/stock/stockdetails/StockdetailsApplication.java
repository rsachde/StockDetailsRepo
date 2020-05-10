package com.starter.stock.stockdetails;

import com.starter.stock.stockdetails.configuration.AppConfig;
import com.starter.stock.stockdetails.model.StockAttributes;
import com.starter.stock.stockdetails.model.StockModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockdetailsApplication {

    public static void main(String[] args) {

      ApplicationContext ctx=  SpringApplication.run(StockdetailsApplication.class, args);
    }

    @Bean
    public StockAttributes getAttribute()
    {
        return new StockAttributes();
    }

    @Bean
    public StockModel getModel()
    {
        return new StockModel();
    }

}
