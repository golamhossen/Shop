/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao;

import com.eview.dao.impl.ICustomerDAO;
import com.eview.model.Customer;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author B12
 */
@Repository(value = "customerDAO")
@Transactional
public class CustomerDAO implements ICustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Customer save(Customer t) {
        sessionFactory.getCurrentSession().save(t);
        sessionFactory.getCurrentSession().flush();
        return t;
    }

    @Override
    public Customer update(Customer t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Customer delete(int id) {
        Customer c = (Customer) sessionFactory.getCurrentSession().load(Customer.class, id);
        sessionFactory.getCurrentSession().delete(c);
        return c;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> cList = sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
        return cList;
    }

    @Override
    public Customer getById(int id) {
        Customer c = (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
        return c;
    }
}
