package com.starter.stock.stockdetails.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockAttributes {

    String currency;
    BigDecimal price;
    BigDecimal dayLow;
    BigDecimal yearLow;
    BigDecimal dayHigh;
    BigDecimal yearHigh;
    BigDecimal dividend;
    BigDecimal change;
    BigDecimal bid;
}
