/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.controller;

import com.eview.controller.impl.IBrandController;
import com.eview.model.Brand;
import com.eview.service.impl.IBrandService;
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

@Controller
@RequestMapping(value = "brand")
public class BrandController implements IBrandController {

    @Autowired
    IBrandService brandService;

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("brand/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {

        Brand t = brandService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/brand/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Brand cat = brandService.getById(id);
        cat.setId(id);
        return new ModelAndView("brand/update", "cat", cat);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Brand cat = brandService.update(request);
        return new ModelAndView("brand/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Brand cat = brandService.delete(id);
        return new ModelAndView("redirect:/brand/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Brand> brandList = brandService.getAll();
        map.put("brandList", brandList);
        return new ModelAndView("brand/view", "map", map);
    }

}
