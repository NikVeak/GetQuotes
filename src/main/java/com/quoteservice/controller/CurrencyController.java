package com.quoteservice.controller;

import com.quoteservice.service.CurrencyService;
import com.quoteservice.service.KafkaSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    KafkaSender kafkaSender;
    @GetMapping("/currency/dollar")
    public void getDollar()
    {
        Map<String, Object>  data = currencyService.getCurrencyDollar();
        kafkaSender.sendMessage(data, "topicStock");
    }

    @GetMapping("/currency/hongkongdollar")
    public void getHKD()
    {
        Map<String, Object>  data = currencyService.getCurrencyHKD();
        kafkaSender.sendMessage(data, "topicStock");
    }

    @GetMapping("/currency/cny")
    public void getCNY()
    {
        Map<String, Object>  data = currencyService.getCurrencyCNY();
        kafkaSender.sendMessage(data, "topicStock");
    }

}

