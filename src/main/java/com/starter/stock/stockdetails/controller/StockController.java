package com.starter.stock.stockdetails.controller;

import com.starter.stock.stockdetails.model.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockModel stockModel;

    @GetMapping ("/share")
    public String stockDetails(@RequestParam(name="stock") String stockName) throws IOException {
         //stockModel=new StockModel();
         System.out.println("stockName" + stockName);
        return stockModel.stockDetails(stockName);
    }

}
