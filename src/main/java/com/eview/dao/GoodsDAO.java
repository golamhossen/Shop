/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao;

import com.eview.dao.impl.IGoodsDAO;
import com.eview.model.Goods;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author B12
 */
@Repository(value = "goodsDAO")
@Transactional
public class GoodsDAO implements IGoodsDAO{
    
    @Autowired
    SessionFactory sessionFactory;
    
    

    @Override
    public Goods save(Goods t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Goods update(Goods t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Goods delete(int id) {
    Goods c = (Goods) sessionFactory.getCurrentSession().load(Goods.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<Goods> getAll() {
    List<Goods> cList = sessionFactory.getCurrentSession().createCriteria(Goods.class).list();
        return cList;    
    }

    @Override
    public Goods getById(int id) {
    Goods c = (Goods) sessionFactory.getCurrentSession().get(Goods.class, id);
       return c;    
    }

    @Override
    public Goods save(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
