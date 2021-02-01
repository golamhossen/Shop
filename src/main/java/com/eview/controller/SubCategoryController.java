/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.controller;

import com.eview.controller.impl.ISubCategoryController;
import com.eview.model.Category;
import com.eview.model.SubCategory;
import com.eview.service.impl.ICategoryService;
import com.eview.service.impl.ISubCategoryService;
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
@RequestMapping(value = "subCategory")
public class SubCategoryController implements ISubCategoryController {

    @Autowired
    ISubCategoryService subCategoryService;
    
    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("subCategory/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Category> cList = categoryService.getAll();
        map.put("cList", cList);
        return new ModelAndView("subCategory/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        SubCategory t = subCategoryService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/subCategory/create", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        SubCategory c = subCategoryService.getById(id);
        c.setId(id);
        return new ModelAndView("subCategory/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        SubCategory c = subCategoryService.update(request);
        return new ModelAndView("subCategory/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        SubCategory c = subCategoryService.delete(id);
        return new ModelAndView("redirect:/subCategory/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SubCategory> cList = subCategoryService.getAll();
        map.put("cList", cList);
        return new ModelAndView("subCategory/create", "map", map);
    }

}
