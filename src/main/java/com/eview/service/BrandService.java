/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service;

import com.eview.dao.impl.IBrandDAO;
import com.eview.model.Brand;
import com.eview.service.impl.IBrandService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B12
 */
@Service(value = "brandService")
public class BrandService implements IBrandService{
    
    @Autowired
    IBrandDAO brandDAO;

    @Override
    public Brand save(HttpServletRequest request) {
         Map<String, String[]> map = request.getParameterMap();
        Brand t = new Brand();
        t.setName(map.get("name")[0]);
        return brandDAO.save(t);
    }

    @Override
    public Brand update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Brand t = new Brand();
        t.setId(Integer.parseInt(map.get("id")[0]));
        t.setName(map.get("name")[0]);
        return brandDAO.update(t);
    }

    @Override
    public Brand delete(int id) {
       return brandDAO.delete(id);
    }

    @Override
    public List<Brand> getAll() {
         return brandDAO.getAll();
    }

    @Override
    public Brand getById(int id) {
        return brandDAO.getById(id);
    }
    
    
}
