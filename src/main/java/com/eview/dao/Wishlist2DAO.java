
package com.eview.dao;

import com.eview.dao.impl.IWishlist2DAO;
import com.eview.model.Wishlist2;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "wishlist2DAO")
@Transactional
public class Wishlist2DAO implements IWishlist2DAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Wishlist2 save(Wishlist2 t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Wishlist2 update(Wishlist2 t) {

        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Wishlist2 delete(int id) {
        Wishlist2 cat = (Wishlist2) sessionFactory.getCurrentSession().load(Wishlist2.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Wishlist2> getAll() {
        List<Wishlist2> brandList = sessionFactory.getCurrentSession().createCriteria(Wishlist2.class).list();
        return brandList;
    }

    @Override
    public Wishlist2 getById(int id) {
        Wishlist2 cat = (Wishlist2) sessionFactory.getCurrentSession().get(Wishlist2.class, id);
        return cat;
    }

    @Override
    public long getWishlist2Count() {
        String hql = "select count(*) from wishlist2";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        long wishCount = (long) q.uniqueResult();
        return wishCount;
    }

    @Override
    public Wishlist2 getByProductCode(String pCode) {
        String hql = "from wishlist2 where pCode = :pCode";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pCode", pCode);
        Wishlist2 c = (Wishlist2) query.uniqueResult();
        if (c != null) {
            return c;
        } else {
            return null;
        }
    }

    @Override
    public String deleteByCid(int cid) {

        String hql = "delete from wishlist2 where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;
    }

    @Override
    public List<Wishlist2> getByCid(int cid) {

        String hql = "from wishlist2 where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        List<Wishlist2> t = query.list();
        if (t != null) {
            return t;
        } else {
            return null;
        }
    }

}
