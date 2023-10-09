package com.quoteservice.controller;

import com.quoteservice.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quotes")
public class BondsController
{
    private final BondService bondService;
    /*@GetMapping("/bond/{symbols}")
    public Map<String, Object> getBond(String symbol)
    {
        return bondService.getBondInfo(String symbol);
    }*/

}
