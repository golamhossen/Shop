
package com.eview.controller;

import com.eview.controller.impl.IPurchase2Controller;
import com.eview.model.Category;
import com.eview.model.Goods;
import com.eview.model.Purchase2;
import com.eview.service.impl.ICategoryService;
import com.eview.service.impl.IGoodsService;
import com.eview.service.impl.IPurchase2Service;
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
@RequestMapping(value = "purchase2")
public class Purchase2Controller implements IPurchase2Controller{
    @Autowired
    IPurchase2Service purchase2Service;

    @Autowired
    IGoodsService goodsService;

    @Autowired
    ICategoryService categoryService;

     @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("purchase2/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> pList = goodsService.getAll();
        List<Category> cList = categoryService.getAll();
        map.put("pList", pList);
        map.put("cList", cList);
        return new ModelAndView("purchase2/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Purchase2 m = purchase2Service.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("/purchase2/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Goods g = goodsService.getById(id);
        return new ModelAndView("/purchase2/create", "g", g);
    }

    @Override
    @RequestMapping(value = "/update")
    public ModelAndView update(HttpServletRequest request) {
        return new ModelAndView("purchase2/update");
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Purchase2> pList = purchase2Service.getAll();
        double totalGrandTotal = purchase2Service.getTotalPurchasePrice();
        int totalQty = purchase2Service.getTotalQty();
        double total = purchase2Service.getTotal();
        map.put("pList", pList);
        map.put("totalGrandTotal", totalGrandTotal);
        map.put("totalQty", totalQty);
        map.put("total", total);
        return new ModelAndView("purchase2/view", "map", map);
    }

    
}
