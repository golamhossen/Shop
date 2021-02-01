package com.eview.service;

import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.IProductionDAO;
import com.eview.model.Category;
import com.eview.model.Production;
import com.eview.service.impl.IProductionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "productionService")
public class ProductionService implements IProductionService {
    
    @Autowired
    IProductionDAO productionDAO;
    
    @Autowired
    ICategoryDAO categoryDAO;
    
    @Override
    public Production save(HttpServletRequest request) {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int id = Integer.parseInt(request.getParameter("cid"));
        String sp = request.getParameter("sp");
        String des = request.getParameter("des");
        double price = Double.parseDouble(request.getParameter("price"));
                int discount = Integer.parseInt(request.getParameter("discount"));

        
        Category c = categoryDAO.getById(id);
        Production p = new Production();
        p.setName(name);
        p.setCode(code);
        p.setCid(c.getId());
        p.setCname(c.getName());
        p.setSp(sp);
        p.setDes(des);
        p.setPrice(price);
        p.setDiscount(discount);
        
        return productionDAO.save(p);
    }
    
    @Override
    public Production update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Production delete(int id) {
        return productionDAO.delete(id);
    }
    
    @Override
    public List<Production> getAll() {
        return productionDAO.getAll();
    }
    
    @Override
    public Production getById(int id) {
        return productionDAO.getById(id);
    }
    
}
