
package com.eview.service;

import com.eview.dao.impl.ICountryDAO;
import com.eview.dao.impl.IProfileDAO;
import com.eview.model.Profile;
import com.eview.service.impl.IProfileService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "profileService")
public class ProfileService implements IProfileService{
    
    @Autowired
    IProfileDAO profileDAO;
    
    @Autowired
    ICountryDAO countryDAO;

   @Override
    public Profile save(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String code = request.getParameter("code");
//        int id = Integer.parseInt(request.getParameter("cid"));
//        String sp = request.getParameter("sp");
//        String des = request.getParameter("des");
//        double price = Double.parseDouble(request.getParameter("price"));
        
//        Category c = categoryDAO.getById(id);
        Profile p = new Profile();
//        p.setName(name);
//        p.setCode(code);
//        p.setCid(c.getId());
//        p.setCname(c.getName());
//        p.setSp(sp);
//        p.setDes(des);
//        p.setPrice(price);
        
        return profileDAO.save(p);
    }
    
    @Override
    public Profile update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Profile delete(int id) {
        return profileDAO.delete(id);
    }
    
    @Override
    public List<Profile> getAll() {
        return profileDAO.getAll();
    }
    
    @Override
    public Profile getById(int id) {
        return profileDAO.getById(id);
    }
}
