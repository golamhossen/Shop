package com.eview.controller;

import com.eview.controller.impl.IProductController;
import com.eview.model.Category;
import com.eview.model.Product;
import com.eview.service.impl.ICategoryService;
import com.eview.service.impl.IProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "product")
public class ProductController implements IProductController {

    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("product/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Category> cList = categoryService.getAll();
        map.put("cList", cList);
        return new ModelAndView("product/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Product p = productService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("p", p);
        return new ModelAndView("/product/create", "map", map);
    }

    @Override
    public ModelAndView edit(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
