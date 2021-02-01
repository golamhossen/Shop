package com.eview.dao;

import com.eview.dao.impl.ICart2DAO;
import com.eview.model.Cart2;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "cart2DAO")
@Transactional
public class Cart2DAO implements ICart2DAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Cart2 save(Cart2 t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Cart2 update(Cart2 t) {

        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Cart2 delete(int id) {
        Cart2 cat = (Cart2) sessionFactory.getCurrentSession().load(Cart2.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Cart2> getAll() {
        List<Cart2> brandList = sessionFactory.getCurrentSession().createCriteria(Cart2.class).list();
        return brandList;
    }

    @Override
    public Cart2 getById(int id) {
        Cart2 cat = (Cart2) sessionFactory.getCurrentSession().get(Cart2.class, id);
        return cat;
    }

    @Override
    public long getCart2Count() {
        String hql = "select count(*) from cart2";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        long count = (long) q.uniqueResult();
        return count;
    }

    @Override
    public Cart2 getByGoodsCode(String pCode) {
   
    String hql = "from cart2 where pCode = :pCode";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pCode", pCode);
        Cart2 c = (Cart2) query.uniqueResult();
        if(c != null){
            return c;
        } else {
            return null;
        }
    }

    @Override
    public String deleteByCid(int cid) {
    String hql = "delete from cart2 where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;
    }

    @Override
    public List<Cart2> getByCid(int cid) {
    String hql = "from cart2 where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        List<Cart2> t = query.list();
        if (t != null) {
            return t;
        } else {
            return null;
        }
    }

}
