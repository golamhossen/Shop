
package com.eview.controller;

import com.eview.controller.impl.ICustomerController;
import com.eview.model.City;
import com.eview.model.Country;
import com.eview.model.Customer;
import com.eview.service.impl.ICityService;
import com.eview.service.impl.ICountryService;
import com.eview.service.impl.ICustomerService;
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
 * @author B12
 */
@Controller
@RequestMapping(value = "customer")
public class CustomerController implements ICustomerController{
    
    @Autowired
    ICustomerService customerService;
    
    @Autowired
    ICountryService countryService;
    
    @Autowired
    ICityService cityService;

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("customer/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Country> cList = countryService.getAll();
        map.put("cList", cList);
        
        List<City> cityList = cityService.getAll();
        map.put("cityList", cityList);
        return new ModelAndView("customer/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Customer t = customerService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/customer/create", "map", map);

    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer c = customerService.getById(id);
        c.setId(id);
        return new ModelAndView("customer/update", "c", c);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Customer c = customerService.update(request);
        return new ModelAndView("customer/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Customer c = customerService.delete(id);
        return new ModelAndView("redirect:/customer/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Customer> cList = customerService.getAll();
        map.put("cList", cList);
        return new ModelAndView("customer/view", "map", map);
    }

    
}
