package com.eview.controller;

import com.eview.controller.impl.IProductionController;
import com.eview.dao.impl.ICartDAO;
import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.IProductionDAO;
import com.eview.dao.impl.IWishlistDAO;
import com.eview.model.Cart2;
import com.eview.model.Category;
import com.eview.model.Goods;
import com.eview.model.Production;
import com.eview.service.impl.ICart2Service;
import com.eview.service.impl.ICategoryService;
import com.eview.service.impl.IGoodsService;
import com.eview.service.impl.IProductionService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "production")
public class ProductionController implements IProductionController {

    @Autowired
    IProductionService productionService;

    @Autowired
    IProductionDAO productionDAO;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ICategoryDAO categoryDAO;

    @Autowired
    ServletContext servletContext;

    @Autowired
    ICartDAO cartDAO;

    @Autowired
    IGoodsService goodsService;

    @Autowired
    IWishlistDAO wishlistDAO;

    //    Method for Image Upload. This is a method without service layer
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ModelAndView store(HttpServletRequest request, @RequestParam("photo") MultipartFile file) throws IOException {

        String name = request.getParameter("name");
        String code = request.getParameter("code");
        //Get Category by category id
        int id = Integer.parseInt(request.getParameter("cid"));
        Category c = categoryDAO.getById(id);
        String sp = request.getParameter("sp");
        String des = request.getParameter("des");

        Double price = Double.parseDouble(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));

        Production p = new Production();
        p.setName(name);
        p.setCode(code);
        p.setCid(c.getId());
        p.setCname(c.getName());
        p.setSp(sp);
        p.setDes(des);
        p.setPrice(price);
        String photo = file.getOriginalFilename();
        saveFile(file, photo, "/resources/home/img");
        p.setPhoto(photo);
        p.setDiscount(discount);
        Production t = productionDAO.save(p);
        //}
        return new ModelAndView("production/create");

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
        return new ModelAndView("production/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Category> cList = categoryService.getAll();
        map.put("cList", cList);
        return new ModelAndView("production/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Production m = productionService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("/production/create", "map", map); //To change body of generated methods, choose Tools | Templates.
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
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cartDAO.getCartCount();
        long wishCount = wishlistDAO.getWishlistCount();
        System.out.println("a");
        List<Goods> gList = goodsService.getAll();
        map.put("gList", gList);
        List<Production> pList = productionService.getAll();
        map.put("pList", pList);
        map.put("count", count);
        map.put("wishCount", wishCount);
        return new ModelAndView("production/view", "map", map);
    }

    @RequestMapping(value = "/view2", method = RequestMethod.GET)
    public ModelAndView getAll2() {
        Map<String, Object> map = new HashMap<String, Object>();
        long count = cartDAO.getCartCount();
        System.out.println("a");
        List<Production> pList = productionService.getAll();
        map.put("pList", pList);
        map.put("count", count);
        return new ModelAndView("production/view2", "map", map);
    }

}
