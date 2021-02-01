/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service;

import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.ISubCategoryDAO;
import com.eview.model.Category;
import com.eview.model.SubCategory;
import com.eview.service.impl.ISubCategoryService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service(value = "subCategoryService")
public class SubCategoryService implements ISubCategoryService {

    @Autowired
    ISubCategoryDAO subCategoryDAO;

    @Autowired
    ICategoryDAO categoryDAO;

    @Override
    public SubCategory save(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("cid"));
        String name = request.getParameter("name");
        Category c = categoryDAO.getById(id);
        SubCategory t = new SubCategory();
        t.setCid(c.getId());
        t.setCname(c.getName());
        t.setName(name);

        return subCategoryDAO.save(t);
    }

    @Override
    public SubCategory update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        SubCategory t = new SubCategory();
        t.setId(Integer.parseInt(map.get("id")[0]));
        t.setName(map.get("name")[0]);
        return subCategoryDAO.update(t);
    }

    @Override
    public SubCategory delete(int id) {
        return subCategoryDAO.delete(id);
    }

    @Override
    public List<SubCategory> getAll() {
        return subCategoryDAO.getAll();
    }

    @Override
    public SubCategory getById(int id) {
        return subCategoryDAO.getById(id);
    }

}
