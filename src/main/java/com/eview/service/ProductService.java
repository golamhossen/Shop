package com.eview.service;

import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.IProductDAO;
import com.eview.model.Category;
import com.eview.model.Product;
import com.eview.service.impl.IProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "productService")
public class ProductService implements IProductService {

    @Autowired
    IProductDAO productDAO;

    @Autowired
    ICategoryDAO categoryDAO;

    @Override
    public Product save(HttpServletRequest request) {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int id = Integer.parseInt(request.getParameter("cid"));
        String brand = request.getParameter("brand");
        String size = request.getParameter("size");
        String color = request.getParameter("color");
        String desc = request.getParameter("desc");
        double price = Double.parseDouble(request.getParameter("price"));
        Category c = categoryDAO.getById(id);
        Product p = new Product();

        p.setName(name);
        p.setCode(code);
        p.setCid(c.getId());
        p.setCname(c.getName());
        p.setBrand(brand);
        p.setSize(size);
        p.setColor(color);
        p.setDesc(desc);
        p.setPrice(price);

        return productDAO.save(p);

    }

    @Override
    public Product update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
