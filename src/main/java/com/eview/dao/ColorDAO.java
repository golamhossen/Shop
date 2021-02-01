/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao;

import com.eview.dao.impl.IColorDAO;
import com.eview.model.Color;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "colorDAO")
@Transactional
public class ColorDAO implements IColorDAO{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Color save(Color t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Color update(Color t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Color delete(int id) {
        Color cat = (Color) sessionFactory.getCurrentSession().load(Color.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Color> getAll() {
        List<Color> banList = sessionFactory.getCurrentSession().createCriteria(Color.class).list();
        return banList;
    }

    @Override
    public Color getById(int id) {
        Color cat = (Color) sessionFactory.getCurrentSession().get(Color.class, id);
        return cat;
    }

    
}
