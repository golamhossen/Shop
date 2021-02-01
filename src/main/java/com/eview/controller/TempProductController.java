
package com.eview.controller;

import com.eview.controller.impl.ITempProductController;
import com.eview.model.Orders;
import com.eview.model.TempProduct;
import com.eview.service.impl.ICartService;
import com.eview.service.impl.IOrdersService;
import com.eview.service.impl.ITempProductService;
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
@RequestMapping(value = "tempProduct")
public class TempProductController implements ITempProductController{

    @Autowired
    ITempProductService tempProductService;
    
    @Autowired
    IOrdersService ordersService;
    
    @Autowired
    ICartService cartService;
    
//    @RequestMapping(value = "/register")
//    public ModelAndView register(){
//        return new ModelAndView("tempProduct/register");
//    }
//    
//    @RequestMapping(value = "/login")
//    public ModelAndView login(){
//        return new ModelAndView("tempProduct/login");
//    }
    
    
   @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("tempProduct/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Orders> cList = ordersService.getAll();
        map.put("cList", cList);
        return new ModelAndView("tempProduct/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        TempProduct m = tempProductService.save(request);
//        int cid = Integer.parseInt(request.getParameter("cid"));
//        cartService.deleteByCid(cid);
        List<TempProduct> temList = tempProductService.getAll();
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        map.put("temList", temList);
        return new ModelAndView("redirect:/orders/view"); //To change body of generated methods, choose Tools | Templates.
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
    public ModelAndView delete(int id) {
TempProduct tem = tempProductService.delete(id);
return new ModelAndView("redirect:/tempProduct/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<TempProduct> pList = tempProductService.getAll();
        map.put("pList", pList);
        return new ModelAndView("tempProduct/view", "map", map);
    }

    
}
