/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service;

import com.eview.dao.CategoryDAO;
import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.IMarchentDAO;
import com.eview.model.Category;
import com.eview.model.Marchent;
import com.eview.service.impl.IMarchentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service(value = "marchentService")
public class MarchentService implements IMarchentService {

    @Autowired
    IMarchentDAO marchentDAO;

    @Autowired
    ICategoryDAO categoryDAO;

    @Override
    public Marchent save(HttpServletRequest request) {
        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("cid"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Category c = categoryDAO.getById(id);
        Marchent m = new Marchent();

        m.setName(name);
        m.setCid(c.getId());
        m.setCname(c.getName());
        m.setAddress(address);
        m.setEmail(email);
        m.setPassword(password);
        return marchentDAO.save(m);

    }

    @Override
    public Marchent update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marchent delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Marchent> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marchent getById(int id) {
        return marchentDAO.getById(id);
    }

}
