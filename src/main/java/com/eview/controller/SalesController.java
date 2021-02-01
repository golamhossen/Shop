package com.eview.controller;

import com.eview.controller.impl.ISalesController;
import com.eview.model.Invoice;
import com.eview.model.Orders;
import com.eview.model.Production;
import com.eview.model.Sales;
import com.eview.service.impl.IInvoice1Service;
import com.eview.service.impl.IInvoiceService;
import com.eview.service.impl.IOrdersService;
import com.eview.service.impl.IProductionService;
import com.eview.service.impl.ISalesService;
import com.eview.service.impl.IStockService;
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
@RequestMapping(value = "sales")
public class SalesController implements ISalesController {

    @Autowired
    ISalesService salesService;

    @Autowired
    IProductionService productionService;
    @Autowired
    IInvoice1Service invoice1Service;
    @Autowired
    IStockService stockService;

    @Autowired
    IInvoiceService invoiceService;

    @Autowired
    IOrdersService ordersService;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("sales/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Production> pList = productionService.getAll();
        List<Orders> oList = ordersService.getAll();
        map.put("oList", oList);
        map.put("pList", pList);
        return new ModelAndView("sales/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Sales m = salesService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("/sales/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView edit(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/update")
    public ModelAndView update(HttpServletRequest request) {
        return new ModelAndView("sales/update");
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sales> pList = salesService.getAll();
        double totalPrice = salesService.getTotalPrice();
        int totalQty = salesService.getTotalQty();
        map.put("totalPrice", totalPrice);
        map.put("totalQty", totalQty);
        map.put("pList", pList);
        return new ModelAndView("sales/view", "map", map);
    }
    
    
     @RequestMapping(value = "/view1", method = RequestMethod.GET)
    public ModelAndView getAll1() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sales> pList = salesService.getAll();
        double totalPrice = salesService.getTotalPrice();
        int totalQty = salesService.getTotalQty();
        map.put("totalPrice", totalPrice);
        map.put("totalQty", totalQty);
        map.put("pList", pList);
        return new ModelAndView("sales/view1", "map", map);
    }
 @RequestMapping(value = "/view2", method = RequestMethod.GET)
    public ModelAndView getAll2() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sales> pList = salesService.getAll();
        double totalPrice = salesService.getTotalPrice();
        int totalQty = salesService.getTotalQty();
        map.put("totalPrice", totalPrice);
        map.put("totalQty", totalQty);
        map.put("pList", pList);
        return new ModelAndView("sales/view2", "map", map);
    }
     @RequestMapping(value = "/view3", method = RequestMethod.GET)
    public ModelAndView getAll3() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sales> pList = salesService.getAll();
        double totalPrice = salesService.getTotalPrice();
        int totalQty = salesService.getTotalQty();
        map.put("totalPrice", totalPrice);
        map.put("totalQty", totalQty);
        map.put("pList", pList);
        return new ModelAndView("sales/view3", "map", map);
    }
    
    @RequestMapping(value = "/delivered", method = RequestMethod.POST)
    public ModelAndView Delivered(HttpServletRequest request) {
        int orderNo = Integer.parseInt(request.getParameter("orderNo"));
        salesService.save(request);
        invoice1Service.save(request);
        stockService.save(request);

        invoiceService.deleteByOrderNo(orderNo);
        ordersService.deleteByOrderNo(orderNo);
        return new ModelAndView("orders/details"); //To change body of generated methods, choose Tools | Templates.
    }

    //Getting Confirmation page to confirm ordered Delivered
    @RequestMapping(value = "/confirm/{orderNo}", method = RequestMethod.GET)
    public ModelAndView confirm(ModelMap map, @PathVariable("orderNo") int orderNo) {
        Invoice invoice = invoiceService.getByOrderNo(orderNo);
        List<Orders> oList = ordersService.getByOrderNo(orderNo);
        map.addAttribute("invoice", invoice);
        return new ModelAndView("sales/confirm", "oList", oList);
    }

}
