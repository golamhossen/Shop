package com.eview.dao;

import com.eview.dao.impl.IOrders2DAO;
import com.eview.model.Orders2;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "orders2DAO")
@Transactional
public class Orders2DAO implements IOrders2DAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Orders2 save(Orders2 t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Orders2 update(Orders2 t) {

        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Orders2 delete(int id) {
        Orders2 cat = (Orders2) sessionFactory.getCurrentSession().load(Orders2.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Orders2> getAll() {
        List<Orders2> orderList = sessionFactory.getCurrentSession().createCriteria(Orders2.class).list();
        return orderList;
    }

    @Override
    public Orders2 getById(int id) {
        Orders2 cat = (Orders2) sessionFactory.getCurrentSession().get(Orders2.class, id);
        return cat;
    }

    @Override
    public String deleteByCid(int cid) {
   String hql = "delete from orders2 where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;
    }

    @Override
    public List<Orders2> getByCid(int cid) {
   String hql = "from orders2 where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        List<Orders2> t = query.list();
        if (t != null) {
            return t;
        } else {
            return null;
        }

    }

}
