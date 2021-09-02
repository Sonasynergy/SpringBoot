package com.sf.company.supermarket.rest;


import com.sf.company.supermarket.entity.Market;
import com.sf.company.supermarket.service.MarketService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MarketRestController {


    private MarketService marketService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public MarketRestController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/markets")
    public List<Market> findAll() throws InterruptedException {
        Thread.sleep(5000);
        return marketService.findAll();
    }

    @GetMapping("/market/{marketId}")
    public List<Market> getMarket(@PathVariable int marketId) throws InterruptedException {
        String url = "http://localhost:8080/api/markets";
        ResponseEntity<List<Market>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Market>>() {});
        List<Market> data = response.getBody();
        int id=0;
        List<Market> results=new ArrayList<>();
        for(Market d:data){
            id=d.getId();
            if(id==marketId){
                results.add(d);
            }
        }
        Thread.sleep(8000);
        return results;
    }

    @GetMapping("/market/name/{marketName}")
    public List<Market> getMarketRest(@PathVariable String marketName) throws InterruptedException {
        String url = "http://localhost:8080/api/markets";
        ResponseEntity<List<Market>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Market>>() {});
        List<Market> data = response.getBody();
        List<Market> results=new ArrayList<>();
        for(Market d:data){
            if((d.getStoreName()).equals(marketName))
                results.add(d);
        }
        Thread.sleep(10000);
        return results;
    }
}
