package com.eview.dao;

import com.eview.dao.impl.IPaymentDAO;
import com.eview.model.Payment;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "paymentDAO")
@Transactional
public class PaymentDAO implements IPaymentDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Payment save(Payment t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Payment update(Payment t) {

        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Payment delete(int id) {
        Payment cat = (Payment) sessionFactory.getCurrentSession().load(Payment.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Payment> getAll() {
        List<Payment> payList = sessionFactory.getCurrentSession().createCriteria(Payment.class).list();
        return payList;
    }

    @Override
    public Payment getById(int id) {
        Payment pay = (Payment) sessionFactory.getCurrentSession().get(Payment.class, id);
        return pay;
    }

}
