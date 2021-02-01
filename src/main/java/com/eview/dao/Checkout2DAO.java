
package com.eview.dao;

import com.eview.dao.impl.ICheckout2DAO;
import com.eview.model.Checkout2;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "checkout2DAO")
@Transactional
public class Checkout2DAO implements ICheckout2DAO{

     @Autowired
    SessionFactory sessionFactory;

    @Override
    public Checkout2 save(Checkout2 t) {
    sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Checkout2 update(Checkout2 t) {
   
    sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Checkout2 delete(int id) {
   Checkout2 cat = (Checkout2) sessionFactory.getCurrentSession().load(Checkout2.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Checkout2> getAll() {
    List<Checkout2> brandList = sessionFactory.getCurrentSession().createCriteria(Checkout2.class).list();
        return brandList;
    }

    @Override
    public Checkout2 getById(int id) {
   Checkout2 cat = (Checkout2) sessionFactory.getCurrentSession().get(Checkout2.class, id);
        return cat;
    }
      
}
