package com.starter.stock.stockdetails;

import com.starter.stock.stockdetails.configuration.AppConfig;
import com.starter.stock.stockdetails.model.StockAttributes;
import com.starter.stock.stockdetails.model.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Calendar;

@SpringBootApplication
public class StockdetailsApplication {



    public static void main(String[] args) throws IOException {
        StockModel stockModel = new StockModel();
      ApplicationContext ctx=  SpringApplication.run(StockdetailsApplication.class, args);
      System.out.println(stockModel.stockDetailsTime("INTC", 2015, 2016));
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
