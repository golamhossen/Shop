/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Cart2;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ICart2Service extends ICommonService<Cart2>{
     public String deleteByCid(int cid);

    public List<Cart2> getByCid(int cid);
}
