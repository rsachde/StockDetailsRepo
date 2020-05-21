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

    private StockModel stockModel;
    private StockAttributes stockAttributes;

    //Avoid field injection use either setter or getter injection

    //setter injection
    @Autowired
    public void setStockModel(StockModel stockModel) {
    this.stockModel = stockModel;
}

    //setter injection
    @Autowired
    public void setStockAttributes(StockAttributes stockAttributes) {
        this.stockAttributes = stockAttributes;
    }

    @GetMapping("/home")
    public String homely(){
        return "home";
    }

    @GetMapping("/start")
    public String homePage(@RequestParam(name="StockName") String stockName, Model model) throws IOException {
        stockAttributes=stockModel.stockDetails(stockName);
        model.addAttribute("value",stockAttributes);
        return "stocks";
    }

    @GetMapping(value = "/share/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE )
    public Map<String, Stock> listStockDetails(@RequestParam(name="stock") List<String> stockName) throws IOException {
        System.out.println("stock List" + "Enter");
        return stockModel.stockDetailsList(stockName);
    }

}
