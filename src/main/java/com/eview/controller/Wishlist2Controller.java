package com.eview.controller;

import com.eview.controller.impl.IWishlist2Controller;
import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.IWishlist2DAO;
import com.eview.model.Goods;
import com.eview.model.Wishlist2;
import com.eview.service.impl.IGoodsService;
import com.eview.service.impl.IOrders2Service;
import com.eview.service.impl.IPurchase2Service;
import com.eview.service.impl.IWishlist2Service;
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
@RequestMapping(value = "wishlist2")
public class Wishlist2Controller implements IWishlist2Controller {

    @Autowired
    IWishlist2Service wishlist2Service;

    @Autowired
    IGoodsService goodsService;

    @Autowired
    IPurchase2Service purchase2Service;

    @Autowired
    IWishlist2DAO wishlist2DAO;

    @Autowired
    IOrders2Service orders2Service;

    @Autowired
    ICart2DAO cart2DAO;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("cart2/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> cList = goodsService.getAll();
        map.put("cList", cList);
        return new ModelAndView("cart2/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Wishlist2 wish = wishlist2Service.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("wish", wish);
        return new ModelAndView("redirect:/goods/view", "map", map); //To change body of generated methods, choose Tools | Templates.
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
        Wishlist2 cat = wishlist2Service.delete(id);
        return new ModelAndView("redirect:/wishlist2/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        long wishCount = wishlist2DAO.getWishlist2Count();
        long count = cart2DAO.getCart2Count();
        List<Wishlist2> gList = wishlist2Service.getAll();
        map.put("gList", gList);
        map.put("wishCount", wishCount);
        map.put("count", count);
        return new ModelAndView("wishlist2/view", "map", map);
    }

    @RequestMapping(value = "/view2", method = RequestMethod.GET)
    public ModelAndView getAll2() {
        Map<String, Object> map = new HashMap<String, Object>();
        long wishCount = wishlist2DAO.getWishlist2Count();
        long count = cart2DAO.getCart2Count();
        List<Wishlist2> pList = wishlist2Service.getAll();
        map.put("pList", pList);
        map.put("wishCount", wishCount);
        map.put("count", count);
        return new ModelAndView("wishlist2/view2", "map", map);
    }

}
