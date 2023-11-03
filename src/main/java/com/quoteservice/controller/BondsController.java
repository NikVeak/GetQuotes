/*
package com.quoteservice.controller;

import com.quoteservice.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quotes")
public class BondsController
{
    private final BondService bondService;
    @GetMapping("/bond/{symbols}")
    public Map<String, Object> getBond(String symbol)
    {
        return bondService.getBondInfo(symbol);
    }

}
*/
