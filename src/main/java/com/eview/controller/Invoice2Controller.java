package com.eview.controller;

import com.eview.controller.impl.IInvoice2Controller;
import com.eview.model.Invoice2;
import com.eview.service.impl.IInvoice2Service;
import com.eview.service.impl.IOrders2Service;
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
@RequestMapping(value = "invoice2")
public class Invoice2Controller implements IInvoice2Controller {

    @Autowired
    IInvoice2Service invoice2Service;
    @Autowired
    IOrders2Service orders2Service;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("invoice2/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Invoice2> inList = invoice2Service.getAll();
        map.put("inList", inList);
        return new ModelAndView("invoice2/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Invoice2 m = invoice2Service.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("redirect:/cart2/view"); //To change body of generated methods, choose Tools | Templates.
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
        List<Invoice2> inList = invoice2Service.getAll();
        map.put("inList", inList);
        return new ModelAndView("invoice2/view", "map", map);
    }

}
