/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao;

import com.eview.dao.impl.IBrandDAO;
import com.eview.model.Brand;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author B12
 */
@Repository(value = "brandDAO")
@Transactional
public class BrandDAO  implements IBrandDAO{
      @Autowired
    SessionFactory sessionFactory;

    @Override
    public Brand save(Brand t) {
    sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Brand update(Brand t) {
   
    sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Brand delete(int id) {
   Brand cat = (Brand) sessionFactory.getCurrentSession().load(Brand.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Brand> getAll() {
    List<Brand> brandList = sessionFactory.getCurrentSession().createCriteria(Brand.class).list();
        return brandList;
    }

    @Override
    public Brand getById(int id) {
   Brand cat = (Brand) sessionFactory.getCurrentSession().get(Brand.class, id);
        return cat;
    }
      
}
