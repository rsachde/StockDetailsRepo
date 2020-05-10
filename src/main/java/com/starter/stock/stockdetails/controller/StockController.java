package com.starter.stock.stockdetails.controller;

import com.starter.stock.stockdetails.model.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockModel stockModel;

    @GetMapping ("/share")
    public String stockDetails(@RequestParam(name="stock") String stockName) throws IOException {
        System.out.println("stockName" + stockName);
        return stockModel.stockDetails(stockName);
    }

    @GetMapping(value = "/share/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE )
    public Map<String, Stock> listStockDetails(@RequestParam(name="stock") List<String> stockName) throws IOException {
        System.out.println("stock List" + "Enter");
        return stockModel.stockDetailsList(stockName);
    }

}
