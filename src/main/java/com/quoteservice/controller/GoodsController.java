package com.quoteservice.controller;

import com.quoteservice.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class GoodsController
{
    private final GoodService goodService;
    @GetMapping("/commodity/oil_brent")
    public Map<String, Object> getOil()
    {
        Map<String, Object> dat = goodService.getOil();
        return dat;
    }

    @GetMapping("/commodity/month/oil_brent")
    public Map<String, Object> getOilMonth()
    {
        Map<String, Object> dat = goodService.getOilMonth();
        return dat;
    }
    @GetMapping("/commodity/year/oil_brent")
    public Map<String, Object> getOilYeah()
    {
        Map<String, Object> dat = goodService.getOilYeah();
        return dat;
    }

    @GetMapping("/commodity/gold")
    public Map<String, Object> getGold()
    {
        Map<String, Object> dat = goodService.getGoldCurrent();
        return dat;
    }

    @GetMapping("/commodity/silver")
    public Map<String, Object> getSilver()
    {
        Map<String, Object> dat = goodService.getSilverCurrent();
        return dat;
    }

    @GetMapping("/commodity/platinum")
    public Map<String, Object> getPlatinum()
    {
        Map<String, Object> dat = goodService.getPlatinumCurrent();
        return dat;
    }

    @GetMapping("/commodity/palladium")
    public Map<String, Object> getPalladium()
    {
        Map<String, Object> dat = goodService.getPalladiumCurrent();
        return dat;
    }
}
