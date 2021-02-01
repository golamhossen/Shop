package com.eview.dao;

import com.eview.dao.impl.IStockDAO;
import com.eview.model.Stock;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "stockDAO")
@Transactional
public class StockDAO implements IStockDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Stock save(Stock t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Stock update(Stock t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Stock delete(int id) {
        Stock p = (Stock) sessionFactory.getCurrentSession().load(Stock.class, id);
        sessionFactory.getCurrentSession().delete(id);
        return p;
    }

    @Override
    public List<Stock> getAll() {
        List<Stock> pList = sessionFactory.getCurrentSession().createCriteria(Stock.class).list();
        return pList;
    }

    @Override
    public Stock getById(int id) {
        Stock p = (Stock) sessionFactory.getCurrentSession().get(Stock.class, id);
        return p;
    }

    @Override
    public Stock getByProductCode(String pCode) {
        String hql = "from stock where pCode = :pCode";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pCode", pCode);
        Stock s = (Stock) query.uniqueResult();
        if (s != null) {
            return s;
        } else {
            return null;
        }
    }

}
