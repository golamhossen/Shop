/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service;


import com.eview.dao.impl.ICityDAO;
import com.eview.dao.impl.ICountryDAO;
import com.eview.model.City;
import com.eview.model.Country;
import com.eview.service.impl.ICityService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service(value = "cityService")
public class CityService implements ICityService{
    
@Autowired
ICityDAO cityDAO;

@Autowired
ICountryDAO countryDAO;

    @Override
    public City save(HttpServletRequest request) {
      int id = Integer.parseInt(request.getParameter("cid"));
      String name = request.getParameter("name");
      Country c = countryDAO.getById(id);
        City t = new City();
        t.setCid(c.getId());
         t.setCname(c.getName());
         t.setName(name);
         
         return cityDAO.save(t);    
    }

    @Override
    public City update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        City t = new City();
        t.setId(Integer.parseInt(map.get("id")[0]));
         t.setName(map.get("name")[0]);
         return cityDAO.update(t); }

    @Override
    public City delete(int id) {
       return cityDAO.delete(id);
    }

    @Override
    public List<City> getAll() {
        return cityDAO.getAll();
       }

    @Override
    public City getById(int id) {
     return cityDAO.getById(id);   
    }

   
}
