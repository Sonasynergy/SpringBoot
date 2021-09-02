package com.sf.company.supermarket.dao;

import com.sf.company.supermarket.entity.Market;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;

@Repository
public class MarketDaoImpl implements MarketDao{
        private EntityManager entityManager;

        @Autowired
        public MarketDaoImpl(EntityManager theEntityManager) {
            entityManager = theEntityManager;
        }

    @Override
    public List<Market> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Market> theQuery = currentSession.createQuery("from Market", Market.class);
        List<Market> markets = theQuery.getResultList();
        return markets;
    }

    @Override
    public List<String> findName() {
        Session currentSession = entityManager.unwrap(Session.class);
        NativeQuery res=currentSession.createSQLQuery("select name from Market");
        List<String> results=res.getResultList();
        return results;
    }


    @Override
    public Market findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Market themarket = currentSession.get(Market.class, theId);
        return themarket;
    }


    @Override
    public void save(Market themarket) {
        Session currentSession = entityManager.unwrap(Session.class);
//        currentSession.saveOrUpdate(themarket.get);
        currentSession.saveOrUpdate(themarket);
    }


    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Market where id=:marketId");
        theQuery.setParameter("marketId", theId);
        theQuery.executeUpdate();
    }


}
