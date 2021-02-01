
package com.eview.dao;

import com.eview.dao.impl.IInvoiceDAO;
import com.eview.model.Invoice;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "invoiceDAO")
@Transactional
public class InvoiceDAO implements IInvoiceDAO{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Invoice save(Invoice t) {
        sessionFactory.getCurrentSession().save(t);
        return t;
    }

    @Override
    public Invoice update(Invoice t) {
        sessionFactory.getCurrentSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public Invoice delete(int id) {
    Invoice in = (Invoice) sessionFactory.getCurrentSession().load(Invoice.class, id);
    sessionFactory.getCurrentSession().delete(in);
    return in;      
    }

    @Override
    public List<Invoice> getAll() {
    List<Invoice> inList = sessionFactory.getCurrentSession().createCriteria(Invoice.class).list();
        return inList;    
    }

    @Override
    public Invoice getById(int id) {
    Invoice in = (Invoice) sessionFactory.getCurrentSession().get(Invoice.class, id);
       return in;    
    }

    @Override
    public Invoice getByOrderNo(int orderNo) {
       String hql = "from invoice where orderNo = :orderNo";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("orderNo", orderNo);
        Invoice invoice = (Invoice) query.uniqueResult();
        if(invoice != null){
            return invoice;
        } else {
            return null;
        }    
    }

    @Override
    public String deleteByOrderNo(int orderNo) {
         String hql = "delete from invoice where orderNo= :orderNo";
          Query query = sessionFactory.getCurrentSession().createQuery(hql);
          query.setInteger("orderNo", orderNo);
          int res = query.executeUpdate();
          sessionFactory.getCurrentSession().flush();
     return hql; 
    }

    @Override
    public long getCount() {
        String hql = "select count(*) from invoice";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        long count = (long) q.uniqueResult();
        return count;
    }
   
}
