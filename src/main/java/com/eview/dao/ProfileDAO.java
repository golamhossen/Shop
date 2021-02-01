
package com.eview.dao;

import com.eview.dao.impl.IProfileDAO;
import com.eview.model.Profile;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "profileDAO")
@Transactional
public class ProfileDAO implements IProfileDAO{
    
    @Autowired
    SessionFactory sessionFactory;

   @Override
    public Profile save(Profile t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Profile update(Profile t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Profile delete(int id) {
        Profile p = (Profile) sessionFactory.getCurrentSession().load(Profile.class, id);
        sessionFactory.getCurrentSession().delete(id);
        return p;
    }

    @Override
    public List<Profile> getAll() {
        List<Profile> pList = sessionFactory.getCurrentSession().createCriteria(Profile.class).list();
        return pList;
    }

    @Override
    public Profile getById(int id) {
        Profile p = (Profile) sessionFactory.getCurrentSession().get(Profile.class, id);
        return p;
    }

    
}
