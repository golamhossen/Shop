/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.controller;

import com.eview.controller.impl.ITermsAndConditionController;
import com.eview.dao.impl.ITermsAndConditionsDAO;
import com.eview.model.TermsAndCondition;
import com.eview.service.impl.ITermsAndConditionsService;
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
 * @author HP
 */
@Controller
@RequestMapping(value = "tac")
public class TermsAndConditionController implements ITermsAndConditionController{
    
    
    @Autowired
    ITermsAndConditionsService termsAndConditionsService;
    @Autowired
    ITermsAndConditionsDAO termsAndConditionsDAO;
    
    @Autowired
    ServletContext servletContext;
    
    
    //    Method for Image Upload. This is a method without service layer
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ModelAndView store(HttpServletRequest request, @RequestParam("files") MultipartFile file) throws IOException {

        String title = request.getParameter("title");
       

        TermsAndCondition p = new TermsAndCondition();
        p.setTitle(title);
        
        String tac = file.getOriginalFilename();
        saveFile(file, tac, "/resources/home/img");
        p.setFiles(tac);
        TermsAndCondition t = termsAndConditionsDAO.save(p);
        //}
        return new ModelAndView("tac/create");

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

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("tac/create");
    }

   @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {

        TermsAndCondition t = termsAndConditionsService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/tac/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        TermsAndCondition cat = termsAndConditionsService.getById(id);
        cat.setId(id);
        return new ModelAndView("tac/update", "cat", cat);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        TermsAndCondition cat = termsAndConditionsService.update(request);
        return new ModelAndView("tac/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        TermsAndCondition cat = termsAndConditionsService.delete(id);
        return new ModelAndView("redirect:/tac/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<TermsAndCondition> banList = termsAndConditionsService.getAll();
        map.put("banList", banList);
        return new ModelAndView("tac/view", "map", map);
    }
    
}
