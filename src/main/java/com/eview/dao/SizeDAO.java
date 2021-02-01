/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao;

import com.eview.dao.impl.ISizeDAO;
import com.eview.model.Size;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository(value = "sizeDAO")
@Transactional
public class SizeDAO implements ISizeDAO{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Size save(Size t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Size update(Size t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Size delete(int id) {
        Size cat = (Size) sessionFactory.getCurrentSession().load(Size.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Size> getAll() {
        List<Size> banList = sessionFactory.getCurrentSession().createCriteria(Size.class).list();
        return banList;
    }

    @Override
    public Size getById(int id) {
        Size cat = (Size) sessionFactory.getCurrentSession().get(Size.class, id);
        return cat;
    }

}
