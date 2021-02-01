
package com.eview.controller;

import com.eview.controller.impl.ICheckout2Controller;
import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.IWishlist2DAO;
import com.eview.model.Checkout2;
import com.eview.model.Country;
import com.eview.model.Invoice2;
import com.eview.service.impl.ICheckout2Service;
import com.eview.service.impl.ICountryService;
import com.eview.service.impl.IInvoice2Service;
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

@Controller
@RequestMapping(value = "checkout2")
public class Checkout2Controller implements ICheckout2Controller{

    @Autowired
    ICheckout2Service checkout2Service;

    @Autowired
    ICountryService countryService;

    @Autowired
    ICart2DAO cart2DAO;

    

    @Autowired
    IWishlist2DAO wishlist2DAO;
    

    @Autowired
    IInvoice2Service invoice2Service;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("checkout/update");
    }

    @Override

    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Checkout2> chList = checkout2Service.getAll();
        List<Country> cList = countryService.getAll();
        List<Invoice2> inList = invoice2Service.getAll();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        map.put("wishCount", wishCount);
        map.put("count", count);
        map.put("chList", chList);
        map.put("inList", inList);
        map.put("cList", cList);
        return new ModelAndView("checkout2/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Checkout2 t = checkout2Service.save(request);
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        List<Invoice2> inList = invoice2Service.getAll();
        map.put("inList", inList);
        map.put("count", count);
        map.put("wishCount", wishCount);
        map.put("t", t);
        return new ModelAndView("redirect:/payment2/create", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Checkout2 c = checkout2Service.getById(id);
        c.setId(id);
        return new ModelAndView("checkout/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Checkout2 c = checkout2Service.update(request);
        return new ModelAndView("checkout2/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Checkout2 c = checkout2Service.delete(id);
        return new ModelAndView("redirect:/checkout/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Checkout2> chList = checkout2Service.getAll();
        map.put("chList", chList);
        return new ModelAndView("checkout2/view", "map", map);
    }

    @RequestMapping(value = "/congrats", method = RequestMethod.GET)
    public ModelAndView getAll2() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Checkout2> chList = checkout2Service.getAll();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        map.put("wishCount", wishCount);
        map.put("count", count);
        map.put("chList", chList);
        return new ModelAndView("checkout2/congrats", "map", map);
    }

    

    
}
