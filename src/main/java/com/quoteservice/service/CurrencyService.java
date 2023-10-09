package com.quoteservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate;

    // api key exchangerates
    //private String apiKey = "457e515183f6a4574dcde42a12c1ed34";
    // api key exchange rate-api
    private String apiKey = "aa8b23249048bc1e37ede957";

    public CurrencyService() {
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Object> getCurrencyDollar() {
        //String url = "http://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey + "&base=USD&symbols=RUB";
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"pair/USD/RUB";
        Map<String, String> params = new HashMap<>();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class, params);
        Map<String, Object> currencyInfo = response.getBody();
        return currencyInfo;
    }

    public Map<String, Object> getCurrencyHKD()
    {
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"pair/HKD/RUB";
        Map<String, String> params = new HashMap<>();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class, params);
        Map<String, Object> currencyInfo = response.getBody();
        return currencyInfo;
    }

    public Map<String, Object> getCurrencyCNY()
    {
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"pair/CNY/RUB";
        Map<String, String> params = new HashMap<>();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class, params);
        Map<String, Object> currencyInfo = response.getBody();
        return currencyInfo;
    }

    /*public Map<String, Object> getCurrencyInfoUSDRUB()
    {
        String url = "https://iss.moex.com/iss/engines/currency/markets/selt/boards/CETS/securities/USD000UTSTOM.json";
        Map<String, String> params = new HashMap<>();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class, params);
        Map<String, Object> currencyInfo = response.getBody();
        return currencyInfo;
    }

    public Map<String, Object> getCurrencyInfoCNYRUB()
    {
        String url = "https://iss.moex.com/iss/engines/currency/markets/selt/boards/CETS/securities/CNY000000TOD.json";
        Map<String, String> params = new HashMap<>();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class, params);
        Map<String, Object> currencyInfo = response.getBody();
        return currencyInfo;
    }

    public Map<String, Object> getCurrencyInfoHKDRUB()
    {
        String url = "https://iss.moex.com/iss/engines/currency/markets/selt/boards/CETS/securities/HKDRUB_TOM.json";
        Map<String, String> params = new HashMap<>();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class, params);
        Map<String, Object> currencyInfo = response.getBody();
        return currencyInfo;
    }*/
}

