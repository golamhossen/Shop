package com.eview.dao;

import com.eview.dao.impl.ICheckoutDAO;
import com.eview.model.Checkout;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "checkoutDAO")
@Transactional
public class CheckoutDAO implements ICheckoutDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Checkout save(Checkout t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Checkout update(Checkout t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Checkout delete(int id) {
        Checkout cat = (Checkout) sessionFactory.getCurrentSession().load(Checkout.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Checkout> getAll() {
        List<Checkout> banList = sessionFactory.getCurrentSession().createCriteria(Checkout.class).list();
        return banList;
    }

    @Override
    public Checkout getById(int id) {
        Checkout cat = (Checkout) sessionFactory.getCurrentSession().get(Checkout.class, id);
        return cat;
    }

}
