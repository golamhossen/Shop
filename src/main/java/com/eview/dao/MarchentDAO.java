/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao;

import com.eview.dao.impl.IMarchentDAO;
import com.eview.model.Marchent;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository(value = "marchentDAO")
@Transactional
public class MarchentDAO implements IMarchentDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Marchent save(Marchent t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Marchent update(Marchent t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Marchent delete(int id) {
        Marchent m = (Marchent) sessionFactory.getCurrentSession().load(Marchent.class, id);
        sessionFactory.getCurrentSession().delete(id);
        return m;
    }

    @Override
    public List<Marchent> getAll() {
        List<Marchent> mList = sessionFactory.getCurrentSession().createCriteria(Marchent.class).list();
        return mList;
    }

    @Override
    public Marchent getById(int id) {
        Marchent m = (Marchent) sessionFactory.getCurrentSession().get(Marchent.class, id);
        return m;
    }

}
