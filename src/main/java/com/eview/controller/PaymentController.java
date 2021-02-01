package com.eview.controller;

import com.eview.controller.impl.IPaymentController;
import com.eview.dao.impl.ICartDAO;
import com.eview.dao.impl.IWishlistDAO;
import com.eview.model.Checkout;
import com.eview.model.Payment;
import com.eview.service.impl.ICheckoutService;
import com.eview.service.impl.IPaymentService;
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
@RequestMapping(value = "payment")
public class PaymentController implements IPaymentController {

    @Autowired
    IPaymentService paymentService;

    @Autowired
    ICheckoutService checkoutService;

    @Autowired
    ICartDAO cartDAO;

    @Autowired
    IWishlistDAO wishlistDAO;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("payment/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Checkout> cList = checkoutService.getAll();
        long count = cartDAO.getCartCount();
        long wishCount = wishlistDAO.getWishlistCount();
        map.put("count", count);
        map.put("wishCount", wishCount);
        map.put("cList", cList);
        return new ModelAndView("payment/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Payment pay = paymentService.save(request);
        Map<String, Object> map = new HashMap<>();
        long count = cartDAO.getCartCount();
        long wishCount = wishlistDAO.getWishlistCount();
        map.put("count", count);
        map.put("wishCount", wishCount);
        map.put("pay", pay);
        return new ModelAndView("redirect:/cart/view", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Payment c = paymentService.getById(id);
        c.setId(id);
        return new ModelAndView("payment/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Payment c = paymentService.update(request);
        return new ModelAndView("payment/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Payment c = paymentService.delete(id);
        return new ModelAndView("redirect:/payment/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Payment> cList = paymentService.getAll();
        map.put("cList", cList);
        return new ModelAndView("payment/view", "map", map);
    }

}
