/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.controller;

import com.eview.controller.impl.ISizeController;
import com.eview.model.Size;
import com.eview.service.impl.ISizeService;
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
@RequestMapping(value = "size")
public class SizeController implements ISizeController{
    
    @Autowired
    ISizeService sizeService;

   @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("size/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {

        Size t = sizeService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/size/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Size cat = sizeService.getById(id);
        cat.setId(id);
        return new ModelAndView("size/update", "cat", cat);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Size cat = sizeService.update(request);
        return new ModelAndView("size/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Size cat = sizeService.delete(id);
        return new ModelAndView("redirect:/size/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Size> banList = sizeService.getAll();
        map.put("banList", banList);
        return new ModelAndView("size/view", "map", map);
    }
    
    
}
