package com.eview.dao;

import com.eview.dao.impl.IPurchase2DAO;
import com.eview.model.Purchase2;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "purchase2DAO")
@Transactional
public class Purchase2DAO implements IPurchase2DAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Purchase2 save(Purchase2 t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Purchase2 update(Purchase2 t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Purchase2 delete(int id) {
        Purchase2 p = (Purchase2) sessionFactory.getCurrentSession().load(Purchase2.class, id);
        sessionFactory.getCurrentSession().delete(id);
        return p;
    }

    @Override
    public List<Purchase2> getAll() {
        List<Purchase2> pList = sessionFactory.getCurrentSession().createCriteria(Purchase2.class).list();
        return pList;
    }

    @Override
    public Purchase2 getById(int id) {
        Purchase2 p = (Purchase2) sessionFactory.getCurrentSession().get(Purchase2.class, id);
        return p;
    }

}
