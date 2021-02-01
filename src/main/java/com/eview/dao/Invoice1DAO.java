
package com.eview.dao;

import com.eview.dao.impl.IInvoice1DAO;
import com.eview.model.Invoice1;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "invoice1DAO")
@Transactional
public class Invoice1DAO implements IInvoice1DAO{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Invoice1 save(Invoice1 t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Invoice1 update(Invoice1 t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Invoice1 delete(int id) {
    Invoice1 in = (Invoice1) sessionFactory.getCurrentSession().load(Invoice1.class, id);
    sessionFactory.getCurrentSession().delete(in);
    return in;      
    }

    @Override
    public List<Invoice1> getAll() {
    List<Invoice1> inList = sessionFactory.getCurrentSession().createCriteria(Invoice1.class).list();
        return inList;    
    }

    @Override
    public Invoice1 getById(int id) {
    Invoice1 in = (Invoice1) sessionFactory.getCurrentSession().get(Invoice1.class, id);
       return in;    
    }

   
}
