/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Sales;
import java.util.List;


public interface ISalesDAO extends ICommonDAO<Sales>{
    public List<Sales> getByOrderNo(int orderNo);
    public String deleteByOrderNo(int orderNo);
}
