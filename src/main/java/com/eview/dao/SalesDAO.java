/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao;

import com.eview.dao.impl.ISalesDAO;
import com.eview.model.Sales;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository(value = "salesDAO")
@Transactional
public class SalesDAO implements ISalesDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Sales save(Sales t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Sales update(Sales t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Sales delete(int id) {
        Sales p = (Sales) sessionFactory.getCurrentSession().load(Sales.class, id);
        sessionFactory.getCurrentSession().delete(id);
        return p;
    }

    @Override
    public List<Sales> getAll() {
        List<Sales> pList = sessionFactory.getCurrentSession().createCriteria(Sales.class).list();
        return pList;
    }

    @Override
    public Sales getById(int id) {
        Sales p = (Sales) sessionFactory.getCurrentSession().get(Sales.class, id);
        return p;
    }

    @Override
    public List<Sales> getByOrderNo(int orderNo) {
        String hql = "from sales where orderNo = :orderNo";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("orderNo", orderNo);
        List<Sales> oList = query.list();
        for (int i = 0; i < oList.size(); i++) {
            Sales s = new Sales();
            s.setpPrice(oList.get(i).getpPrice());
// salesDA
        }

        return oList;
    }

    @Override
    public String deleteByOrderNo(int orderNo) {
        String hql = "delete from sales where orderNo= :orderNo";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("orderNo", orderNo);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;

    }

}
