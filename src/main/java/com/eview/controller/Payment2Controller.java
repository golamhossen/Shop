package com.eview.controller;

import com.eview.controller.impl.IPayment2Controller;
import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.IWishlist2DAO;
import com.eview.model.Checkout;
import com.eview.model.Checkout2;
import com.eview.model.Invoice2;
import com.eview.model.Payment2;
import com.eview.service.impl.ICheckout2Service;
import com.eview.service.impl.ICheckoutService;
import com.eview.service.impl.IInvoice2Service;
import com.eview.service.impl.IPayment2Service;
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
@RequestMapping(value = "payment2")
public class Payment2Controller implements IPayment2Controller {

    @Autowired
    IPayment2Service payment2Service;

    @Autowired
    ICheckout2Service checkout2Service;

    @Autowired
    ICart2DAO cart2DAO;

    @Autowired
    IWishlist2DAO wishlist2DAO;
    
    @Autowired
    IInvoice2Service invoice2Service;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("payment2/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Checkout2> chList = checkout2Service.getAll();
         List<Invoice2> inList = invoice2Service.getAll();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        map.put("wishCount", wishCount);
        map.put("chList", chList);
        map.put("count", count);
        map.put("inList", inList);
        return new ModelAndView("payment2/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Payment2 pay = payment2Service.save(request);
        Map<String, Object> map = new HashMap<>();
        List<Checkout2> cList = checkout2Service.getAll();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        map.put("count", count);
        map.put("wishCount", wishCount);
        map.put("cList", cList);
        map.put("pay", pay);
        return new ModelAndView("redirect:/cart2/view", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Payment2 c = payment2Service.getById(id);
        c.setId(id);
        return new ModelAndView("payment2/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Payment2 c = payment2Service.update(request);
        return new ModelAndView("payment2/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Payment2 c = payment2Service.delete(id);
        return new ModelAndView("redirect:/payment2/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Payment2> cList = payment2Service.getAll();
        map.put("cList", cList);
        return new ModelAndView("payment2/view", "map", map);
    }

}
