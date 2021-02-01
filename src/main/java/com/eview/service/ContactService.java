package com.eview.service;

import com.eview.dao.impl.IContactDAO;
import com.eview.model.Contact;
import com.eview.service.impl.IContactService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "contactService")
public class ContactService implements IContactService {

    @Autowired
    IContactDAO contactDAO;

    @Override
    public Contact save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Contact c = new Contact();
        c.setName(map.get("name")[0]);
        c.setEmail(map.get("email")[0]);
        c.setSubject(map.get("subject")[0]);
        c.setMessage(map.get("message")[0]);

        return contactDAO.save(c);
    }

    @Override
    public Contact update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Contact t = new Contact();
        t.setId(Integer.parseInt(map.get("id")[0]));
        t.setName(map.get("name")[0]);
        return contactDAO.update(t);
    }

    @Override
    public Contact delete(int id) {
        return contactDAO.delete(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactDAO.getAll();
    }

    @Override
    public Contact getById(int id) {
        return contactDAO.getById(id);
    }

}
