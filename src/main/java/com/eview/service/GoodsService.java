/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service;

import com.eview.dao.impl.IBrandDAO;
import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.IGoodsDAO;
import com.eview.model.Brand;
import com.eview.model.Category;
import com.eview.model.Goods;
import com.eview.service.impl.IGoodsService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "goodsService")
public class GoodsService implements IGoodsService {
    
    @Autowired
    IGoodsDAO goodsDAO;
    
    @Autowired
    ICategoryDAO categoryDAO;
    
    @Autowired
    IBrandDAO brandDAO;
    
    
  
    
    @Override
    public Goods save(HttpServletRequest request) {
//        Map<String, String[]> map = request.getParameterMap();

        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int cid = Integer.parseInt(request.getParameter("cid"));
        int bid = Integer.parseInt(request.getParameter("bid"));        
        String sp = request.getParameter("sp");        
        String desc = request.getParameter("desc");        
        double price = Double.parseDouble(request.getParameter("price"));
        String photo = request.getParameter("photo");  
        double discount = Integer.getInteger("discount");
        
        Category c = categoryDAO.getById(cid);
        Brand b = brandDAO.getById(bid);
        Goods t = new Goods();
        t.setName(name);
        t.setCode(code);
        t.setCid(c.getId());
        t.setCname(c.getName());
        t.setBid(b.getId());
        t.setBname(b.getName());
        t.setSp(sp);
        t.setDes(desc);
        t.setPrice(price);
        t.setPhoto(photo);
        t.setDiscount(bid);
//        t.setPhoto(map.get("photo")[0]);
        return goodsDAO.save(t);
    }
    
    @Override
    public Goods update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Goods t = new Goods();
        t.setId(Integer.parseInt(map.get("id")[0]));
        t.setName(map.get("name")[0]);
        t.setCode(map.get("code")[0]);
        t.setCid(Integer.parseInt(map.get("cid")[0]));
        t.setCname(map.get("cname")[0]);
//        t.setBrand(map.get("brand")[0]);
//        t.setSize(map.get("size")[0]);
//        t.setColor(map.get("color")[0]);
        t.setDes(map.get("desc")[0]);
        t.setPrice(Double.parseDouble(map.get("price")[0]));
//        t.setPhoto(map.get("photo")[0]);

        return goodsDAO.update(t);
    }
    
    @Override
    public Goods delete(int id) {
        return goodsDAO.delete(id);
    }
    
    @Override
    public List<Goods> getAll() {
        return goodsDAO.getAll();
    }
    
    @Override
    public Goods getById(int id) {
        return goodsDAO.getById(id);
    }
}
