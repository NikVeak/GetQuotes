package com.quoteservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BondService
{
    private final RestTemplate restTemplate;
    public BondService()
    {
        this.restTemplate = new RestTemplate();
    }

    /*public Map<String, Object> getBondInfo(String symbol)
    {

    }*/
}
