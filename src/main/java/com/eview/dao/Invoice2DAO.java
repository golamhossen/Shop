package com.eview.dao;

import com.eview.dao.impl.IInvoice2DAO;
import com.eview.model.Invoice2;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "invoice2DAO")
@Transactional
public class Invoice2DAO implements IInvoice2DAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Invoice2 save(Invoice2 t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Invoice2 update(Invoice2 t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Invoice2 delete(int id) {
        Invoice2 in = (Invoice2) sessionFactory.getCurrentSession().load(Invoice2.class, id);
        sessionFactory.getCurrentSession().delete(in);
        return in;
    }

    @Override
    public List<Invoice2> getAll() {
        List<Invoice2> inList = sessionFactory.getCurrentSession().createCriteria(Invoice2.class).list();
        return inList;
    }

    @Override
    public Invoice2 getById(int id) {
        Invoice2 in = (Invoice2) sessionFactory.getCurrentSession().get(Invoice2.class, id);
        return in;
    }

}
