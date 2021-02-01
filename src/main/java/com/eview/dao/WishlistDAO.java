package com.eview.dao;

import com.eview.dao.impl.IWishlistDAO;
import com.eview.model.Wishlist;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "wishlistDAO")
@Transactional
public class WishlistDAO implements IWishlistDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Wishlist save(Wishlist t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Wishlist update(Wishlist t) {

        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Wishlist delete(int id) {
        Wishlist cat = (Wishlist) sessionFactory.getCurrentSession().load(Wishlist.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Wishlist> getAll() {
        List<Wishlist> brandList = sessionFactory.getCurrentSession().createCriteria(Wishlist.class).list();
        return brandList;
    }

    @Override
    public Wishlist getById(int id) {
        Wishlist cat = (Wishlist) sessionFactory.getCurrentSession().get(Wishlist.class, id);
        return cat;
    }

    @Override
    public long getWishlistCount() {
        String hql = "select count(*) from wishlist";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        long wishCount = (long) q.uniqueResult();
        return wishCount;
    }

    @Override
    public Wishlist getByProductCode(String pCode) {
        String hql = "from wishlist where pCode = :pCode";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pCode", pCode);
        Wishlist c = (Wishlist) query.uniqueResult();
        if (c != null) {
            return c;
        } else {
            return null;
        }
    }

    @Override
    public String deleteByCid(int cid) {

        String hql = "delete from wishlist where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;
    }

    @Override
    public List<Wishlist> getByCid(int cid) {

        String hql = "from wishlist where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        List<Wishlist> t = query.list();
        if (t != null) {
            return t;
        } else {
            return null;
        }
    }

}
