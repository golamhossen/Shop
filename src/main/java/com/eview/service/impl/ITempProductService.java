/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.TempProduct;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ITempProductService extends ICommonService<TempProduct>{
    public String deleteByCid(int cid);
     public List<TempProduct> getByCid(int cid);
}
