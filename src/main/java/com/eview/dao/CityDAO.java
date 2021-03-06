/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao;

import com.eview.dao.impl.ICityDAO;
import com.eview.model.City;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository(value = "cityDAO")
@Transactional
public class CityDAO implements ICityDAO{
    
    @Autowired
    SessionFactory sessionFactory;

       @Override
    public City save(City t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public City update(City t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public City delete(int id) {
    City c = (City) sessionFactory.getCurrentSession().load(City.class, id);
    sessionFactory.getCurrentSession().delete(c);
    return c;      
    }

    @Override
    public List<City> getAll() {
    List<City> cList = sessionFactory.getCurrentSession().createCriteria(City.class).list();
        return cList;    
    }

    @Override
    public City getById(int id) {
    City c = (City) sessionFactory.getCurrentSession().get(City.class, id);
       return c;    
    }
}
