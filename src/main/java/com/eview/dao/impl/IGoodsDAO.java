/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Goods;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author B12
 */
public interface IGoodsDAO extends ICommonDAO<Goods>{

    public Goods save(HttpServletRequest request);
    
}
