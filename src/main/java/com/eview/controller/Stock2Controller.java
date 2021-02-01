package com.eview.controller;

import com.eview.controller.impl.IStock2Controller;
import com.eview.model.Goods;
import com.eview.model.Stock2;
import com.eview.service.impl.IGoodsService;
import com.eview.service.impl.IStock2Service;
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
@RequestMapping(value = "stock2")
public class Stock2Controller implements IStock2Controller {

    @Autowired
    IStock2Service stock2Service;

    @Autowired
    IGoodsService goodsService;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("stock2/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> pList = goodsService.getAll();
        map.put("pList", pList);
        return new ModelAndView("stock2/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Stock2 m = stock2Service.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("/stock2/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView edit(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/update")
    public ModelAndView update(HttpServletRequest request) {
        return new ModelAndView("stock2/update");
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Stock2> s2List = stock2Service.getAll();
        double profit = stock2Service.getTotalProfit();
        double totalPrice = stock2Service.getTotalPurchasePrice();
        double totalSalesPrice = stock2Service.getTotalSalesPrice();
        int totalQty = stock2Service.getTotalQty();
        map.put("s2List", s2List);
        map.put("profit", profit);
        map.put("totalPrice", totalPrice);
        map.put("totalSalesPrice", totalSalesPrice);
        map.put("totalQty", totalQty);
        return new ModelAndView("stock2/view", "map", map);
    }

}
