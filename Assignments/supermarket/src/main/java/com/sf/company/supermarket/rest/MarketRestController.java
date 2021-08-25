package com.sf.company.supermarket.rest;


import com.sf.company.supermarket.entity.Market;
import com.sf.company.supermarket.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MarketRestController {


    private MarketService marketService;

    @Autowired
    public MarketRestController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/markets")
    public List<Market> findAll() {
        return marketService.findAll();
    }

    @GetMapping("/markets/name")
    public List<String> findName() {
        return marketService.findName();
    }

    @GetMapping("/markets/{marketId}")
    public Market getMarket(@PathVariable int marketId) {
        Market themarket = marketService.findById(marketId);
        if (themarket == null) {
            throw new RuntimeException("MarketId id not found - " + marketId);
        }
        return themarket;
    }

    @PostMapping("/markets")
    public Market addMarket(@RequestBody Market themarket) {
        themarket.setId(0);
        marketService.save(themarket);
        return themarket;
    }

    @PutMapping("/markets")
    public Market updateMarket(@RequestBody Market themarket) {
        marketService.save(themarket);
        return themarket;
    }

    @DeleteMapping("/markets/{marketId}")
    public String deleteMarket(@PathVariable int marketId) {
        Market tempmarket = marketService.findById(marketId);
        if (tempmarket == null) {
            throw new RuntimeException("Market id not found - " + marketId);
        }
        marketService.deleteById(marketId);
        return "Deleted market id - " + marketId;
    }


}
