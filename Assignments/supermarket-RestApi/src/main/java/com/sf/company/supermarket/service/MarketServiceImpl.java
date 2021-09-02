package com.sf.company.supermarket.service;

import com.sf.company.supermarket.dao.MarketDao;
import com.sf.company.supermarket.entity.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService{

    private MarketDao marketDao;

    @Autowired
    public MarketServiceImpl(MarketDao theMarketDao) {
        marketDao=theMarketDao;
    }

    @Override
    @Transactional
    public List<Market> findAll() {
        return marketDao.findAll();
    }

    @Override
    @Transactional
    public List<String> findName() {
        return marketDao.findName();
    }

    @Override
    @Transactional
    public Market findById(int theId) {
        return marketDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Market themarket) {
        marketDao.save(themarket);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        marketDao.deleteById(theId);
    }
}
