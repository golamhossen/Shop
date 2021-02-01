
package com.eview.dao;

import com.eview.dao.impl.ICartDAO;
import com.eview.model.Cart;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository(value = "cartDAO")
@Transactional
public class CartDAO implements ICartDAO{
    
    @Autowired
    SessionFactory sessionFactory;

   @Override
    public Cart save(Cart t) {
    sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Cart update(Cart t) {
   
    sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Cart delete(int id) {
   Cart cat = (Cart) sessionFactory.getCurrentSession().load(Cart.class, id);
        sessionFactory.getCurrentSession().delete(cat);
        return cat;
    }

    @Override
    public List<Cart> getAll() {
    List<Cart> brandList = sessionFactory.getCurrentSession().createCriteria(Cart.class).list();
        return brandList;
    }

    @Override
    public Cart getById(int id) {
   Cart cat = (Cart) sessionFactory.getCurrentSession().get(Cart.class, id);
        return cat;
    }

    @Override
    public long getCartCount() {
        String hql = "select count(*) from cart";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        long count = (long) q.uniqueResult();
        return count;
    }

   
    @Override
    public Cart getByProductCode(String pCode) {
   String hql = "from cart where pCode = :pCode";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pCode", pCode);
        Cart c = (Cart) query.uniqueResult();
        if(c != null){
            return c;
        } else {
            return null;
        }
    }

    @Override
    public String deleteByCid(int cid) {
   
      String hql = "delete from cart where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        int res = query.executeUpdate();
        sessionFactory.getCurrentSession().flush();
        return hql;
    }

    @Override
    public List<Cart> getByCid(int cid) {
   
    String hql = "from cart where cid= :cid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("cid", cid);
        List<Cart> t = query.list();
        if (t != null) {
            return t;
        } else {
            return null;
        }
    }


}
