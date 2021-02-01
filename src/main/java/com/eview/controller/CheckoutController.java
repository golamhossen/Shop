package com.eview.controller;

import com.eview.controller.impl.ICheckoutController;
import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.ICartDAO;
import com.eview.dao.impl.IWishlist2DAO;
import com.eview.dao.impl.IWishlistDAO;
import com.eview.model.Checkout;
import com.eview.model.Country;
import com.eview.model.Invoice;
import com.eview.model.Invoice2;
import com.eview.service.impl.ICheckoutService;
import com.eview.service.impl.ICountryService;
import com.eview.service.impl.IInvoice2Service;
import com.eview.service.impl.IInvoiceService;
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
@RequestMapping(value = "checkout")
public class CheckoutController implements ICheckoutController {

    @Autowired
    ICheckoutService checkoutService;

    @Autowired
    ICountryService countryService;

    @Autowired
    ICartDAO cartDAO;

    @Autowired
    ICart2DAO cart2DAO;

    @Autowired
    IWishlist2DAO wishlist2DAO;
    
    @Autowired
    IWishlistDAO wishlistDAO;

    @Autowired
    IInvoiceService invoiceService;

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
        List<Country> cList = countryService.getAll();
        List<Invoice> inList = invoiceService.getAll();
        long count = cartDAO.getCartCount();
        long wishCount = wishlistDAO.getWishlistCount();
        map.put("count", count);
        map.put("wishCount", wishCount);
        map.put("inList", inList);
        map.put("cList", cList);
        
        return new ModelAndView("checkout/create", "map", map);
    }

    @RequestMapping(value = "/create2")
    public ModelAndView create2() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Country> cList = countryService.getAll();
        List<Invoice2> inList = invoice2Service.getAll();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        map.put("wishCount", wishCount);
        map.put("cList", cList);
        map.put("count", count);
        map.put("inList", inList);
        return new ModelAndView("checkout/create2", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Checkout t = checkoutService.save(request);
        Map<String, Object> map = new HashMap<>();
        long count = cartDAO.getCartCount();
        List<Invoice> inList = invoiceService.getAll();
        map.put("inList", inList);
        map.put("t", t);
        map.put("count", count);
        return new ModelAndView("redirect:/payment/create", "map", map);

    }

    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    public ModelAndView save2(HttpServletRequest request) {
        Checkout t = checkoutService.save(request);
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        List<Invoice> inList = invoiceService.getAll();
        map.put("inList", inList);
        map.put("count", count);
        map.put("wishCount", wishCount);
        map.put("t", t);
        return new ModelAndView("/payment2/create", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Checkout c = checkoutService.getById(id);
        c.setId(id);
        return new ModelAndView("checkout/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Checkout c = checkoutService.update(request);
        return new ModelAndView("checkout/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Checkout c = checkoutService.delete(id);
        return new ModelAndView("redirect:/checkout/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Checkout> chList = checkoutService.getAll();
        map.put("chList", chList);
        return new ModelAndView("checkout/view", "map", map);
    }

    @RequestMapping(value = "/congrats", method = RequestMethod.GET)
    public ModelAndView getAll2() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cartDAO.getCartCount();
        long wishCount = wishlistDAO.getWishlistCount();
        List<Checkout> chList = checkoutService.getAll();
         map.put("count", count);
        map.put("wishCount", wishCount);
        map.put("chList", chList);
        return new ModelAndView("checkout/congrats", "map", map);
    }

    @RequestMapping(value = "/congrats2", method = RequestMethod.GET)
    public ModelAndView getAll3() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Checkout> chList = checkoutService.getAll();
        map.put("chList", chList);
        return new ModelAndView("checkout/congrats2", "map", map);
    }

}
