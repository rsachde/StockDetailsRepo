package com.starter.stock.stockdetails.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StockModel {

    @Autowired
    private StockAttributes stockAttributes;



    public StockAttributes stockDetails(String name) throws IOException {

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
        stockAttributes.setSymbol(stock.getSymbol());

        return stockAttributes;
    }

    public Map<String,Stock> stockDetailsList(List<String> stockList) throws IOException {
        String[] strings = stockList.toArray(String[]::new);
        Map<String,Stock> xyz= YahooFinance.get(strings);
        List<String> addString = new ArrayList<>();
        return xyz;
    }

    public String[] stockDetailsTime(String name, int fromYear, int toYear) throws IOException {
        Calendar from= Calendar.getInstance();
        Calendar to =Calendar.getInstance();
        from.add(Calendar.YEAR, Integer.valueOf("-" + fromYear));
        to.add(Calendar.YEAR, Integer.valueOf("-" + toYear));
        List<String> initialHist = new ArrayList<>();
        List<List<String>> histList = new ArrayList<>();

        System.out.println("from" + from);
        System.out.println("to" + to);

        Stock stock= YahooFinance.get(name);
        List<HistoricalQuote> history=stock.getHistory();
        for(HistoricalQuote hq: history)
        {
            initialHist.add(hq.getSymbol());
            initialHist.add(fetchDate(hq.getDate()));
            initialHist.add(hq.getHigh().toString());
            initialHist.add(hq.getLow().toString());
            histList.add(initialHist);
            initialHist= new ArrayList<>(); //Clearing the list initially
        }
       ListIterator<List<String>> lm= histList.listIterator();
       while(lm.hasNext())
       {
           List<String> ty= lm.next();
           ListIterator<String> tyLis= ty.listIterator();
           while(tyLis.hasNext())
           {
               System.out.print(tyLis.next() + " ");
           }
           System.out.println();
       }

        return null;
    }

    public String fetchDate(Calendar ca)
    {
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        String formatDate= format.format(ca.getTime());
        return formatDate;
    }



}
