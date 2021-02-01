package com.eview.controller;

import com.eview.controller.impl.IInvoiceController;
import com.eview.model.Invoice;
import com.eview.model.Orders;
import com.eview.service.impl.IInvoiceService;
import com.eview.service.impl.IOrdersService;
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
@RequestMapping(value = "invoice")
public class InvoiceController implements IInvoiceController {

    @Autowired
    IInvoiceService invoiceService;
    @Autowired
    IOrdersService ordersService;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("invoice/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Invoice> inList = invoiceService.getAll();
        map.put("inList", inList);
        return new ModelAndView("invoice/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Invoice m = invoiceService.save(request);
//        Orders o = ordersService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("redirect:/cart/view"); //To change body of generated methods, choose Tools | Templates.
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
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Invoice> inList = invoiceService.getAll();
        map.put("inList", inList);
        return new ModelAndView("invoice/view", "map", map);
    }

    
}
