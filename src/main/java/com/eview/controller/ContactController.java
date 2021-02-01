package com.eview.controller;

import com.eview.controller.impl.IContactController;
import com.eview.model.Contact;
import com.eview.service.impl.IContactService;
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
@RequestMapping(value = "contact")
public class ContactController implements IContactController {

    @Autowired
    IContactService contactService;

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
        return new ModelAndView("contact/create");
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {

        Contact t = contactService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("t", t);
        return new ModelAndView("/contact/create", "map", map);
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact cat = contactService.getById(id);
        cat.setId(id);
        return new ModelAndView("contact/update", "cat", cat);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request) {
        Contact cat = contactService.update(request);
        return new ModelAndView("contact/update");
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        Contact cat = contactService.delete(id);
        return new ModelAndView("redirect:/contact/view");
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Contact> conList = contactService.getAll();
        map.put("conList", conList);
        return new ModelAndView("contact/view", "map", map);
    }
}
