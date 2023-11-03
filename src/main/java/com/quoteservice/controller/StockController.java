package com.quoteservice.controller;

import com.quoteservice.service.KafkaSender;
import com.quoteservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quotes")
public class StockController {
    private final StockService stockService;
    @Autowired
    KafkaSender kafkaSender;

    // запрос списка акций
    //--------------------------------------------
    @GetMapping("/stocks/list_stocks")
    public void getListStocks() throws IOException
    {
        Map<String, Object> response = stockService.getLS();
        Map<String, Object> data = (Map<String, Object>) response.get("marketdata");
        kafkaSender.sendMessage(data, "topicStock");
    }
    //---------------------------------------------

    // запрос цены акции за месяц
    //------------------------------------------------------
    @GetMapping("/stocks/month/{symbols}")
    public void getStockMonth(String symbol) throws IOException {
        Map<String, Object> response  = stockService.getStockHistoryMonth(symbol);
        kafkaSender.sendMessage(response, "topicStock");
    }
    //----------------------------------------------------------

    // запрос цены акции за год
    //------------------------------------------------------
    @GetMapping("/stocks/year/{symbols}")
    public void getStockYeah(String symbol) throws IOException {
        Map<String, Object> response  = stockService.getStockHistoryYear(symbol);
        kafkaSender.sendMessage(response, "topicStock");
    }
    //----------------------------------------------------------

    // запрос цены акции за 5 лет
    //------------------------------------------------------
    @GetMapping("/stocks/five_year/{symbols}")
    public void getStock5Year(String symbol) throws IOException {
        Map<String, Object> response  = stockService.getStockHistory5Year(symbol);
        kafkaSender.sendMessage(response, "topicStock");
    }
    //----------------------------------------------------------


    //-----------------------------------------------
    // получение информации одной акции
    //--------------------------------------------------


}

