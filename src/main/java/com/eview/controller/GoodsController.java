/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.controller;

import com.eview.controller.impl.IGoodsController;
import com.eview.dao.impl.IBrandDAO;
import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.IGoodsDAO;
import com.eview.dao.impl.IWishlist2DAO;
import com.eview.model.Brand;
import com.eview.model.Category;
import com.eview.model.Goods;
import com.eview.service.impl.IBrandService;
import com.eview.service.impl.ICategoryService;
import com.eview.service.impl.IGoodsService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B12
 */
@Controller
@RequestMapping(value = "goods")
public class GoodsController implements IGoodsController {

    @Autowired
    IGoodsService goodsService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ServletContext servletContext;

    @Autowired
    ICategoryDAO categoryDAO;

    @Autowired
    IBrandDAO brandDAO;

    @Autowired
    IGoodsDAO goodsDAO;

    @Autowired
    IBrandService brandService;
    @Autowired
    ICart2DAO cart2DAO;
    
    @Autowired
    IWishlist2DAO wishlist2DAO;

    //    Method for Image Upload. This is a method without service layer
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ModelAndView store(HttpServletRequest request, @RequestParam("photo") MultipartFile file) throws IOException {

        String name = request.getParameter("name");
        String code = request.getParameter("code");
        //Get Category by category id
        int cid = Integer.parseInt(request.getParameter("cid"));
        int bid = Integer.parseInt(request.getParameter("bid"));
        Category c = categoryDAO.getById(cid);
        Brand b = brandDAO.getById(bid);
        String sp = request.getParameter("sp");
        String des = request.getParameter("des");
        double price = Double.parseDouble(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));

        Goods p = new Goods();
        p.setName(name);
        p.setCode(code);
        p.setCid(c.getId());
        p.setCname(c.getName());
        p.setBid(b.getId());
        p.setBname(b.getName());
        p.setSp(sp);
        p.setDes(des);
        p.setPrice(price);
        String photo = file.getOriginalFilename();
        saveFile(file, photo, "/resources/home/img");
        p.setPhoto(photo);
        p.setDiscount(discount);
        Goods t = goodsDAO.save(p);

        return new ModelAndView("goods/create");

    }

    private void saveFile(MultipartFile file, String fileName, String path) throws IOException {
        System.out.println("Start");
        byte[] bytes = file.getBytes();
        String filePath = servletContext.getRealPath(path);
        File directory = new File(filePath);
        File cFile = new File(
                "G:\\Spring\\Project\\New folder\\New folder\\Shop\\src\\main\\webapp\\resources\\home\\img"
                + File.separator + fileName);

        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(cFile));
        stream.write(bytes);
        stream.close();
        System.out.println(cFile);
    }

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("goods/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<>();
        List<Category> cList = categoryService.getAll();
        map.put("cList", cList);
        List<Brand> bList = brandService.getAll();
        map.put("bList", bList);
        return new ModelAndView("goods/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Goods t = goodsService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/goods/create", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Goods c = goodsService.getById(id);
        c.setId(id);
        return new ModelAndView("goods/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Goods c = goodsService.update(request);
        return new ModelAndView("goods/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Goods c = goodsService.delete(id);
        return new ModelAndView("redirect:/goods/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cart2DAO.getCart2Count();
        long wishCount = wishlist2DAO.getWishlist2Count();
        List<Goods> gList = goodsService.getAll();
        map.put("gList", gList);
        map.put("count", count);
        map.put("wishCount", wishCount);
        return new ModelAndView("goods/view", "map", map);
    }

    @RequestMapping(value = "/view2", method = RequestMethod.GET)
    public ModelAndView getAll2() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cart2DAO.getCart2Count();
        List<Goods> gList = goodsService.getAll();
         long wishCount = wishlist2DAO.getWishlist2Count();
        map.put("gList", gList);
        map.put("count", count);
        map.put("wishCount", wishCount);
        return new ModelAndView("goods/view2", "map", map);
    }

}
