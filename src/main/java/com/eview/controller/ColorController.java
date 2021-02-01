/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.controller;

import com.eview.controller.impl.IColorController;
import com.eview.model.Color;
import com.eview.service.impl.IColorService;
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
@RequestMapping(value = "color")
public class ColorController implements IColorController{
    
    @Autowired
    IColorService colorService;

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("color/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {

        Color t = colorService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/color/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Color cat = colorService.getById(id);
        cat.setId(id);
        return new ModelAndView("color/update", "cat", cat);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Color cat = colorService.update(request);
        return new ModelAndView("color/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Color cat = colorService.delete(id);
        return new ModelAndView("redirect:/color/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Color> banList = colorService.getAll();
        map.put("banList", banList);
        return new ModelAndView("color/view", "map", map);
    }
    
}
