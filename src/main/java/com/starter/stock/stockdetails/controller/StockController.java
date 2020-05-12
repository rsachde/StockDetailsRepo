package com.starter.stock.stockdetails.controller;

import com.starter.stock.stockdetails.model.StockAttributes;
import com.starter.stock.stockdetails.model.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockModel stockModel;
    @Autowired
    private StockAttributes stockAttributes;



    @GetMapping("/details")
    public String getStock(Model model) throws IOException {
        stockAttributes= stockModel.stockDetails("INTC");
       model.addAttribute("value",stockAttributes);
        System.out.println("Ria");
        System.out.println("Ria");
            return "stocks";
    }

    @GetMapping("/home")
    public String homely(){
        return "home";
    }

    @GetMapping("/start")
    public String homePage(@RequestParam(name="StockName") String stockName, Model model) throws IOException {
        System.out.println("stockName" + stockName);
        String name=stockName.toString();
        stockAttributes=stockModel.stockDetails(name);
        model.addAttribute("value",stockAttributes);
        System.out.println("Rias");
        return "stocks";
    }


    @GetMapping ("/share")
    public StockAttributes stockDetails(@RequestParam(name="stock") String stockName) throws IOException {
        System.out.println("stockName" + stockName);
        return stockModel.stockDetails(stockName);
    }
    @GetMapping(value = "/share/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE )
    public Map<String, Stock> listStockDetails(@RequestParam(name="stock") List<String> stockName) throws IOException {
        System.out.println("stock List" + "Enter");
        return stockModel.stockDetailsList(stockName);
    }

}
