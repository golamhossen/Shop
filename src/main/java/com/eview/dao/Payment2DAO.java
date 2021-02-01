package com.eview.dao;

import com.eview.dao.impl.IPayment2DAO;
import com.eview.model.Payment2;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "payment2DAO")
@Transactional
public class Payment2DAO implements IPayment2DAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Payment2 save(Payment2 t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Payment2 update(Payment2 t) {

        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Payment2 delete(int id) {
        Payment2 cat = (Payment2) sessionFactory.getCurrentSession().load(Payment2.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Payment2> getAll() {
        List<Payment2> payList = sessionFactory.getCurrentSession().createCriteria(Payment2.class).list();
        return payList;
    }

    @Override
    public Payment2 getById(int id) {
        Payment2 pay = (Payment2) sessionFactory.getCurrentSession().get(Payment2.class, id);
        return pay;
    }

}
