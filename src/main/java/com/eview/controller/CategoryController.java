
package com.eview.controller;

import com.eview.controller.impl.ICategoryController;
import com.eview.model.Category;
import com.eview.service.impl.ICategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller


@RequestMapping(value = "category")
public class CategoryController implements ICategoryController{
    @Autowired
    ICategoryService categoryService;
    
    

    @RequestMapping(value = "/updateView")
    public ModelAndView show() {
        return new ModelAndView("category/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("category/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
      Category t = categoryService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/category/create", "map", map);
       
    }

    @Override
        @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Category cat = categoryService.getById(id);
        cat.setId(id);
       return new ModelAndView("category/update", "cat", cat);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Category cat =  categoryService.update(request);
        return new ModelAndView("category/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
    Category cat = categoryService.delete(id);
       return new ModelAndView("redirect:/category/view");    
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
    Map<String, Object> map = new HashMap<String, Object>();
    List<Category> catList = categoryService.getAll();
    map.put("catList", catList);
    return new ModelAndView("category/view", "map", map);
    }

 
    
}
