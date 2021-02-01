package com.eview.dao;

import com.eview.dao.impl.IStock2DAO;
import com.eview.model.Stock2;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "stock2DAO")
@Transactional
public class Stock2DAO implements IStock2DAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Stock2 save(Stock2 t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Stock2 update(Stock2 t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Stock2 delete(int id) {
        Stock2 p = (Stock2) sessionFactory.getCurrentSession().load(Stock2.class, id);
        sessionFactory.getCurrentSession().delete(id);
        return p;
    }

    @Override
    public List<Stock2> getAll() {
        List<Stock2> pList = sessionFactory.getCurrentSession().createCriteria(Stock2.class).list();
        return pList;
    }

    @Override
    public Stock2 getById(int id) {
        Stock2 p = (Stock2) sessionFactory.getCurrentSession().get(Stock2.class, id);
        return p;
    }

    @Override
    public Stock2 getByGoodsCode(String pCode) {
        String hql = "from stock2 where pCode = :pCode";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pCode", pCode);
        Stock2 s = (Stock2) query.uniqueResult();
        if (s != null) {
            return s;
        } else {
            return null;
        }
    }

}
