/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service;

import com.eview.dao.impl.IBankDAO;
import com.eview.model.Bank;
import com.eview.service.impl.IBankService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B12
 */
@Service(value = "bankService")
public class BankService implements IBankService {
    
    @Autowired
    IBankDAO bankDAO;
    
    @Override
    public Bank save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Bank t = new Bank();
        t.setName(map.get("name")[0]);
        return bankDAO.save(t);
    }
    
    @Override
    public Bank update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Bank t = new Bank();
        t.setId(Integer.parseInt(map.get("id")[0]));
        t.setName(map.get("name")[0]);
        return bankDAO.update(t);
    }
    
    @Override
    public Bank delete(int id) {
        return bankDAO.delete(id);
    }
    
    @Override
    public List<Bank> getAll() {
        return bankDAO.getAll();
    }
    
    @Override
    public Bank getById(int id) {
        return bankDAO.getById(id);
    }
    
}
