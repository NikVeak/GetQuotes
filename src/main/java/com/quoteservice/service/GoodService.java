package com.quoteservice.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodService
{
    private final RestTemplate restTemplate;

    private String apiKey = "598585cf9282407b8f6c222a39c68c69";
    private String apikeyMetal = "goldapi-4zo16lnh3gxjn-io";
    public GoodService()
    {
        this.restTemplate = new RestTemplate();
    }
    public Map<String, Object> getOil()
    {
        String url = "https://api.oilpriceapi.com/v1/prices/latest?apikey="+apiKey;
        Map<String, String> params = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token "+apiKey);
        //params.put("authorization", apiKey);

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, 1);

        Map<String, Object> goodInfo = response.getBody();
        return goodInfo;
    }

    public Map<String, Object> getOilMonth()
    {
        String url = "https://api.oilpriceapi.com/v1/prices/past_month";
        Map<String, String> params = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token "+apiKey);
        //params.put("authorization", apiKey);

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, 1);

        Map<String, Object> goodInfo = response.getBody();
        return goodInfo;
    }

    public Map<String, Object> getOilYeah()
    {
        String url = "https://api.oilpriceapi.com/v1/prices/past_yeah";
        Map<String, String> params = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token "+apiKey);
        //params.put("authorization", apiKey);

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, 1);

        Map<String, Object> goodInfo = response.getBody();
        return goodInfo;
    }

    public Map<String, Object> getGoldCurrent()
    {
        String url = "https://www.goldapi.io/api/XAU/USD";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-access-token", apikeyMetal);

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, 1);

        Map<String, Object> goodInfo = response.getBody();
        return goodInfo;
    }

    public Map<String, Object> getSilverCurrent()
    {
        String url = "https://www.goldapi.io/api/XAG/USD";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-access-token", apikeyMetal);

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, 1);

        Map<String, Object> goodInfo = response.getBody();
        return goodInfo;
    }

    public Map<String, Object> getPlatinumCurrent()
    {
        String url = "https://www.goldapi.io/api/XPT/USD";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-access-token", apikeyMetal);

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, 1);

        Map<String, Object> goodInfo = response.getBody();
        return goodInfo;
    }

    public Map<String, Object> getPalladiumCurrent()
    {
        String url = "https://www.goldapi.io/api/XPD/USD";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-access-token", apikeyMetal);

        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, 1);

        Map<String, Object> goodInfo = response.getBody();
        return goodInfo;
    }


}
