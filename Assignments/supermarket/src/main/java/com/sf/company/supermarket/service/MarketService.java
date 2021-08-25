package com.sf.company.supermarket.service;

import com.sf.company.supermarket.entity.Market;

import java.util.List;

public interface MarketService {

    public List<Market> findAll();

    public List<String> findName();

    public Market findById(int theId);

    public void save(Market theMarket);

    public void deleteById(int theId);
}
