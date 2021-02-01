/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Sales;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ISalesService extends ICommonService<Sales>{
     public List<Sales> getByOrderNo(int orderNo);
    public String deleteByOrderNo(int orderNo);
    
     public double getTotalPrice();
    public int getTotalQty();
}
