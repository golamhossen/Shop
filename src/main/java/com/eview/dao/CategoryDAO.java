
package com.eview.dao;

import com.eview.dao.impl.ICategoryDAO;
import com.eview.model.Category;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "categoryDAO")
@Transactional
public class CategoryDAO implements ICategoryDAO{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Category save(Category t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Category update(Category t) {
    sessionFactory.getCurrentSession().saveOrUpdate(t);
    return t;
    }

    @Override
    public Category delete(int id) {
    Category cat = (Category) sessionFactory.getCurrentSession().load(Category.class, id);
    sessionFactory.getCurrentSession().delete(cat);
    return cat;    
    }

    @Override
    public List<Category> getAll() {
        List<Category> catList = sessionFactory.getCurrentSession().createCriteria(Category.class).list();
        return catList;
    }

    @Override
    public Category getById(int id) {
       Category cat = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
       return cat;
    }
    
}
