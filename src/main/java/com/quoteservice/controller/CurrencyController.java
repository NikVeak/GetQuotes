package com.quoteservice.controller;

import com.quoteservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quotes")
public class CurrencyController
{
    private final CurrencyService currencyService;

    @GetMapping("/currency/dollar")
    public Map<String, Object> getDollar()
    {
        Map<String, Object>  data = currencyService.getCurrencyDollar();
        return data;
    }

    @GetMapping("/currency/hongkongdollar")
    public Map<String, Object> getHKD()
    {
        Map<String, Object>  data = currencyService.getCurrencyHKD();
        return data;
    }

    @GetMapping("/currency/cny")
    public Map<String, Object> getCNY()
    {
        Map<String, Object>  data = currencyService.getCurrencyCNY();
        return data;
    }
    /*@GetMapping("/currency/dollar")
    public Map<String, Object> getCurrencyUSD()
    {
        Map<String, Object> dat = currencyService.getCurrencyInfoUSDRUB();
        return dat;
    }
    @GetMapping("/currency/cny")
    public  Map<String, Object> getCurrencyCNY()
    {
        Map<String, Object> dat = currencyService.getCurrencyInfoCNYRUB();
        return dat;
    }
    @GetMapping("/currency/hkd")
    public  Map<String, Object> getCurrencyHKD()
    {
        Map<String, Object> dat = currencyService.getCurrencyInfoHKDRUB();
        return dat;
    }*/
}
