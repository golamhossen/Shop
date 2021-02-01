
package com.eview.controller;

import com.eview.controller.impl.IMarchentController;
import com.eview.model.Category;
import com.eview.model.Marchent;
import com.eview.service.impl.ICategoryService;
import com.eview.service.impl.IMarchentService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "marchent")
public class MarchentController implements IMarchentController {

    @Autowired
    IMarchentService marchentService;

    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("marchent/update");
    }

    @Override
    @RequestMapping(value = "/create")

    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Category> cList = categoryService.getAll();
        map.put("cList", cList);
        return new ModelAndView("marchent/create", "map", map);

    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Marchent m = marchentService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("/marchent/create", "map", map);
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
        List<Marchent> maList = marchentService.getAll();
        map.put("maList", maList);
        return new ModelAndView("marchent/view", "map", map);
    }

}
