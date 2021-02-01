/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.controller;

import com.eview.controller.impl.ICityController;
import com.eview.model.City;
import com.eview.model.Country;
import com.eview.service.CountryService;
import com.eview.service.impl.ICityService;
import com.eview.service.impl.ICountryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "city")
public class CityController implements ICityController{
    
    @Autowired
    ICityService cityService;
    @Autowired
    ICountryService countryService;

    
    


     @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("city/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() { 
        Map<String, Object> map = new HashMap<String, Object>();
        List<Country> cList = countryService.getAll();
        map.put("cList", cList);
        return new ModelAndView("city/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
      City t = cityService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/city/create", "map", map);
       
    }

    @Override
        @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        City c = cityService.getById(id);
        c.setId(id);
       return new ModelAndView("city/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        City c =  cityService.update(request);
        return new ModelAndView("city/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
    City c = cityService.delete(id);
       return new ModelAndView("redirect:/city/view");    
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<City> cList = cityService.getAll();
    map.put("cList", cList);
    return new ModelAndView("city/view", "map", map);
    }


 
}
