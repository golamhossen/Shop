package com.eview.controller;

import com.eview.controller.impl.IOrders2Controller;
import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.IWishlist2DAO;
import com.eview.model.Cart2;
import com.eview.model.Invoice2;
import com.eview.model.Orders2;
import com.eview.service.impl.ICart2Service;
import com.eview.service.impl.IInvoice2Service;
import com.eview.service.impl.IOrders2Service;
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
@RequestMapping(value = "orders2")
public class Orders2Controller implements IOrders2Controller {

    @Autowired
    IOrders2Service orders2Service;

    @Autowired
    ICart2Service cart2Service;

    @Autowired
    IInvoice2Service invoice2Service;

    @Autowired
    IStock2Service stock2Service;

    @Autowired
    ICart2DAO cart2DAO;

    @Autowired
    IWishlist2DAO wishlist2DAO;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("orders2/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Cart2> pList = cart2Service.getAll();
        map.put("pList", pList);
        return new ModelAndView("orders2/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Orders2 o2 = orders2Service.save(request);
        Invoice2 in = invoice2Service.save(request);
        stock2Service.save(request);
        int cid = Integer.parseInt(request.getParameter("cid"));
        cart2Service.deleteByCid(cid);
        Map<String, Object> map = new HashMap<>();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        map.put("count", count);
        map.put("wishCount", wishCount);
        map.put("o2", o2);
        return new ModelAndView("redirect:/checkout2/congrats"); //To change body of generated methods, choose Tools | Templates.
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
        List<Orders2> pList = orders2Service.getAll();
        map.put("pList", pList);
        return new ModelAndView("orders2/view", "map", map);
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public ModelAndView details() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Invoice2> inList = invoice2Service.getAll();
        List<Orders2> oList = orders2Service.getAll();
        map.put("inList", inList);
        map.put("oList", oList);
        return new ModelAndView("orders2/details", "map", map);
    }
}
