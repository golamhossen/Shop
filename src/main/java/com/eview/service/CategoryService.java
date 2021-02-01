
package com.eview.service;


import com.eview.dao.impl.ICategoryDAO;
import com.eview.model.Category;
import com.eview.service.impl.ICategoryService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "categoryService")
public class CategoryService implements ICategoryService{
    
    @Autowired
    ICategoryDAO categoryDAO;

    @Override
    public Category save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Category t = new Category();
         t.setName(map.get("name")[0]);
         return categoryDAO.save(t);
    }

    @Override
    public Category update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Category t = new Category();
        t.setId(Integer.parseInt(map.get("id")[0]));
         t.setName(map.get("name")[0]);
         return categoryDAO.update(t);
    }

    @Override
    public Category delete(int id) {
     return categoryDAO.delete(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

    @Override
    public Category getById(int id) {
     return categoryDAO.getById(id);
    }
    
}
