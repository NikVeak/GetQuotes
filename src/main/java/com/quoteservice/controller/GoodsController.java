
package com.quoteservice.controller;

import com.quoteservice.service.GoodService;
import com.quoteservice.service.KafkaSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    KafkaSender kafkaSender;

    @GetMapping("/commodity/oil_brent")
    public void getOil()
    {
        Map<String, Object> data = goodService.getOil();
        kafkaSender.sendMessage(data, "topicOil");
    }

    @GetMapping("/commodity/month/oil_brent")
    public void getOilMonth()
    {
        Map<String, Object> data = goodService.getOilMonth();
        kafkaSender.sendMessage(data, "topicOilMonth");
    }
    @GetMapping("/commodity/year/oil_brent")
    public void getOilYeah()
    {
        Map<String, Object> data = goodService.getOilYeah();
        kafkaSender.sendMessage(data, "topicOilYear");
    }

    @GetMapping("/commodity/gold")
    public void getGold()
    {
        Map<String, Object> data = goodService.getGoldCurrent();
        kafkaSender.sendMessage(data, "topicGold");
    }

    @GetMapping("/commodity/silver")
    public void getSilver()
    {
        Map<String, Object> data = goodService.getSilverCurrent();
        kafkaSender.sendMessage(data, "topicSilver");
    }

    @GetMapping("/commodity/platinum")
    public void getPlatinum()
    {
        Map<String, Object> data = goodService.getPlatinumCurrent();
        kafkaSender.sendMessage(data, "topicPlatinum");
    }

    @GetMapping("/commodity/palladium")
    public void getPalladium()
    {
        Map<String, Object> data = goodService.getPalladiumCurrent();
        kafkaSender.sendMessage(data, "topicPalladium");
    }
}

