package com.eview.dao;

import com.eview.dao.impl.IContactDAO;
import com.eview.model.Contact;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "contactDAO")
@Transactional
public class ContactDAO implements IContactDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Contact save(Contact t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Contact update(Contact t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Contact delete(int id) {
        Contact cat = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> conList = sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
        return conList;
    }

    @Override
    public Contact getById(int id) {
        Contact cat = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
        return cat;
    }

}
