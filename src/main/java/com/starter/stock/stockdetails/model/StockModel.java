package com.starter.stock.stockdetails.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@Service
public class StockModel {

    @Autowired
    private StockAttributes stockAttributes;

    public String stockDetails(String name) throws IOException {
        //stockAttributes=new StockAttributes();
        Stock stock= YahooFinance.get(name);
        System.out.println("stock" + stock.toString());
        stockAttributes.setBid(stock.getQuote().getBid());
        stockAttributes.setChange(stock.getQuote().getChange());
        stockAttributes.setCurrency(stock.getCurrency());
        stockAttributes.setDayHigh(stock.getQuote().getDayHigh());
        stockAttributes.setDayLow(stock.getQuote().getDayLow());
        stockAttributes.setYearHigh(stock.getQuote().getYearHigh());
        stockAttributes.setYearLow(stock.getQuote().getYearLow());
        stockAttributes.setPrice(stock.getQuote().getPrice());
        stockAttributes.setChange(stock.getQuote().getChange());

        return stockAttributes.toString();
    }


}
