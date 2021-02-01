package com.eview.controller;

import com.eview.controller.impl.ICartController;
import com.eview.dao.impl.ICartDAO;
import com.eview.dao.impl.IWishlistDAO;
import com.eview.model.Cart;
import com.eview.model.Production;
import com.eview.service.impl.ICartService;
import com.eview.service.impl.IOrdersService;
import com.eview.service.impl.IProductionService;
import com.eview.service.impl.IPurchaseService;
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
@RequestMapping(value = "cart")
public class CartController implements ICartController {

    @Autowired
    ICartService cartService;

    @Autowired
    IProductionService productionService;

    @Autowired
    IPurchaseService purchaseService;

    @Autowired
    ICartDAO cartDAO;

    @Autowired
    IOrdersService ordersService;
    
    @Autowired
    IWishlistDAO wishlistDAO;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("cart/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Production> cList = productionService.getAll();
        map.put("cList", cList);
        return new ModelAndView("cart/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Cart m = cartService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("redirect:/production/view"); //To change body of generated methods, choose Tools | Templates.
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
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Cart cat = cartService.delete(id);
        return new ModelAndView("redirect:/cart/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cartDAO.getCartCount();
        List<Cart> pList = cartService.getAll();
        long wishCount = wishlistDAO.getWishlistCount();
        map.put("wishCount", wishCount);
        map.put("pList", pList);
        map.put("count", count);
        return new ModelAndView("cart/view", "map", map);
    }

    @RequestMapping(value = "/view2", method = RequestMethod.GET)
    public ModelAndView getAll2() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cartDAO.getCartCount();
        List<Cart> pList = cartService.getAll();
        long wishCount = wishlistDAO.getWishlistCount();
        map.put("wishCount", wishCount);
        map.put("pList", pList);
        map.put("count", count);
        return new ModelAndView("cart/view2", "map", map);
    }

//    @RequestMapping(value = "/view3", method = RequestMethod.GET)
//    public ModelAndView getAll3() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<Purchase> pList = purchaseService.getAll();
//        map.put("pList", pList);
//        return new ModelAndView("cart/view3", "map", map);
//    }
}
