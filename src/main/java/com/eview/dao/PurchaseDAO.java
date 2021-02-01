package com.eview.dao;

import com.eview.dao.impl.IPurchaseDAO;
import com.eview.model.Purchase;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "purchaseDAO")
@Transactional
public class PurchaseDAO implements IPurchaseDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Purchase save(Purchase t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Purchase update(Purchase t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Purchase delete(int id) {
        Purchase p = (Purchase) sessionFactory.getCurrentSession().load(Purchase.class, id);
        sessionFactory.getCurrentSession().delete(id);
        return p;
    }

    @Override
    public List<Purchase> getAll() {
        List<Purchase> pList = sessionFactory.getCurrentSession().createCriteria(Purchase.class).list();
        return pList;
    }

    @Override
    public Purchase getById(int id) {
        Purchase p = (Purchase) sessionFactory.getCurrentSession().get(Purchase.class, id);
        return p;
    }

}
