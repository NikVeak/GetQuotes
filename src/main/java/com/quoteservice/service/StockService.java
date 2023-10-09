package com.quoteservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
public class StockService
{
    private final RestTemplate restTemplate;
    public StockService()
    {
        this.restTemplate = new RestTemplate();
    }
    // api key polygon
    //public String apiKey = "k_2mQ_A1Rk9YNlqfOIw0Sw2YmEaaJ1mB";
    //api key finhub
    //public String apiKey = "ckb7nr1r01ql5f1ndc50ckb7nr1r01ql5f1ndc5g";
    // api key marketstack
    //public String apiKey = "12757c04acb7102f1a59d39abef2f6f4";
    //api key tinkoff
    //public String apiKey = "t.dd0ELgKstLpVGtekTS3zCk_T4XZWYiFO13uH7x4kdWyompBDcg-WRKaLWLhWqefwEdpyKW71KIk7lgUji4So9A";


    // возращаем список акций (тикер, текущая цена)
    //--------------------------------------------
    public Map<String, Object> getLS() throws IOException {
        String url = "https://iss.moex.com/iss/engines/stock/markets/shares/boards/tqbr/securities.json?iss.meta=off&iss.only=marketdata&marketdata.columns=SECID,LAST";

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> stockInfo = response.getBody();
        return stockInfo;
    }
    //-------------------------------------------------------

    //-----------------------------------------------------------------------------
    public Map<String, Object> getStockInfo(String symbol)
    {
        String url = "https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/"+symbol+".json";
        Map<String, String> params = new HashMap<>();
        params.put("symbol", symbol);

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class, params);
        Map<String, Object> stockInfo = response.getBody();
        return stockInfo;
    }
    //-----------------------------------------------------------------------------------------------


    //-------------------------------------------------------------------------------------------------------------------
    // информация о акции за один месяц
    public Map<String, Object> getStockHistoryMonth(String symbol) throws IOException {

        String BASE_url = "https://iss.moex.com/iss/history/engines/stock/markets/shares/boards/TQBR/securities/{symbol}.json?from={from}&till={till}&history.columns=TRADEDATE,SHORTNAME,SECID,CLOSE";
        String url = BASE_url.replace("{symbol}", symbol)
                .replace("{from}", getCurrentDateMinus30Days())
                .replace("{till}", getCurrentDate());

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> stocksInfo = response.getBody();
        return stocksInfo;
    }
    //----------------------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------------------
    // информация о акции за год
    public Map<String, Object> getStockHistoryYear(String symbol) throws IOException {

        String BASE_url = "https://iss.moex.com/iss/history/engines/stock/markets/shares/boards/TQBR/securities/{symbol}.json?from={from}&till={till}&history.columns=TRADEDATE,SHORTNAME,SECID,CLOSE";
        String url = BASE_url.replace("{symbol}", symbol)
                .replace("{from}", getCurrentDateMinus365Days())
                .replace("{till}", getCurrentDate());

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> stocksInfo = response.getBody();
        return stocksInfo;
    }
    //------------------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------------------
    // информация о акции за 5 лет
    public Map<String, Object> getStockHistory5Year(String symbol) throws IOException {

        String BASE_url = "https://iss.moex.com/iss/history/engines/stock/markets/shares/boards/TQBR/securities/{symbol}.json?from={from}&till={till}&history.columns=TRADEDATE,SHORTNAME,SECID,CLOSE";
        String url = BASE_url.replace("{symbol}", symbol)
                .replace("{from}", getCurrentDateMinus1825Days())
                .replace("{till}", getCurrentDate());

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> stocksInfo = response.getBody();
        return stocksInfo;
    }
    //------------------------------------------------------------------------------------------

    //--------------------------------------------------------
    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DateTimeFormatter.ISO_DATE);
    }

    private String getCurrentDateMinus30Days() {
        LocalDate currentDate = LocalDate.now().minus(30, ChronoUnit.DAYS);
        return currentDate.format(DateTimeFormatter.ISO_DATE);
    }

    private String getCurrentDateMinus365Days() {
        LocalDate currentDate = LocalDate.now().minus(365, ChronoUnit.DAYS);
        return currentDate.format(DateTimeFormatter.ISO_DATE);
    }

    private String getCurrentDateMinus1825Days() {
        LocalDate currentDate = LocalDate.now().minus(1825, ChronoUnit.DAYS);
        return currentDate.format(DateTimeFormatter.ISO_DATE);
    }
    //-----------------------------------------------------------------------
}
