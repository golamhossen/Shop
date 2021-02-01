package com.eview.controller;

import com.eview.controller.impl.ICart2Controller;
import com.eview.dao.impl.ICart2DAO;
import com.eview.model.Cart2;
import com.eview.model.Goods;
import com.eview.service.impl.ICart2Service;
import com.eview.service.impl.IGoodsService;
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
@RequestMapping(value = "cart2")
public class Cart2Controller implements ICart2Controller {

    @Autowired
    ICart2Service cart2Service;

    @Autowired
    IGoodsService goodsService;

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
        Cart2 m = cart2Service.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("redirect:/goods/view"); //To change body of generated methods, choose Tools | Templates.
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
        Cart2 cat = cart2Service.delete(id);
        return new ModelAndView("redirect:/cart2/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cart2DAO.getCart2Count();
        List<Cart2> gList = cart2Service.getAll();
        map.put("gList", gList);
        map.put("count", count);
        return new ModelAndView("cart2/view", "map", map);
    }

    @RequestMapping(value = "/view2", method = RequestMethod.GET)
    public ModelAndView getAll2() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cart2DAO.getCart2Count();
        List<Cart2> gList = cart2Service.getAll();
        map.put("gList", gList);
        map.put("count", count);
        return new ModelAndView("cart2/view2", "map", map);
    }

}
