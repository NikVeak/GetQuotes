package com.quoteservice.model;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class Stock
{
    private String ticker;
    private String name_stock;

    private String isin;

    private double price;

    private LocalDateTime date_time;



    public String getTicker() {
        return ticker;
    }

    public LocalDateTime getDate_time()
    {
        return date_time;
    }

    public String getName_stock() {
        return name_stock;
    }

    public double getPrice() {
        return price;
    }


    public void setName_stock(String name_stock) {
        this.name_stock = name_stock;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public void printValue()
    {
        System.out.println(this.ticker);
        System.out.println(this.name_stock);
        System.out.println(this.isin);
        System.out.println(this.price);
        System.out.println(this.date_time);
    }
}
