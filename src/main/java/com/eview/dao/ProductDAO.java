
package com.eview.dao;

import com.eview.dao.impl.IProductDAO;
import com.eview.model.Product;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "productDAO")
@Transactional
public class ProductDAO implements IProductDAO{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Product save(Product t) {
    sessionFactory.getCurrentSession().save(t);
    return t;
    }

    @Override
    public Product update(Product t) {
   sessionFactory.getCurrentSession().saveOrUpdate(t);
   return t;
    }

    @Override
    public Product delete(int id) {
   Product p = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
   sessionFactory.getCurrentSession().delete(p);
   return p;
    }

    @Override
    public List<Product> getAll() {
   
    List<Product> pList = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    return pList;
    }

    @Override
    public Product getById(int id) {
    Product p = (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    return p;
    
    }
    
    
}
