package com.sf.company.supermarket.dao;

import com.sf.company.supermarket.entity.Market;

import java.util.List;

public interface MarketDao {

    public List<Market> findAll();
    public List<String> findName();

    public Market findById(int theId);

    public void save(Market theMarket);

    public void deleteById(int theId);
}
