package com.eview.controller;

import com.eview.controller.impl.IStockController;
import com.eview.model.Production;
import com.eview.model.Stock;
import com.eview.service.impl.IProductionService;
import com.eview.service.impl.IStockService;
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
@RequestMapping(value = "stock")
public class StockController implements IStockController {

    @Autowired
    IStockService stockService;

    @Autowired
    IProductionService productionService;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("stock/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Production> pList = productionService.getAll();
        map.put("pList", pList);
        return new ModelAndView("stock/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Stock m = stockService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("/stock/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView edit(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/update")
    public ModelAndView update(HttpServletRequest request) {
        return new ModelAndView("stock/update");
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Stock> sList = stockService.getAll();
        double profit = stockService.getTotalProfit();
        double totalPrice = stockService.getTotalPurchasePrice();
        double totalSalesPrice = stockService.getTotalSalesPrice();
        int totalQty = stockService.getTotalQty();
        map.put("sList", sList);
        map.put("profit", profit);
        map.put("totalPrice", totalPrice);
        map.put("totalSalesPrice", totalSalesPrice);
        map.put("totalQty", totalQty);
        return new ModelAndView("stock/view", "map", map);
    }
    
     @RequestMapping(value = "/view1", method = RequestMethod.GET)
    public ModelAndView getAll1() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Stock> sList = stockService.getAll();
        double profit = stockService.getTotalProfit();
        double totalPrice = stockService.getTotalPurchasePrice();
        double totalSalesPrice = stockService.getTotalSalesPrice();
        int totalQty = stockService.getTotalQty();
        map.put("sList", sList);
        map.put("profit", profit);
        map.put("totalPrice", totalPrice);
        map.put("totalSalesPrice", totalSalesPrice);
        map.put("totalQty", totalQty);
        return new ModelAndView("stock/view1", "map", map);
    }

}
