package com.eview.controller;

import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.ICartDAO;
import com.eview.dao.impl.IWishlist2DAO;
import com.eview.dao.impl.IWishlistDAO;
import com.eview.model.Production;
import com.eview.service.impl.IProductionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    ICartDAO cartDAO;
    @Autowired
    ICart2DAO cart2DAO;

    @Autowired
    IProductionService productionService;

    @Autowired
    IWishlistDAO wishlistDAO;

    @Autowired
    IWishlist2DAO wishlist2DAO;
    
    @RequestMapping(value = "")
    public ModelAndView index() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cartDAO.getCartCount();
        long wishCount = wishlistDAO.getWishlistCount();
        map.put("count", count);
        map.put("wishCount", wishCount);
        return new ModelAndView("index", "map", map);
    }

    @RequestMapping(value = "/cart")
    public String cart() {

        return "home/cart";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "home/login";
    }

    @RequestMapping(value = "/login2")
    public String login1() {
        return "login/login2";
    }

    @RequestMapping(value = "/login3")
    public String login2() {
        return "login/login3";
    }

    @RequestMapping(value = "/log")
    public String log() {
        return "home/log";
    }

    @RequestMapping(value = "/product")
    public String product() {
        return "home/product";
    }

    @RequestMapping(value = "/myAccount")
    public String myAccount() {
        return "home/myAccount";
    }

    @RequestMapping(value = "/productDetails")
    public String productDetails() {

        return "home/productDetails";
    }

    @RequestMapping(value = "/productList")
    public String productList() {
        return "home/productList";
    }

    @RequestMapping(value = "/checkout")
    public String checkout() {
        return "home/checkout";
    }

    @RequestMapping(value = "/wishlist")
    public String wishlist() {
        return "home/wishlist";
    }

    @RequestMapping(value = "/contact")
    public String contact() {
        return "home/contact";
    }

    @RequestMapping(value = "/adminDashboard")
    public String adminDashboard() {
        return "home/adminDashboard";
    }

    @RequestMapping(value = "/marchentDashboard")
    public String marchentDashboard() {
        return "home/marchentDashboard";
    }

    @RequestMapping(value = "/customerDashboard")
    public String customerDashboard() {
        return "home/customerDashboard";
    }

    @RequestMapping(value = "/adminLogin")
    public String adminLogin() {
        return "log/adminLogin";
    }

    @RequestMapping(value = "/marchentLogin")
    public String marchentLogin() {
        return "log/marchentLogin";
    }

    @RequestMapping(value = "/customerLogin")
    public String customerLogin() {
        return "log/customerLogin";
    }

    @RequestMapping(value = "/productPage")
    public String productPage() {
        return "production/productPage";
    }

    @RequestMapping(value = "/merchant")
    public ModelAndView merchant() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        map.put("count", count);
        map.put("wishCount", wishCount);
        return new ModelAndView("home/merchant", "map", map);
    }
}
