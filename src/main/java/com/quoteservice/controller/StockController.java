package com.quoteservice.controller;

import com.quoteservice.model.Stock;
import com.quoteservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quotes")
public class StockController {
    private final StockService stockService;
    //private final StockList listStock;

    // запрос списка акций
    //--------------------------------------------
    @GetMapping("/stocks/list_stocks")
    public ArrayList<Object> getListStocks() throws IOException
    {
        Map<String, Object> response = stockService.getLS();
        Map<String, Object> dat = (Map<String, Object>) response.get("marketdata");
        ArrayList<Object>  dt = (ArrayList<Object>) dat.get("data");
        return dt;
    }
    //---------------------------------------------

    // запрос цены акции за месяц
    //------------------------------------------------------
    @GetMapping("/stocks/month/{symbols}")
    public Map<String, Object> getStockMonth(String symbol) throws IOException {
        Map<String, Object> response  = stockService.getStockHistoryMonth(symbol);
        return response;
    }
    //----------------------------------------------------------

    // запрос цены акции за год
    //------------------------------------------------------
    @GetMapping("/stocks/year/{symbols}")
    public Map<String, Object> getStockYeah(String symbol) throws IOException {
        Map<String, Object> response  = stockService.getStockHistoryYear(symbol);
        return response;
    }
    //----------------------------------------------------------

    // запрос цены акции за 5 лет
    //------------------------------------------------------
    @GetMapping("/stocks/five_year/{symbols}")
    public Map<String, Object> getStock5Year(String symbol) throws IOException {
        Map<String, Object> response  = stockService.getStockHistory5Year(symbol);
        return response;
    }
    //----------------------------------------------------------


    //-----------------------------------------------
    // получение информации одной акции
    @PostMapping("/stocks")
    public Stock AddStock(@RequestBody String symbol) throws IOException {
        Stock stock = new Stock();
        Map<String, Object> response = stockService.getStockInfo(symbol);
        Map<String, Object> dat = (Map<String, Object>) response.get("securities");
        ArrayList<Object> dt = (ArrayList<Object>) dat.get("data");
        ArrayList<Object> data = (ArrayList<Object>) dt.get(0);

        Map<String, Object> market_dat = (Map<String, Object>) response.get("marketdata");
        ArrayList<Object> market_dt = (ArrayList<Object>) market_dat.get("data");
        ArrayList<Object> market_data = (ArrayList<Object>) market_dt.get(0);
        stock.setName_stock((String) data.get(9));
        stock.setPrice((double) market_data.get(2));
        stock.setIsin((String) data.get(20));
        stock.setTicker((String) data.get(0));
        stock.setDate_time(LocalDateTime.now());
        stock.printValue();
        return stock;
    }
    //--------------------------------------------------

    @PutMapping("/stocks/{symbols}")
    public int ChangeStock()
    {

        return 1;
    }

    @DeleteMapping("/stock/{symbols}")
    public int DeleteStock()
    {

        return 1;
    }
}
