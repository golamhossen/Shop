package com.eview.dao;

import com.eview.dao.impl.IOrdersDAO;
import com.eview.model.Orders;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "ordersDAO")
@Transactional
public class OrdersDAO implements IOrdersDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Orders save(Orders t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Orders update(Orders t) {

        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Orders delete(int id) {
        Orders cat = (Orders) sessionFactory.getCurrentSession().load(Orders.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Orders> getAll() {
        List<Orders> brandList = sessionFactory.getCurrentSession().createCriteria(Orders.class).list();
        return brandList;
    }

    @Override
    public Orders getById(int id) {
        Orders cat = (Orders) sessionFactory.getCurrentSession().get(Orders.class, id);
        return cat;
    }

    @Override
    public String deleteByCid(int cid) {

        String hql = "delete from orders where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;
    }

    @Override
    public List<Orders> getByCid(int cid) {

        String hql = "from orders where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        List<Orders> t = query.list();
        if (t != null) {
            return t;
        } else {
            return null;
        }

    }

    @Override
    public List<Orders> getByOrderNo(int orderNo) {
        String hql = "from orders where orderNo = :orderNo";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("orderNo", orderNo);
        List<Orders> oList = query.list();
        for (int i = 0; i < oList.size(); i++) {
            Orders s = new Orders();
            s.setpPrice(oList.get(i).getpPrice());
// salesDA
        }

        return oList;
    }

    @Override
    public String deleteByOrderNo(int orderNo) {
        String hql = "delete from orders where orderNo= :orderNo";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("orderNo", orderNo);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;

    }
}
