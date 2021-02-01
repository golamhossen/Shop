
package com.eview.controller;

import com.eview.common.ICommonController;
import com.eview.model.AboutUs;
import com.eview.service.impl.IAboutUsService;
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

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "aboutus")
public class AboutUsController implements ICommonController{
    
    @Autowired
    IAboutUsService aboutUsService;

   @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("aboutus/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {

        AboutUs t = aboutUsService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/aboutus/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        AboutUs cat = aboutUsService.getById(id);
        cat.setId(id);
        return new ModelAndView("aboutus/update", "cat", cat);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        AboutUs cat = aboutUsService.update(request);
        return new ModelAndView("aboutus/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        AboutUs cat = aboutUsService.delete(id);
        return new ModelAndView("redirect:/aboutus/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<AboutUs> banList = aboutUsService.getAll();
        map.put("banList", banList);
        return new ModelAndView("aboutus/view", "map", map);
    }
    
}
