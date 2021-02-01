/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service;

import com.eview.dao.impl.ITermsAndConditionsDAO;
import com.eview.model.TermsAndCondition;
import com.eview.service.impl.ITermsAndConditionsService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service(value = "termsAndConditionsService")
public class TermsAndConditionsService implements ITermsAndConditionsService{
    
    @Autowired
    ITermsAndConditionsDAO termsAndConditionsDAO;

    @Override
    public TermsAndCondition save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        TermsAndCondition t = new TermsAndCondition();
        t.setTitle(map.get("title")[0]);
        return termsAndConditionsDAO.save(t);
    }
    
    @Override
    public TermsAndCondition update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        TermsAndCondition t = new TermsAndCondition();
        t.setId(Integer.parseInt(map.get("id")[0]));
        t.setTitle(map.get("title")[0]);
        return termsAndConditionsDAO.update(t);
    }
    
    @Override
    public TermsAndCondition delete(int id) {
        return termsAndConditionsDAO.delete(id);
    }
    
    @Override
    public List<TermsAndCondition> getAll() {
        return termsAndConditionsDAO.getAll();
    }
    
    @Override
    public TermsAndCondition getById(int id) {
        return termsAndConditionsDAO.getById(id);
    }


    
    
}
