package com.eview.dao;

import com.eview.dao.impl.ITempProductDAO;
import com.eview.model.TempProduct;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "tempProductDAO")
@Transactional
public class TempProductDAO implements ITempProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public TempProduct save(TempProduct t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public TempProduct update(TempProduct t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public TempProduct delete(int id) {
        TempProduct in = (TempProduct) sessionFactory.getCurrentSession().load(TempProduct.class, id);
        sessionFactory.getCurrentSession().delete(in);
        return in;
    }

    @Override
    public List<TempProduct> getAll() {
        List<TempProduct> inList = sessionFactory.getCurrentSession().createCriteria(TempProduct.class).list();
        return inList;
    }

    @Override
    public TempProduct getById(int id) {
        TempProduct in = (TempProduct) sessionFactory.getCurrentSession().get(TempProduct.class, id);
        return in;
    }

    @Override
    public String deleteByCid(int cid) {
        String hql = "delete from tempProduct where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;
    }

    @Override
    public List<TempProduct> getByCid(int cid) {
        String hql = "from tempProduct where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        List<TempProduct> t = query.list();
        if (t != null) {
            return t;
        } else {
            return null;
        }

    }

}
