package com.quoteservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class BondService
{
    private final RestTemplate restTemplate;

    // twelvedata
    public String apiKey = "5de7b9db2b804da49bb41a8242499a2c";
    public BondService()
    {
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Object> getBondInfo(String symbol)
    {
        String url = "https://api.twelvedata.com/time_series?symbol="+symbol+"&apikey="+apiKey;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> bondInfo = response.getBody();
        return bondInfo;
    }
}
